package view.CustomerService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseController;
import model.Complain;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class TechnicalErrors extends JFrame {
	Connection connection = null;
	DataBaseController dbControl = new DataBaseController();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TechnicalErrors() {
		connection = dbControl.Connect();

		setBounds(100, 100, 552, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Technical  Errors");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 123, 227, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 247, 127, 20);
		contentPane.add(textField);

		JLabel lblConcern = new JLabel("Customer ID:");
		lblConcern.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern.setBounds(10, 248, 127, 19);
		contentPane.add(lblConcern);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 424, 281, 79);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("assets\\submit iconz.PNG"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Complain c = new Complain();
				lblNewLabel_1.setText(
						"<html>We're sorry you got a technical errors. In the name of my firm, I apologize for any inconvenience. <br/> In order to avoid faulty products, we will do our best to solve this problem.</html>");
				c.setCustomerId(Integer.parseInt(textField.getText()));
				c.setCustomerConcern(textField.getText());
				dbControl.prepAddComplain(connection, c);
			}
		});
		btnNewButton.setBounds(414, 441, 97, 40);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Customer Service");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setBounds(79, 23, 297, 38);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("assets\\icon oshopp.png"));
		lblNewLabel_2.setBounds(10, 0, 74, 79);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("assets\\backgroud oshopping.jpg"));
		lblNewLabel_4.setBounds(-143, 90, 680, 79);
		contentPane.add(lblNewLabel_4);

		JLabel lblConcern_1 = new JLabel("Concern:");
		lblConcern_1.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern_1.setBounds(10, 278, 127, 19);
		contentPane.add(lblConcern_1);

		JLabel lblNewLabel_5 = new JLabel("Unable to Place Order");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(130, 168, 217, 40);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Please describe your issue below.");
		lblNewLabel_6.setIcon(new ImageIcon("assets\\xnote icon.PNG"));
		lblNewLabel_6.setBounds(131, 198, 267, 38);
		contentPane.add(lblNewLabel_6);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(10, 296, 319, 124);
		contentPane.add(textPane_1);

	}

}
