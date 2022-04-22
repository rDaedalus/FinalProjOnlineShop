package view;

import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Color;

public class ShipConfirm extends javax.swing.JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShipConfirm() {
		setTitle("Shipping Form");
		setBounds(100, 100, 559, 667);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("DELIVERY DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 22, 204, 13);
		getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 527, 2);
		getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Delivery Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 45, 223, 28);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Products Ordered");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(22, 172, 204, 13);
		getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Change");
		btnNewButton.setToolTipText("");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(444, 107, 85, 21);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2_2 = new JLabel("Message");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 413, 79, 21);
		getContentPane().add(lblNewLabel_2_2);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 436, 362, 53);
		getContentPane().add(textArea);

		JLabel lblNewLabel_2_2_1 = new JLabel("Payment Method");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(10, 510, 144, 21);
		getContentPane().add(lblNewLabel_2_2_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 401, 527, 2);
		getContentPane().add(separator_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 83, 424, 67);
		getContentPane().add(panel);
		String[] rows = { "Item", "Unit Price", "Quantity", "Item Subtotal" };
		JScrollPane sp = new JScrollPane();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash on Delivery");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(20, 537, 134, 21);
		getContentPane().add(rdbtnNewRadioButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(338, 590, 96, 33);
		getContentPane().add(btnCancel);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(441, 590, 96, 33);
		getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 527, 176);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Item", "Unit Price", "Quantity", "Item Subtotal"
				}));
		table.getColumnModel().getColumn(0).setPreferredWidth(275);
		scrollPane.setViewportView(table);

	}

}
