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
import javax.swing.UIManager;

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

        private void openPayment(TableModel cModel) {
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
                                        Ship s = new Ship(cModel);

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
                lblTitle.setFont(new Font("Gadugi", Font.BOLD, 18));
                lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
                contentPane.add(lblTitle, BorderLayout.NORTH);

                JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                tabbedPane.setBackground(new Color(0, 153, 255));
                contentPane.add(tabbedPane, BorderLayout.CENTER);

                JPanel order_payment = new JPanel();
                order_payment.setBackground(Color.DARK_GRAY);
                order_payment.setBorder(null);
                tabbedPane.addTab("Ordering and Payment", null, order_payment, null);
                order_payment.setLayout(null);

                JLabel lblNewLabel_14 = new JLabel("Item List");
                lblNewLabel_14.setBounds(29, 2, 316, 19);
                lblNewLabel_14.setForeground(new Color(51, 204, 255));
                lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
                lblNewLabel_14.setFont(new Font("Gadugi", Font.BOLD, 15));
                order_payment.add(lblNewLabel_14);

                JButton btnNewButton = new JButton("Help");
                btnNewButton.setBounds(529, 529, 68, 23);
                btnNewButton.setBackground(new Color(0, 204, 255));
                btnNewButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Help h = new Help();
                                h.setVisible(true);
                        }
                });
                order_payment.add(btnNewButton);

                JScrollPane pane_inventory = new JScrollPane();
                pane_inventory.setBounds(29, 28, 405, 207);
                order_payment.add(pane_inventory);

                tbl_inventory = new JTable();
                tbl_inventory.setBorder(null);
                tbl_inventory.setForeground(new Color(255, 255, 255));
                tbl_inventory.setBackground(new Color(51, 51, 51));
                tbl_inventory.getTableHeader().setReorderingAllowed(false);
                tbl_inventory.setModel(dbControl.table_load(connection));

                pane_inventory.setViewportView(tbl_inventory);

                JLabel lblNewLabel = new JLabel("Add Item(ID):");
                lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 14));
                lblNewLabel.setBounds(444, 103, 82, 14);
                lblNewLabel.setForeground(Color.WHITE);
                order_payment.add(lblNewLabel);

                txt_addId = new JTextField();
                txt_addId.setBounds(537, 102, 29, 20);
                txt_addId.setBackground(new Color(0, 0, 0));
                txt_addId.setForeground(Color.WHITE);
                order_payment.add(txt_addId);
                txt_addId.setColumns(10);

                JSpinner spin_qty = new JSpinner();
                spin_qty.setBounds(483, 136, 36, 20);
                spin_qty.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
                order_payment.add(spin_qty);

                JLabel lblNewLabel_11 = new JLabel("My Cart");
                lblNewLabel_11.setBounds(29, 271, 316, 19);
                lblNewLabel_11.setForeground(new Color(0, 204, 255));
                lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
                lblNewLabel_11.setFont(new Font("Gadugi", Font.BOLD, 16));
                order_payment.add(lblNewLabel_11);

                JScrollPane pane_cart = new JScrollPane();
                pane_cart.setBounds(29, 295, 405, 207);
                order_payment.add(pane_cart);

                tbl_cart = new JTable();
                tbl_cart.setForeground(new Color(255, 255, 255));
                tbl_cart.setBackground(new Color(51, 51, 51));
                tbl_cart.getTableHeader().setReorderingAllowed(false);
                tbl_cart.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                                "ID", "Product Name", "Price", "Quantity"
                                }) {
                        Class[] columnTypes = new Class[] {
                                        Integer.class, String.class, Integer.class, Integer.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                        }
                });
                tbl_cart.getColumnModel().getColumn(0).setResizable(false);
                tbl_cart.getColumnModel().getColumn(0).setPreferredWidth(50);
                tbl_cart.getColumnModel().getColumn(1).setResizable(false);
                tbl_cart.getColumnModel().getColumn(1).setPreferredWidth(200);
                tbl_cart.getColumnModel().getColumn(1).setMinWidth(100);
                tbl_cart.getColumnModel().getColumn(2).setResizable(false);
                tbl_cart.getColumnModel().getColumn(2).setMinWidth(50);
                tbl_cart.getColumnModel().getColumn(3).setResizable(false);
                tbl_cart.getColumnModel().getColumn(3).setPreferredWidth(60);
                tbl_cart.getColumnModel().getColumn(3).setMinWidth(60);
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
                pane_cart.setViewportView(tbl_cart);

                JButton btnConfirmOrder = new JButton("Add to Cart");
                btnConfirmOrder.setBounds(453, 202, 144, 33);
                btnConfirmOrder.setBackground(new Color(0, 204, 255));

                JLabel lblTotalBill = new JLabel("TOTAL: P0.0");
                lblTotalBill.setFont(new Font("Gadugi", Font.BOLD, 15));
                lblTotalBill.setBounds(39, 513, 121, 31);
                lblTotalBill.setHorizontalAlignment(SwingConstants.LEFT);
                lblTotalBill.setForeground(Color.WHITE);
                order_payment.add(lblTotalBill);

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

                                                lblTotalBill.setText("TOTAL: P" + bill);
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
                order_payment.add(btnConfirmOrder);

                JButton btnDelete = new JButton("Remove from Cart");
                btnDelete.setBounds(452, 469, 145, 33);
                btnDelete.setBackground(new Color(0, 204, 255));
                btnDelete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
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
                                                        // if table is not empty but row is not selected/multiple rows
                                                        // selected
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Please select a single row to delete");
                                                }
                                        }
                                        bill = dbControl.getSum(tbl_cart.getModel());
                                        lblTotalBill.setText("TOTAL: P" + bill);
                                        item.setTotalPrice(dbControl.getSum(tbl_cart.getModel()));
                                        // lblTotalBill.setText("TOTAL: P" + item.getTotalPrice());
                                        // bill = dbControl.saveTotal(item.getTotalPrice());
                                } catch (ArrayIndexOutOfBoundsException ex) {
                                        JOptionPane.showMessageDialog(null, "No items to remove");
                                }
                        }
                });
                order_payment.add(btnDelete);

                JButton btnPromos = new JButton("Payment");
                btnPromos.setBounds(313, 513, 121, 33);
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
                                                        JOptionPane.QUESTION_MESSAGE, null, promoOptions,
                                                        promoOptions[0]);

                                        if (promoSelect == 0) {
                                                Promos promoPane = new Promos(bill);
                                                promoPane.addWindowListener((WindowListener) new WindowAdapter() {
                                                        @Override
                                                        public void windowClosing(WindowEvent e1) {
                                                                bill = promoPane.getDiscountedBill();
                                                                lblTotalBill.setText("TOTAL: P0.0");
                                                                // clear cart table and price
                                                                DefaultTableModel model = (DefaultTableModel) tbl_cart
                                                                                .getModel();
                                                                model.setRowCount(0);
                                                                // bill = dbControl.getSum(tbl_cart.getModel());
                                                                openPayment(tbl_cart
                                                                                .getModel());
                                                        }
                                                });
                                                promoPane.setVisible(true);
                                        } else {
                                                // clear cart table and price
                                                lblTotalBill.setText("TOTAL: P0.0");
                                                DefaultTableModel model = (DefaultTableModel) tbl_cart.getModel();
                                                model.setRowCount(0);
                                                openPayment(tbl_cart
                                                                .getModel());
                                        }
                                } catch (Exception e1) {
                                        JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
                                }
                        }
                });

                btnPromos.setBackground(new Color(0, 204, 255));
                order_payment.add(btnPromos);

                JLabel lblQty = new JLabel("Qty:");
                lblQty.setForeground(Color.WHITE);
                lblQty.setFont(new Font("Gadugi", Font.PLAIN, 14));
                lblQty.setBounds(444, 128, 29, 33);
                order_payment.add(lblQty);
                // Inventory Add Button to Database
                JPanel inventory = new JPanel();
                tabbedPane.addTab("Inventory", null, inventory, null);

                JButton AddBtn = new JButton("Add");
                AddBtn.setBackground(new Color(0, 204, 255));
                AddBtn.setBounds(135, 480, 89, 23);
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

                                tbl_inventory.setModel(dbControl.table_load(connection));
                        }
                });
                inventory.setLayout(null);
                inventory.add(AddBtn);
                // Inventory Delete Button to Database
                JButton DeleteBtn = new JButton("Delete");
                DeleteBtn.setBackground(new Color(0, 204, 255));
                DeleteBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Product product = new Product();
                                product.setProductId(Integer.parseInt(productIDtxt.getText()));
                                dbControl.prepDelete(connection, product);
                                table.setModel(dbControl.table_load(connection));
                                productIDtxt.setText("");

                                tbl_inventory.setModel(dbControl.table_load(connection));
                        }
                });
                DeleteBtn.setBounds(268, 480, 89, 23);
                inventory.add(DeleteBtn);
                // Inventory Update Button to Database
                JButton Edit = new JButton("Edit");
                Edit.setBackground(new Color(0, 204, 255));
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

                                tbl_inventory.setModel(dbControl.table_load(connection));

                        }
                });
                Edit.setBounds(400, 480, 89, 23);
                inventory.add(Edit);

                // Inventory Search Button
                JButton btnNewButton_3 = new JButton("Search");
                btnNewButton_3.setBackground(new Color(0, 204, 255));
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

                btnNewButton_3.setBounds(10, 480, 89, 23);
                inventory.add(btnNewButton_3);

                productIDtxt = new JTextField();
                productIDtxt.setBounds(135, 308, 89, 20);
                inventory.add(productIDtxt);
                productIDtxt.setColumns(10);

                productPriceInvTxt = new JTextField();
                productPriceInvTxt.setBounds(135, 424, 86, 20);
                inventory.add(productPriceInvTxt);
                productPriceInvTxt.setColumns(10);

                productInvQntyTxt = new JTextField();
                productInvQntyTxt.setBounds(135, 382, 89, 20);
                inventory.add(productInvQntyTxt);
                productInvQntyTxt.setColumns(10);

                productNameTxt = new JTextField();
                productNameTxt.setBounds(135, 346, 269, 20);
                inventory.add(productNameTxt);
                productNameTxt.setColumns(10);

                JLabel lblNewLabel_2 = new JLabel("Product ID");
                lblNewLabel_2.setFont(new Font("Gadugi", Font.PLAIN, 16));
                lblNewLabel_2.setBounds(10, 301, 115, 29);
                inventory.add(lblNewLabel_2);

                JLabel lblNewLabel_3 = new JLabel("Product Quantity");
                lblNewLabel_3.setFont(new Font("Gadugi", Font.PLAIN, 16));
                lblNewLabel_3.setBounds(10, 374, 166, 31);
                inventory.add(lblNewLabel_3);

                JLabel lblNewLabel_4 = new JLabel("Product Name");
                lblNewLabel_4.setFont(new Font("Gadugi", Font.PLAIN, 16));
                lblNewLabel_4.setBounds(10, 339, 115, 29);
                inventory.add(lblNewLabel_4);

                JLabel lblNewLabel_5 = new JLabel("Product Price");
                lblNewLabel_5.setFont(new Font("Gadugi", Font.PLAIN, 16));
                lblNewLabel_5.setBounds(10, 415, 102, 29);
                inventory.add(lblNewLabel_5);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(10, 11, 394, 279);
                inventory.add(scrollPane);

                table = new JTable();
                table.setBorder(null);
                scrollPane.setViewportView(table);
                table.setModel(dbControl.table_load(connection));

                JLabel lblNewLabel_1 = new JLabel(
                                "<html>Search: Enter item ID to search<br><br>\r\n\r\nAdd: Enter Item attributes in the text fields<br><br>\r\n\r\nDelete: Enter item ID to delete<br><br>\r\n\r\nEdit: Enter item ID, then update other attributes</html>");
                lblNewLabel_1.setFont(new Font("Gadugi", Font.PLAIN, 11));
                lblNewLabel_1.setBounds(414, 18, 183, 131);
                inventory.add(lblNewLabel_1);
        }
}