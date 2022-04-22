package view.CustomerService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customercomplain;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 558);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Payment Issues");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(158, 104, 214, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setColumns(10);
		textField.setBounds(106, 228, 127, 20);
		contentPane.add(textField);

		JLabel lblConcern = new JLabel("Customer ID:");
		lblConcern.setBackground(new Color(0, 51, 255));
		lblConcern.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern.setBounds(10, 229, 127, 19);
		contentPane.add(lblConcern);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 420, 250, 94);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("E:\\Downloads\\submit iconz.PNG"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Customercomplain cc = new Customercomplain();

				lblNewLabel_1.setText(
						"<html>We're sorry you got a payment issues. In the name of my firm, I apologize for any inconvenience. <br/> In order to avoid faulty products, we will do our best to solve this problem.</html>");
			}
		});
		btnNewButton.setBounds(377, 381, 98, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Downloads\\backgroud oshopping.jpg"));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(-139, 77, 670, 81);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Customer Service");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setBounds(75, 11, 297, 38);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\Downloads\\icon oshopp.png"));
		lblNewLabel_4.setBounds(10, 0, 66, 69);
		contentPane.add(lblNewLabel_4);

		JLabel lblConcern_2 = new JLabel("Concern:");
		lblConcern_2.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern_2.setBackground(new Color(0, 51, 255));
		lblConcern_2.setBounds(10, 260, 127, 19);
		contentPane.add(lblConcern_2);

		JLabel lblNewLabel_5 = new JLabel("Payment Error");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(158, 163, 147, 30);
		contentPane.add(lblNewLabel_5);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(10, 277, 319, 134);
		contentPane.add(textPane_1);

		JLabel lblNewLabel_6 = new JLabel("Please describe your issue below.");
		lblNewLabel_6.setIcon(new ImageIcon("E:\\Downloads\\note icon.PNG"));
		lblNewLabel_6.setBounds(119, 203, 223, 14);
		contentPane.add(lblNewLabel_6);

	}
}
