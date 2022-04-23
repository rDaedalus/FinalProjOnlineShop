package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseController;
import model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	Connection connection = null;
	DataBaseController dbControl = new DataBaseController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// try{
		// 	UIManager.setLookAndFeel(
		// 		UIManager.getSystemLookAndFeelClassName());
		// } catch(Exception e){

		// }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// LoginPage frame = new LoginPage();
					// frame.setVisible(true);
					OrderMenu n = new OrderMenu();
					n.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		connection = dbControl.Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(27, 75, 66, 14);
		contentPane.add(userNameLabel);

		JLabel passworLabel = new JLabel("password");
		passworLabel.setBounds(27, 124, 66, 14);
		contentPane.add(passworLabel);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(119, 72, 86, 20);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);

		passwordTxt = new JTextField();
		passwordTxt.setBounds(119, 121, 86, 20);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUsername(userNameTxt.getText());
				user.setPassword(passwordTxt.getText());
				dbControl.Login(connection, user);
				dispose();
			}
		});
		btnNewButton.setBounds(92, 188, 89, 23);
		contentPane.add(btnNewButton);
	}

}
