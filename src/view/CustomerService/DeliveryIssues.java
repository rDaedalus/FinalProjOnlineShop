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

public class DeliveryIssues extends JFrame {
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
	public DeliveryIssues() {
		connection = dbControl.Connect();

		setBounds(100, 100, 547, 651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delivery Issues");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(133, 109, 196, 23);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(115, 299, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblConcern = new JLabel("Customer ID:");
		lblConcern.setForeground(new Color(0, 0, 128));
		lblConcern.setBackground(new Color(0, 0, 128));
		lblConcern.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern.setBounds(20, 300, 127, 19);
		contentPane.add(lblConcern);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(20, 361, 319, 134);
		contentPane.add(textPane);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 510, 250, 80);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("assets\\submit iconz.PNG"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Complain c = new Complain();
				lblNewLabel_1.setText(
						"<html>We're sorry you got a devlivery issues. In the name of my firm, I apologize for any inconvenience. <br/> In order to avoid faulty products, we will do our best to solve this problem.</html>");
				c.setCustomerId(Integer.parseInt(textField.getText()));
				c.setCustomerConcern(textPane.getText());
				dbControl.prepAddComplain(connection, c);
			}
		});
		btnNewButton.setBounds(396, 552, 98, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Customer Service");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setBounds(74, 11, 297, 38);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("assets\\icon oshopp.png"));
		lblNewLabel_2.setBounds(10, 0, 74, 69);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("assets\\backgroud oshopping.jpg"));
		lblNewLabel_4.setBounds(-159, 83, 689, 74);
		contentPane.add(lblNewLabel_4);

		JLabel lblConcern_2 = new JLabel("Concern:");
		lblConcern_2.setForeground(new Color(0, 0, 128));
		lblConcern_2.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern_2.setBounds(20, 331, 127, 19);
		contentPane.add(lblConcern_2);

		JLabel lblNewLabel_5 = new JLabel("Can I change the courier assigned to my order?");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(22, 160, 472, 38);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"You can only change the courier once and the change is only allowed for Standard Options only.");
		lblNewLabel_6.setIcon(new ImageIcon("assets\\note icon.PNG"));
		lblNewLabel_6.setBounds(10, 193, 508, 28);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Please do not switch carriers for large purchases. ");
		lblNewLabel_7.setBounds(10, 218, 508, 28);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(
				"This might result in orders being canceled or failing because the new courier may not be able to handle");
		lblNewLabel_8.setBounds(10, 245, 520, 31);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(" their dimensions.");
		lblNewLabel_9.setBounds(10, 271, 121, 23);
		contentPane.add(lblNewLabel_9);

	}
}
