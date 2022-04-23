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
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javax.swing.table.TableModel;

import controller.DataBaseController;
import model.CartItem;
import model.Product;
import view.CustomerService.Help;
import view.Promos;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OrderMenu extends JFrame {
        Connection connection = null;
        DataBaseController dbControl = new DataBaseController();
        private JPanel contentPane;
        JFrame frame = new JFrame("GUI");

        protected double bill = 0;

        // public static void main(String[] args) {

        // // connectDb();

        // EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // try {
        // // OrderMenu frame = new OrderMenu();

        // LoginPage frame = new LoginPage();
        // frame.setVisible(true);

        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // });
        // }

        private JTextField txt_addId;
        private JTextField txt_removeId;
        private JTable tbl_cart;
        private JTable tbl_inventory;
        private JTextField productIDtxt;
        private JTextField productPriceInvTxt;
        private JTextField productInvQntyTxt;
        private JTextField productNameTxt;
        private JTable table;


        private void openPayment(){
                String[] options = { "OK" };
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("TOTAL: P" + bill + " Enter Payment");
                JTextField txt = new JTextField(10);
                panel.add(lbl);
                panel.add(txt);
        
                JPanel panel2 = new JPanel();
                JLabel lbl2 = new JLabel("Proceed To Shipping");
                panel2.add(lbl2);
                try {
                        int selectedOption = JOptionPane.showOptionDialog(null, panel,
                                        "Enter Your Payment", JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if (selectedOption == 0) {
                                double payment = Double.parseDouble(txt.getText());
                                double change = payment - bill;
                                JOptionPane.showMessageDialog(null, "This is your Change: " + change);
                                int Option2 = JOptionPane.showOptionDialog(null, panel2,
                                                "Confirmation",
                                                JOptionPane.OK_CANCEL_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null, options,
                                                options[0]);
                                if (Option2 == 0) {
                                        Ship s = new Ship();
                                        s.setVisible(true);
                                }
                        }
                } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
                }
        }

        public OrderMenu() {
                connection = dbControl.Connect();
                setBackground(Color.DARK_GRAY);

                setIconImage(Toolkit.getDefaultToolkit().getImage(
                                "assets\\icon.png"));
                setResizable(false);
                setTitle("Ordering and Payment");
                setFont(new Font("Arial Narrow", Font.PLAIN, 12));

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 638, 665);
                contentPane = new JPanel();
                contentPane.setBackground(Color.DARK_GRAY);
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout(0, 0));
                setContentPane(contentPane);

                JLabel lblTitle = new JLabel("Neo Products Computer Peripherals Shop");
                lblTitle.setForeground(new Color(0, 204, 255));
                lblTitle.setBackground(Color.DARK_GRAY);
                lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                contentPane.add(lblTitle, BorderLayout.NORTH);

                JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                tabbedPane.setBackground(Color.DARK_GRAY);
                contentPane.add(tabbedPane, BorderLayout.CENTER);

                JPanel order_payment = new JPanel();
                order_payment.setBackground(Color.DARK_GRAY);
                order_payment.setBorder(null);
                tabbedPane.addTab("Ordering and Payment", null, order_payment, null);
                GridBagLayout gbl_order_payment = new GridBagLayout();
                gbl_order_payment.columnWidths = new int[] { 0, 342, 39, 55, 61, 57, 0, 0 };
                gbl_order_payment.rowHeights = new int[] { 0, 0, 31, 0, 0, 0, 0, 0 };
                gbl_order_payment.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
                gbl_order_payment.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
                order_payment.setLayout(gbl_order_payment);

                JLabel lblNewLabel_14 = new JLabel("Item List");
                lblNewLabel_14.setForeground(new Color(51, 204, 255));
                lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
                lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
                GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
                gbc_lblNewLabel_14.fill = GridBagConstraints.HORIZONTAL;
                gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
                gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
                gbc_lblNewLabel_14.gridx = 1;
                gbc_lblNewLabel_14.gridy = 0;
                order_payment.add(lblNewLabel_14, gbc_lblNewLabel_14);

                JButton btnNewButton = new JButton("Help");
                btnNewButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Help h = new Help();
                                h.setVisible(true);
                        }
                });
                GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
                gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
                gbc_btnNewButton.gridx = 5;
                gbc_btnNewButton.gridy = 0;
                order_payment.add(btnNewButton, gbc_btnNewButton);

                JScrollPane pane_inventory = new JScrollPane();
                GridBagConstraints gbc_pane_inventory = new GridBagConstraints();
                gbc_pane_inventory.insets = new Insets(0, 0, 5, 5);
                gbc_pane_inventory.fill = GridBagConstraints.BOTH;
                gbc_pane_inventory.gridx = 1;
                gbc_pane_inventory.gridy = 1;
                order_payment.add(pane_inventory, gbc_pane_inventory);

                tbl_inventory = new JTable();
                tbl_inventory.setBorder(null);
                tbl_inventory.setForeground(new Color(255, 255, 255));
                tbl_inventory.setBackground(new Color(51, 51, 51));
                tbl_inventory.getTableHeader().setReorderingAllowed(false);
                tbl_inventory.setModel(dbControl.table_load(connection));

                pane_inventory.setViewportView(tbl_inventory);

                JLabel lblNewLabel = new JLabel("Add Item(ID):");
                lblNewLabel.setForeground(Color.WHITE);
                GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
                gbc_lblNewLabel.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
                gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
                gbc_lblNewLabel.gridx = 2;
                gbc_lblNewLabel.gridy = 1;
                order_payment.add(lblNewLabel, gbc_lblNewLabel);

                txt_addId = new JTextField();
                txt_addId.setBackground(new Color(0, 0, 0));
                txt_addId.setForeground(Color.WHITE);
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

                JLabel lblNewLabel_11 = new JLabel("My Cart");
                lblNewLabel_11.setForeground(new Color(0, 204, 255));
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
                tbl_cart.setForeground(new Color(255, 255, 255));
                tbl_cart.setBackground(new Color(51, 51, 51));
                tbl_cart.getTableHeader().setReorderingAllowed(false);
                tbl_cart.setModel(dbControl.table_load(connection));
                tbl_cart.setModel(new DefaultTableModel(
                                new String[][] {},
                                new String[] {
                                                "ID", "Product Name", "Price", "Quantity"
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

                JButton btnConfirmOrder = new JButton("Confirm");
                btnConfirmOrder.setBackground(new Color(0, 204, 255));

                JLabel lblTotalBill = new JLabel("TOTAL: P0.0");
                lblTotalBill.setHorizontalAlignment(SwingConstants.LEFT);
                lblTotalBill.setForeground(Color.WHITE);
                GridBagConstraints gbc_lblTotalBill = new GridBagConstraints();
                gbc_lblTotalBill.insets = new Insets(0, 0, 5, 5);
                gbc_lblTotalBill.gridx = 1;
                gbc_lblTotalBill.gridy = 5;
                order_payment.add(lblTotalBill, gbc_lblTotalBill);

                btnConfirmOrder.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        int spinValue = (Integer) spin_qty.getValue();
                                        int idValue = Integer.parseInt(txt_addId.getText());
                                        CartItem item = new CartItem();
                                        dbControl.returnCartItem(connection, item, idValue, spinValue);
                                        // update product quantity in inventory
                                        Product product = new Product();
                                        try {
                                                dbControl.cartUpdate(connection, product, idValue, spinValue);
                                                tbl_inventory.setModel(dbControl.table_load(connection));
                                                productIDtxt.setText("");
                                                productNameTxt.setText("");
                                                productPriceInvTxt.setText("");
                                                productInvQntyTxt.setText("");
                                                // update details in inventory
                                                table.setModel(dbControl.table_load(connection));
                                                // add new row to cart displaying product details
                                                DefaultTableModel cartModel = (DefaultTableModel) tbl_cart.getModel();
                                                cartModel.addRow(new Object[] { item.getProductId(),
                                                                item.getProductName(),
                                                                item.getProductPrice() * spinValue,
                                                                item.getProductQty() });


                                                bill = dbControl.getSum(tbl_cart.getModel());
                                                lblTotalBill.setText("TOTAL: " + bill);
                                                item.setTotalPrice(dbControl.getSum(tbl_cart.getModel()));
                                                // lblTotalBill.setText("TOTAL: P" + item.getTotalPrice());
                                                // bill = dbControl.saveTotal(item.getTotalPrice());
                                        } catch (Exception e1) {
                                                e1.printStackTrace();
                                        }
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Empty ID field. Please enter an item ID.");
                                }
                        }
                });
                GridBagConstraints gbc_btnConfirmOrder = new GridBagConstraints();
                gbc_btnConfirmOrder.insets = new Insets(0, 0, 5, 5);
                gbc_btnConfirmOrder.gridx = 5;
                gbc_btnConfirmOrder.gridy = 1;
                order_payment.add(btnConfirmOrder, gbc_btnConfirmOrder);

                JButton btnDelete = new JButton("Delete");
                btnDelete.setBackground(new Color(0, 204, 255));
                btnDelete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                DefaultTableModel tblModel = (DefaultTableModel) tbl_cart.getModel();
                                int row = tbl_cart.getSelectedRow();
                                int spinValue = (int) tbl_cart.getModel().getValueAt(row, 3);
                                int idValue = (int) tbl_cart.getModel().getValueAt(row, 0);
                                CartItem item = new CartItem();

                                // deletes row
                                if (tbl_cart.getSelectedRowCount() == 1) {
                                        // update product qty in inventory when removed from cart
                                        dbControl.returnQty(connection, item, idValue, spinValue);
                                        tbl_inventory.setModel(dbControl.table_load(connection));
                                        productIDtxt.setText("");
                                        productNameTxt.setText("");
                                        productPriceInvTxt.setText("");
                                        productInvQntyTxt.setText("");
                                        // if single row is selected then delete
                                        tblModel.removeRow(tbl_cart.getSelectedRow());
                                        // update details in inventory
                                        table.setModel(dbControl.table_load(connection));
                                } else {
                                        if (tbl_cart.getRowCount() == 0) {
                                                // if table is empty then display:
                                                JOptionPane.showMessageDialog(frame, "Table is Empty.");
                                        } else {
                                                // if table is not empty but row is not selected/multiple rows selected
                                                JOptionPane.showMessageDialog(frame,
                                                                "Please select a single row to delete");
                                        }
                                }
                                bill = dbControl.getSum(tbl_cart.getModel());
                                lblTotalBill.setText("TOTAL: " + bill);
                                item.setTotalPrice(dbControl.getSum(tbl_cart.getModel()));
                                // lblTotalBill.setText("TOTAL: P" + item.getTotalPrice());
                                // bill = dbControl.saveTotal(item.getTotalPrice());
                        }
                });
                GridBagConstraints gbc_btnDelete = new GridBagConstraints();
                gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
                gbc_btnDelete.gridx = 2;
                gbc_btnDelete.gridy = 4;
                order_payment.add(btnDelete, gbc_btnDelete);

                JButton btnPromos = new JButton("Payment");
                btnPromos.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                                // lblTotalBill.setText("(DISCOUNTED) TOTAL: " + bill);
                                // bill = dbControl.getSum(tbl_cart.getModel());

                                String[] promoOptions = { "Yes", "No" };
                                JPanel promoPanel = new JPanel();
                                JLabel promoLbl = new JLabel("Avail Promos?");
                                promoPanel.add(promoLbl);
                                try {
                                        int promoSelect = JOptionPane.showOptionDialog(null, promoPanel,
                                                        "Enter Your Payment", JOptionPane.OK_CANCEL_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, promoOptions, promoOptions[0]);

                                        if (promoSelect == 0) {
                                                Promos promoPane = new Promos(bill);
                                                promoPane.addWindowListener((WindowListener) new WindowAdapter(){
                                                        @Override
                                                        public void windowClosing(WindowEvent e1){
                                                                bill = promoPane.getDiscountedBill();
                                                                lblTotalBill.setText("(DISCOUNTED) TOTAL: " + bill);
                                                                // bill = dbControl.getSum(tbl_cart.getModel());
                                                                openPayment();
                                                        }
                                                });
                                                promoPane.setVisible(true);
                                        }
                                        else{
                                                openPayment();
                                        }
                                }catch (Exception e1) {
                                        JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
                	}
                }});

                btnPromos.setBackground(new Color(0, 204, 255));
                GridBagConstraints gbc_btnPromos = new GridBagConstraints();
                gbc_btnPromos.insets = new Insets(0, 0, 5, 5);
                gbc_btnPromos.gridx = 2;
                gbc_btnPromos.gridy = 5;
                order_payment.add(btnPromos, gbc_btnPromos);
                // Inventory Add Button to Database
                JPanel inventory = new JPanel();
                tabbedPane.addTab("Inventory", null, inventory, null);
                JButton AddBtn = new JButton("Add");
                AddBtn.setBounds(156, 455, 89, 23);
                AddBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Product product = new Product();
                                product.setProductName(productNameTxt.getText());
                                product.setPrice(Integer.parseInt(productPriceInvTxt.getText()));
                                product.setQnty(Integer.parseInt(productInvQntyTxt.getText()));
                                dbControl.prepAdd(connection, product);
                                table.setModel(dbControl.table_load(connection));

                                productNameTxt.setText("");
                                productPriceInvTxt.setText("");
                                productInvQntyTxt.setText("");
                        }
                });
                inventory.setLayout(null);
                inventory.add(AddBtn);
                // Inventory Delete Button to Database
                JButton DeleteBtn = new JButton("Delete");
                DeleteBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Product product = new Product();
                                product.setProductId(Integer.parseInt(productIDtxt.getText()));
                                dbControl.prepDelete(connection, product);
                                table.setModel(dbControl.table_load(connection));
                                productIDtxt.setText("");
                        }
                });
                DeleteBtn.setBounds(275, 455, 89, 23);
                inventory.add(DeleteBtn);
                // Inventory Update Button to Database
                JButton Edit = new JButton("Edit");
                Edit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Product product = new Product();
                                product.setProductName(productNameTxt.getText());
                                product.setPrice(Integer.parseInt(productPriceInvTxt.getText()));
                                product.setQnty(Integer.parseInt(productInvQntyTxt.getText()));
                                product.setProductId(Integer.parseInt(
                                                productIDtxt.getText()));
                                dbControl.prepUpdate(connection, product);
                                table.setModel(dbControl.table_load(connection));
                                productIDtxt.setText("");
                                productNameTxt.setText("");
                                productPriceInvTxt.setText("");
                                productInvQntyTxt.setText("");
                        }
                });
                Edit.setBounds(404, 455, 89, 23);
                inventory.add(Edit);

                // Inventory Search Button
                JButton btnNewButton_3 = new JButton("Search");
                btnNewButton_3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Product product = new Product();
                                dbControl.prepSearch(connection, product);
                                product.setProductId(Integer.parseInt(productIDtxt.getText()));
                                Product p1 = dbControl.prepSearch(connection, product);
                                productNameTxt.setText(p1.getProductName());
                                productPriceInvTxt.setText(String.valueOf(p1.getPrice()));
                                productInvQntyTxt.setText(String.valueOf(p1.getQnty()));
                        }
                });

                btnNewButton_3.setBounds(36, 455, 89, 23);
                inventory.add(btnNewButton_3);

                productIDtxt = new JTextField();
                productIDtxt.setBounds(80, 313, 89, 20);
                inventory.add(productIDtxt);
                productIDtxt.setColumns(10);

                productPriceInvTxt = new JTextField();
                productPriceInvTxt.setBounds(329, 364, 86, 20);
                inventory.add(productPriceInvTxt);
                productPriceInvTxt.setColumns(10);

                productInvQntyTxt = new JTextField();
                productInvQntyTxt.setBounds(98, 364, 139, 20);
                inventory.add(productInvQntyTxt);
                productInvQntyTxt.setColumns(10);

                productNameTxt = new JTextField();
                productNameTxt.setBounds(270, 313, 117, 20);
                inventory.add(productNameTxt);
                productNameTxt.setColumns(10);

                JLabel lblNewLabel_2 = new JLabel("Product ID");
                lblNewLabel_2.setBounds(10, 316, 60, 14);
                inventory.add(lblNewLabel_2);

                JLabel lblNewLabel_3 = new JLabel("Product Quantity");
                lblNewLabel_3.setBounds(10, 367, 89, 14);
                inventory.add(lblNewLabel_3);

                JLabel lblNewLabel_4 = new JLabel("Product Name");
                lblNewLabel_4.setBounds(191, 316, 72, 14);
                inventory.add(lblNewLabel_4);

                JLabel lblNewLabel_5 = new JLabel("Product Price");
                lblNewLabel_5.setBounds(247, 367, 72, 14);
                inventory.add(lblNewLabel_5);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(10, 11, 396, 279);
                inventory.add(scrollPane);

                table = new JTable();
                scrollPane.setViewportView(table);
                table.setModel(dbControl.table_load(connection));
        }
}