package view.CustomerService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Help extends JFrame implements ActionListener {

	private JPanel contentPane;

	String[] messageStrings = { "Damaged Items", "Delivery Issues", "Payment", "Technical Errors" };
	JComboBox<Object> comboBox;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Help() {
		setBounds(100, 100, 534, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer Service");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel.setBounds(70, 11, 297, 38);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox<Object>(messageStrings);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setToolTipText("");
		comboBox.setBounds(178, 178, 160, 39);
		contentPane.add(comboBox);
		comboBox.addActionListener(this);

		JLabel lblSupportTopics = new JLabel("Support Topics");
		lblSupportTopics.setForeground(Color.WHITE);
		lblSupportTopics.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblSupportTopics.setBounds(160, 84, 176, 44);
		contentPane.add(lblSupportTopics);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("assets\\icon oshopp.png"));
		lblNewLabel_2.setBounds(10, 0, 66, 62);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("assets\\backgroud oshopping.jpg"));
		lblNewLabel_3.setBounds(-136, 70, 683, 70);
		contentPane.add(lblNewLabel_3);

		JLabel lblDamagedItems = new JLabel("Damaged Items");
		lblDamagedItems.setForeground(new Color(0, 0, 128));
		lblDamagedItems.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblDamagedItems.setBackground(Color.ORANGE);
		lblDamagedItems.setBounds(27, 228, 135, 38);
		contentPane.add(lblDamagedItems);

		JLabel lblTechnicalErrors = new JLabel("Technical Errors");
		lblTechnicalErrors.setForeground(new Color(0, 0, 128));
		lblTechnicalErrors.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblTechnicalErrors.setBackground(Color.ORANGE);
		lblTechnicalErrors.setBounds(267, 228, 171, 38);
		contentPane.add(lblTechnicalErrors);

		JLabel lblDamagedItems_1_1 = new JLabel("Delivery Issues");
		lblDamagedItems_1_1.setForeground(new Color(0, 0, 128));
		lblDamagedItems_1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblDamagedItems_1_1.setBackground(Color.ORANGE);
		lblDamagedItems_1_1.setBounds(27, 342, 160, 38);
		contentPane.add(lblDamagedItems_1_1);

		JLabel lblDamagedItems_1_1_1 = new JLabel("Payment Issues");
		lblDamagedItems_1_1_1.setForeground(new Color(0, 0, 128));
		lblDamagedItems_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblDamagedItems_1_1_1.setBackground(Color.ORANGE);
		lblDamagedItems_1_1_1.setBounds(267, 342, 145, 38);
		contentPane.add(lblDamagedItems_1_1_1);

		JLabel lblWhatDoYou = new JLabel("What do you need help with?");
		lblWhatDoYou.setForeground(new Color(0, 0, 128));
		lblWhatDoYou.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblWhatDoYou.setBackground(Color.ORANGE);
		lblWhatDoYou.setBounds(111, 141, 297, 38);
		contentPane.add(lblWhatDoYou);

		JLabel lblNewLabel_1 = new JLabel("Received  Damaged Items.");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(27, 267, 160, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Some products are missing");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(27, 391, 161, 24);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Any other genuine reasons.");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(27, 459, 160, 24);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Any other genuine reasons.");
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(27, 321, 160, 24);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Product seal was open.");
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(27, 295, 311, 24);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Unavailable or Out of Stock Product.");
		lblNewLabel_1_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(267, 267, 230, 24);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Delivery time not clearly stated.");
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(27, 426, 200, 24);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Lack of Follow Up.");
		lblNewLabel_1_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(267, 295, 115, 24);
		contentPane.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Any other genuine reasons.");
		lblNewLabel_1_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(267, 321, 160, 24);
		contentPane.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Inaccessible merchant.");
		lblNewLabel_1_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(267, 391, 161, 24);
		contentPane.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Preferred payment method not available");
		lblNewLabel_1_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(267, 424, 258, 24);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_2_3 = new JLabel("Any other genuine reasons.");
		lblNewLabel_1_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1_2_3.setBounds(267, 459, 160, 24);
		contentPane.add(lblNewLabel_1_2_3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			System.out.println(comboBox.getSelectedItem());
			if (comboBox.getSelectedItem() == "Damaged Items") {
				dispose();
				DamageItems di = new DamageItems();
				di.setVisible(true);
			} else if (comboBox.getSelectedItem() == "Delivery Issues") {
				dispose();
				DeliveryIssues is = new DeliveryIssues();
				is.setVisible(true);
			} else if (comboBox.getSelectedItem() == "Payment") {
				dispose();
				Payment p = new Payment();
				p.setVisible(true);

			} else if (comboBox.getSelectedItem() == "Technical Errors") {
				dispose();
				TechnicalErrors tr = new TechnicalErrors();
				tr.setVisible(true);

			}
		}
	}
}