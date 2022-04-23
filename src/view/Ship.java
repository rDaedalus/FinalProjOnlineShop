package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.DataBaseController;
import model.ShippingDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class Ship extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField streetAddress;
	private JTextField cityAdd;
	private JTextField provinceAdd;
	private JTextField zipcodeAdd;
	private JTextField phonenum;
	private JTextField emailId;
	Connection connection = null;
	DataBaseController dbControl = new DataBaseController();

	public Ship(TableModel cModel) {
		connection = dbControl.Connect();
		setTitle("Shipping Form");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"assets\\icon.png"));

		setBounds(100, 100, 552, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("RECEIVER'S DETAILS");
		lblNewLabel.setForeground(new Color(0, 204, 255));
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 10, 230, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last name*");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 119, 89, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("First name*");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(236, 119, 107, 13);
		contentPane.add(lblNewLabel_2);

		lastName = new JTextField();
		lastName.setBounds(20, 142, 196, 27);
		contentPane.add(lastName);
		lastName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Street Address*");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 220, 117, 13);
		contentPane.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 518, 2);
		contentPane.add(separator);

		cityAdd = new JTextField();
		cityAdd.setBounds(20, 311, 196, 27);
		contentPane.add(cityAdd);
		cityAdd.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("* indicates required field");
		lblNewLabel_4.setForeground(new Color(204, 204, 204));
		lblNewLabel_4.setFont(new Font("Gadugi", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(20, 54, 155, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("FULL ADDRESS");
		lblNewLabel_5.setForeground(new Color(0, 204, 255));
		lblNewLabel_5.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_5.setBounds(20, 189, 138, 13);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("FULL NAME");
		lblNewLabel_6.setForeground(new Color(0, 204, 255));
		lblNewLabel_6.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6.setBounds(20, 92, 117, 13);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("City*");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(20, 290, 155, 13);
		contentPane.add(lblNewLabel_7);

		streetAddress = new JTextField();
		streetAddress.setBounds(20, 243, 394, 27);
		contentPane.add(streetAddress);
		streetAddress.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("State/Province*");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(236, 292, 123, 13);
		contentPane.add(lblNewLabel_8);

		provinceAdd = new JTextField();
		provinceAdd.setColumns(10);
		provinceAdd.setBounds(236, 311, 196, 27);
		contentPane.add(provinceAdd);

		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(236, 142, 196, 27);
		contentPane.add(firstName);

		JLabel lblNewLabel_7_1 = new JLabel("Zip Code*");
		lblNewLabel_7_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(20, 357, 155, 13);
		contentPane.add(lblNewLabel_7_1);

		zipcodeAdd = new JTextField();
		zipcodeAdd.setColumns(10);
		zipcodeAdd.setBounds(20, 378, 196, 27);
		contentPane.add(zipcodeAdd);

		JLabel lblNewLabel_6_1 = new JLabel("CONTACT");
		lblNewLabel_6_1.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_1.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6_1.setBounds(20, 438, 117, 13);
		contentPane.add(lblNewLabel_6_1);

		JLabel lblNewLabel_3_1 = new JLabel("Phone Number*");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(20, 470, 117, 13);
		contentPane.add(lblNewLabel_3_1);

		phonenum = new JTextField();
		phonenum.setColumns(10);
		phonenum.setBounds(20, 491, 196, 27);
		contentPane.add(phonenum);

		JLabel lblNewLabel_3_1_1 = new JLabel("E-mail Address");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1_1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(20, 535, 117, 13);
		contentPane.add(lblNewLabel_3_1_1);

		emailId = new JTextField();
		emailId.setColumns(10);
		emailId.setBounds(20, 554, 196, 27);
		contentPane.add(emailId);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 591, 518, 2);
		contentPane.add(separator_1);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShippingDetails sD = new ShippingDetails();

				sD.setLastName(lastName.getText());
				sD.setFirstName(firstName.getText());
				sD.setAddress(streetAddress.getText());
				sD.setCity(cityAdd.getText());
				sD.setProvince(provinceAdd.getText());
				sD.setZipcode(zipcodeAdd.getText());
				sD.setPhonenumber(phonenum.getText());
				sD.setEmail(emailId.getText());
				String phonenumber = phonenum.getText();
				int len = phonenumber.length();

				String msg = "" + firstName;
				msg += " \n";

				if (len != 11) {
					JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");

				}

				dbControl.addShipDetails(connection, sD);
				dispose();
				ShipConfirm sC = new ShipConfirm();
				sC.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(429, 603, 96, 33);
		contentPane.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(323, 603, 96, 33);
		contentPane.add(btnCancel);
	}
}
