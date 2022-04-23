package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseController;
import model.CartItem;
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

    public double finalBill;



    public void setDiscountedBill(double finalBill){
        this.finalBill =  finalBill;
    }

    public double getDiscountedBill(){
        return finalBill;
    }


	public Promos(double bill) {
		setBackground(new Color(51, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
                "assets\\icon.png"));
		setResizable(false);
		connection = dbControl.Connect();
		setTitle("Promos");
		
		setBounds(100, 100, 416, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Promos");
		lblNewLabel.setForeground(new Color(0, 204, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 380, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("5% off, min. spend P800");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 153, 255));
		lblNewLabel_1.setBounds(20, 99, 155, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("10% off, min. spend P1,600 ");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(0, 153, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(20, 142, 155, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("15% off, min. spend P2,000 ");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(0, 153, 255));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(20, 185, 155, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("20% off, min. spend P5,000 ");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBackground(new Color(0, 153, 255));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(20, 228, 155, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("25% off,  min. spend P10,000");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBackground(new Color(0, 153, 255));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(20, 271, 155, 32);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CLAIM");
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 153, 255));
        if (bill>= 800.00 & bill< 1600.00) {
			btnNewButton.setEnabled(true);
		}else {
			btnNewButton.setEnabled(false);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalBill = dbControl.discountedBill(connection, bill, discount_1);
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("5% has been discounted from the total bill. New Total: " + finalBill);
                panel.add(lbl);

                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) {
					btnNewButton.setEnabled(false);
                    setDiscountedBill(finalBill);
                }
			}
		});

		btnNewButton.setBounds(276, 99, 114, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLAIM");
		btnNewButton_1.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_2);
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("10% has been discounted from the total bill. New Total: " + finalBill);
                panel.add(lbl);

                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) {
					btnNewButton_1.setEnabled(false);
                    setDiscountedBill(finalBill);
                }
			}
		});
        if (bill>= 1600.00 & bill< 2000.00) {
			btnNewButton_1.setEnabled(true);
		}else {
			btnNewButton_1.setEnabled(false);
		}
		btnNewButton_1.setBounds(276, 142, 114, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLAIM");
		btnNewButton_2.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_3);
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("15% has been discounted from the total bill. New Total: " + finalBill);
                panel.add(lbl);

                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) {
					btnNewButton_2.setEnabled(false);
                    setDiscountedBill(finalBill);
                }
			}
		});
        if (bill>= 2000.00 & bill< 5000.00) {
			btnNewButton_2.setEnabled(true);
		}else {
			btnNewButton_2.setEnabled(false);
		}
		btnNewButton_2.setBounds(276, 185, 114, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLAIM");
		btnNewButton_3.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_4);
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("20% has been discounted from the total bill. New Total: " + finalBill);
                panel.add(lbl);

                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) {
					btnNewButton_3.setEnabled(false);
                    setDiscountedBill(finalBill);
                }
			}
		});
        if (bill>= 5000.00 & bill< 10000.00) {
			btnNewButton_3.setEnabled(true);
		}else {
			btnNewButton_3.setEnabled(false);
		}
		btnNewButton_3.setBounds(276, 228, 114, 32);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLAIM");
		btnNewButton_4.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton_4.setBackground(new Color(0, 153, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                finalBill = dbControl.discountedBill(connection, bill, discount_5);
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("25% has been discounted from the total bill. New Total: " + finalBill);
                panel.add(lbl);

                int option = JOptionPane.showOptionDialog(null, panel,"Discount Success", 
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) {
					btnNewButton_4.setEnabled(false);
                    setDiscountedBill(finalBill);
                }
			}
		});
        if (bill>= 10000.00) {
			btnNewButton_4.setEnabled(true);
		}else {
			btnNewButton_4.setEnabled(false);
		}
		btnNewButton_4.setBounds(276, 271, 114, 32);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("AFFN99A");
		lblNewLabel_6.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6.setForeground(new Color(0, 204, 255));
		lblNewLabel_6.setBackground(new Color(102, 102, 102));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBounds(174, 99, 103, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("AFFN99B");
		lblNewLabel_6_1.setOpaque(true);
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_1.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6_1.setBackground(new Color(102, 102, 102));
		lblNewLabel_6_1.setBounds(174, 142, 103, 32);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("CITI923");
		lblNewLabel_6_2.setOpaque(true);
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_2.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6_2.setBackground(new Color(102, 102, 102));
		lblNewLabel_6_2.setBounds(174, 185, 103, 32);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("MSCC999");
		lblNewLabel_6_3.setOpaque(true);
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_3.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_3.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6_3.setBackground(new Color(102, 102, 102));
		lblNewLabel_6_3.setBounds(174, 228, 103, 32);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("MBBA123");
		lblNewLabel_6_4.setOpaque(true);
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_4.setFont(new Font("Gadugi", Font.BOLD, 17));
		lblNewLabel_6_4.setBackground(new Color(102, 102, 102));
		lblNewLabel_6_4.setBounds(174, 271, 103, 32);
		contentPane.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("Claim Once Promos (Limited Time Only)");
		lblNewLabel_6_5.setOpaque(true);
		lblNewLabel_6_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_5.setForeground(new Color(0, 204, 255));
		lblNewLabel_6_5.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel_6_5.setBackground(new Color(102, 102, 102));
		lblNewLabel_6_5.setBounds(20, 64, 370, 24);
		contentPane.add(lblNewLabel_6_5);
        
	}
}
