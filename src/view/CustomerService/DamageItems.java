package view.CustomerService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DamageItems extends JFrame {

	private JPanel contentPane;
	private JTextField txtAsdas;

	public DamageItems() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 635);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 343, 127, 19);
		contentPane.add(lblNewLabel);

		txtAsdas = new JTextField();
		txtAsdas.setBounds(127, 342, 121, 20);
		contentPane.add(txtAsdas);
		txtAsdas.setColumns(10);

		JLabel lblConcern = new JLabel("Damaged Items");
		lblConcern.setForeground(Color.WHITE);
		lblConcern.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConcern.setBounds(151, 89, 167, 38);
		contentPane.add(lblConcern);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(23, 518, 350, 82);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("E:\\Downloads\\submit iconz.PNG"));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(
						"<html>We're sorry you got a faulty item. In the name of my firm, I apologize for any inconvenience. In order to avoid faulty products, we will do our best to solve this problem.</html>");
			}
		});
		btnNewButton.setBounds(397, 546, 91, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Downloads\\icon oshopp.png"));
		lblNewLabel_2.setBounds(12, 0, 66, 62);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Customer Service");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setBounds(76, 11, 297, 38);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("How to request a Return/Refund for Wrong / Damaged / Faulty Items?");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_3_1.setBackground(Color.ORANGE);
		lblNewLabel_3_1.setBounds(10, 141, 536, 67);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_5 = new JLabel("For now, only some sellers or shops may use the new return/refund process.");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\Downloads\\note icon.PNG"));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 186, 478, 44);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("If you got damaged or malfunctioning products:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 219, 508, 44);
		contentPane.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("You may fill up the customer's information and concern");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_2.setBounds(10, 246, 526, 44);
		contentPane.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_2_1 = new JLabel("below when filing for a");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_2_1.setBounds(317, 246, 271, 44);
		contentPane.add(lblNewLabel_5_2_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Return/Refund request.");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setBounds(10, 274, 143, 44);
		contentPane.add(lblNewLabel_5_1_1);

		JLabel lblConcern_1 = new JLabel("Concern:");
		lblConcern_1.setForeground(new Color(0, 0, 128));
		lblConcern_1.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblConcern_1.setBounds(10, 374, 127, 19);
		contentPane.add(lblConcern_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\Downloads\\backgroud oshopping.jpg"));
		lblNewLabel_4.setBounds(-140, 75, 752, 67);
		contentPane.add(lblNewLabel_4);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(21, 390, 297, 117);
		contentPane.add(textPane_1);

	}
}
