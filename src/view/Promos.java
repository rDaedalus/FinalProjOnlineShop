package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseController;
import model.ShippingDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Promos extends javax.swing.JFrame{
	
	private JPanel contentPane;
	private JButton button;
	private JLabel label;
    Connection connection = null;
    DataBaseController dbControl = new DataBaseController();

    private double discount_1 = 0.05;
    private double discount_2 = 0.10;
    private double discount_3 = 0.15;
    private double discount_4 = 0.20;
    private double discount_5 = 0.25;

    double finalBill;

    public void setDiscountedBill(double finalBill){
        this.finalBill =  finalBill;
    }

    public double getDiscountedBill(){
        return finalBill;
    }

	public Promos(double bill) {

		setResizable(false);
		connection = dbControl.Connect();
		setTitle("Promos");
		
		setBounds(100, 100, 362, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Promos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 331, 44);
		contentPane.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("800 Min spend -5%");
		lblNewLabel_1.setBounds(49, 64, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1600 min spend -10%");
		lblNewLabel_2.setBounds(51, 109, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2000 min spend -15%");
		lblNewLabel_3.setBounds(51, 182, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("5000 min spend -20%");
		lblNewLabel_4.setBounds(59, 241, 105, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("10k minimum spend -25%");
		lblNewLabel_5.setBounds(51, 297, 129, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CLAIM");
        if (bill>= 800.00 & bill< 1600.00) {
			btnNewButton.setEnabled(true);
		}else {
			btnNewButton.setEnabled(false);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("5% has been discounted from the total bill");
                panel.add(lbl);

                finalBill = dbControl.discountedBill(connection, bill, discount_1);
                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if (option == 0) {
                    setDiscountedBill(finalBill);
                    JComponent comp = (JComponent) e.getSource();
                    java.awt.Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                }
			}
		});

		btnNewButton.setBounds(218, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLAIM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_2);
                JOptionPane.showMessageDialog(null, "10% has been discounted from the total bill");
			}
		});
        if (bill>= 1600.00 & bill< 2000.00) {
			btnNewButton_1.setEnabled(true);
		}else {
			btnNewButton_1.setEnabled(false);
		}
		btnNewButton_1.setBounds(218, 115, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLAIM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_3);
                JOptionPane.showMessageDialog(null, "15% has been discounted from the total bill");
			}
		});
        if (bill>= 2000.00 & bill< 5000.00) {
			btnNewButton_2.setEnabled(true);
		}else {
			btnNewButton_2.setEnabled(false);
		}
		btnNewButton_2.setBounds(218, 178, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLAIM");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_4);
                JOptionPane.showMessageDialog(null, "20% has been discounted from the total bill");
			}
		});
        if (bill>= 5000.00 & bill< 10000.00) {
			btnNewButton_3.setEnabled(true);
		}else {
			btnNewButton_3.setEnabled(false);
		}
		btnNewButton_3.setBounds(218, 237, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLAIM");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_5);
                JOptionPane.showMessageDialog(null, "25% has been discounted from the total bill");
			}
		});
        if (bill>= 10000.00) {
			btnNewButton_4.setEnabled(true);
		}else {
			btnNewButton_4.setEnabled(false);
		}
		btnNewButton_4.setBounds(218, 293, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Apply & Close");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_5.setBounds(112, 338, 113, 23);
		contentPane.add(btnNewButton_5);
        
	}

}
