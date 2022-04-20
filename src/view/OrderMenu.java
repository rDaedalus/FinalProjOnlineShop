package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollBar;
import javax.swing.SpinnerNumberModel;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class OrderMenu extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {

        // connectDb();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderMenu frame = new OrderMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JTextField txt_addId;
    private JTextField txt_removeId;
    private JTable tbl_cart;
    private JTable tbl_inventory;

    public OrderMenu() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "C:\\Users\\trist\\Documents\\_T.I.P\\2nd SEM\\MODULAR 2\\COMPROG\\final proj files\\icon.png"));
        setResizable(false);
        setTitle("Ordering and Payment");
        setFont(new Font("Arial Narrow", Font.PLAIN, 12));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 638, 665);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Neo Products Computer Peripherals Shop");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel order_payment = new JPanel();
        order_payment.setBorder(null);
        tabbedPane.addTab("Ordering and Payment", null, order_payment, null);
        GridBagLayout gbl_order_payment = new GridBagLayout();
        gbl_order_payment.columnWidths = new int[] { 0, 342, 39, 55, 61, 57, 0, 0 };
        gbl_order_payment.rowHeights = new int[] { 0, 0, 31, 0, 0, 0, 0, 0 };
        gbl_order_payment.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_order_payment.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        order_payment.setLayout(gbl_order_payment);

        JLabel lblNewLabel_14 = new JLabel("Item List");
        lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
        GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
        gbc_lblNewLabel_14.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_14.gridx = 1;
        gbc_lblNewLabel_14.gridy = 0;
        order_payment.add(lblNewLabel_14, gbc_lblNewLabel_14);

        JScrollPane pane_inventory = new JScrollPane();
        GridBagConstraints gbc_pane_inventory = new GridBagConstraints();
        gbc_pane_inventory.insets = new Insets(0, 0, 5, 5);
        gbc_pane_inventory.fill = GridBagConstraints.BOTH;
        gbc_pane_inventory.gridx = 1;
        gbc_pane_inventory.gridy = 1;
        order_payment.add(pane_inventory, gbc_pane_inventory);

        tbl_inventory = new JTable();
        tbl_inventory.getTableHeader().setReorderingAllowed(false);
        tbl_inventory.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                },
                new String[] {
                        "ID", "Product Name", "Stock", "Price"
                }) {
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Integer.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tbl_inventory.getColumnModel().getColumn(0).setResizable(false);
        tbl_inventory.getColumnModel().getColumn(0).setMinWidth(50);
        tbl_inventory.getColumnModel().getColumn(1).setResizable(false);
        tbl_inventory.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_inventory.getColumnModel().getColumn(1).setMinWidth(100);
        tbl_inventory.getColumnModel().getColumn(2).setResizable(false);
        tbl_inventory.getColumnModel().getColumn(2).setMinWidth(50);
        tbl_inventory.getColumnModel().getColumn(3).setResizable(false);
        tbl_inventory.getColumnModel().getColumn(3).setMinWidth(60);
        pane_inventory.setViewportView(tbl_inventory);

        JLabel lblNewLabel = new JLabel("Add Item(ID):");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 2;
        gbc_lblNewLabel.gridy = 1;
        order_payment.add(lblNewLabel, gbc_lblNewLabel);

        txt_addId = new JTextField();
        GridBagConstraints gbc_txt_addId = new GridBagConstraints();
        gbc_txt_addId.insets = new Insets(0, 0, 5, 5);
        gbc_txt_addId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_addId.gridx = 3;
        gbc_txt_addId.gridy = 1;
        order_payment.add(txt_addId, gbc_txt_addId);
        txt_addId.setColumns(10);

        JSpinner spin_qty = new JSpinner();
        spin_qty.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        GridBagConstraints gbc_spin_qty = new GridBagConstraints();
        gbc_spin_qty.insets = new Insets(0, 0, 5, 5);
        gbc_spin_qty.gridx = 4;
        gbc_spin_qty.gridy = 1;
        order_payment.add(spin_qty, gbc_spin_qty);

        JButton btnConfirmOrder = new JButton("Confirm");
        GridBagConstraints gbc_btnConfirmOrder = new GridBagConstraints();
        gbc_btnConfirmOrder.insets = new Insets(0, 0, 5, 5);
        gbc_btnConfirmOrder.gridx = 5;
        gbc_btnConfirmOrder.gridy = 1;
        order_payment.add(btnConfirmOrder, gbc_btnConfirmOrder);

        JLabel lblNewLabel_11 = new JLabel("My Cart");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_11.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_11.gridx = 1;
        gbc_lblNewLabel_11.gridy = 3;
        order_payment.add(lblNewLabel_11, gbc_lblNewLabel_11);

        JScrollPane pane_cart = new JScrollPane();
        GridBagConstraints gbc_pane_cart = new GridBagConstraints();
        gbc_pane_cart.insets = new Insets(0, 0, 5, 5);
        gbc_pane_cart.fill = GridBagConstraints.BOTH;
        gbc_pane_cart.gridx = 1;
        gbc_pane_cart.gridy = 4;
        order_payment.add(pane_cart, gbc_pane_cart);

        tbl_cart = new JTable();
        tbl_cart.getTableHeader().setReorderingAllowed(false);
        tbl_cart.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                },
                new String[] {
                        "ID", "Product Name", "Quantity", "Price"
                }) {
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Integer.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tbl_cart.getColumnModel().getColumn(0).setResizable(false);
        tbl_cart.getColumnModel().getColumn(0).setMinWidth(50);
        tbl_cart.getColumnModel().getColumn(1).setResizable(false);
        tbl_cart.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_cart.getColumnModel().getColumn(1).setMinWidth(100);
        tbl_cart.getColumnModel().getColumn(2).setResizable(false);
        tbl_cart.getColumnModel().getColumn(2).setMinWidth(50);
        tbl_cart.getColumnModel().getColumn(3).setResizable(false);
        tbl_cart.getColumnModel().getColumn(3).setMinWidth(60);
        pane_cart.setViewportView(tbl_cart);

        // ResultSet ps = null;
        // int qtyInput = (Integer)spin_qty.getValue();
        // int idInput = txt_addId.getText();

        // btnConfirmOrder.addActionListener(new ActionListener(){
        // public void actionPeformed(ActionEvent e){
        // String query = "Select * from product where product_id = " + idInput;
        // ps = pst.executeQuery(query);

        // //update item stock after adding to cart
        // try{
        // while(rs.next()){
        // int stockUpdate = (rs.getInt("product_qnty")) - qtyInput;
        // String prodUpdate = "Update product set product_qnty = "+ stockUpdate +"where
        // product_id = "+idInput;
        // }
        // pst.executeUpdate(prodUpdate);
        // }catch(SQLException e1){
        // e1.printStackTrace;
        // }

        // //add item details to cart
        // try{
        // while(rs.next()){
        // int id = rs.getInt("product_id");
        // String name = rs.getString("product_name");
        // int qty = qtyInput;
        // int price = (rs.getInt("product_price")) * qty;
        // tbl_cart.addRow(new Object[][]{id, name, qty, price});
        // }
        // }catch(SQLException e1){
        // e1.printStackTrace;
        // }
        // }
        // });

        JLabel lblNewLabel_1 = new JLabel("Remove Item(ID):");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 2;
        gbc_lblNewLabel_1.gridy = 4;
        order_payment.add(lblNewLabel_1, gbc_lblNewLabel_1);

        txt_removeId = new JTextField();
        GridBagConstraints gbc_txt_removeId = new GridBagConstraints();
        gbc_txt_removeId.gridwidth = 2;
        gbc_txt_removeId.insets = new Insets(0, 0, 5, 5);
        gbc_txt_removeId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txt_removeId.gridx = 3;
        gbc_txt_removeId.gridy = 4;
        order_payment.add(txt_removeId, gbc_txt_removeId);
        txt_removeId.setColumns(10);

        JButton btnConfirmRemove = new JButton("Confirm");
        GridBagConstraints gbc_btnConfirmRemove = new GridBagConstraints();
        gbc_btnConfirmRemove.insets = new Insets(0, 0, 5, 5);
        gbc_btnConfirmRemove.gridx = 5;
        gbc_btnConfirmRemove.gridy = 4;
        order_payment.add(btnConfirmRemove, gbc_btnConfirmRemove);

        // btnConfirmRemove.addActionListener(new ActionListener(){
        // public void actionPeformed(ActionEvent e){
        // tbl_cart.removeRow()

        // String query = "Select * from product where product_id = " + idInput;
        // ps = pst.executeQuery(query);

        // //update item stock after removing from cart
        // try{
        // while(rs.next()){
        // int stockUpdate = (rs.getInt("product_qnty")) + qtyInput;
        // String prodUpdate = "Update product set product_qnty = "+ stockUpdate +"where
        // product_id = "+idInput;
        // }
        // pst.executeUpdate(prodUpdate);
        // }catch(SQLException e1){
        // e1.printStackTrace;
        // }
        // }
        // });

        JButton btnPromos = new JButton("Promos");
        GridBagConstraints gbc_btnPromos = new GridBagConstraints();
        gbc_btnPromos.insets = new Insets(0, 0, 5, 5);
        gbc_btnPromos.gridx = 2;
        gbc_btnPromos.gridy = 5;
        order_payment.add(btnPromos, gbc_btnPromos);

        JButton btn_Payment = new JButton("Payment");
        GridBagConstraints gbc_btn_Payment = new GridBagConstraints();
        gbc_btn_Payment.insets = new Insets(0, 0, 5, 5);
        gbc_btn_Payment.gridx = 5;
        gbc_btn_Payment.gridy = 5;
        order_payment.add(btn_Payment, gbc_btn_Payment);

        JPanel inventory = new JPanel();
        tabbedPane.addTab("Inventory", null, inventory, null);

    }

}