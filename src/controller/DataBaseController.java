package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.CartItem;
import model.Product;
import model.ShippingDetails;
import model.User;
import net.proteanit.sql.DbUtils;
import view.LoginPage;
import view.OrderMenu;

public class DataBaseController {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    int bill;

    public Connection Connect() {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/onlineshop";
            String username = "root";
            String password = "password";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // JOptionPane.showMessageDialog(null, "Connected");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }

    public String prepAdd(Connection con, Product product) {
        try {

            pst = con.prepareStatement("insert into product(product_name,product_price,product_qnty)values(?,?,?)");
            pst.setString(1, product.getProductName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3, product.getQnty());
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(null, "Record Addedd");
            } else {
                JOptionPane.showMessageDialog(null, "Record not Added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double discountedBill(Connection con, double bill, double discount){
        double discountVal = discount * bill;
        double promoPrice = bill - discountVal;
        return promoPrice;
    }

    // public double setDiscountedBill(double totalInput){
    //     double total = totalInput;
    //     return total;
    // }

    public String cartUpdate(Connection con, Product product, int idInput, int qtyInput) throws Exception {
        try {
            ResultSet rs = null;
            rs = pst.executeQuery("Select * from product where product_id = " + idInput);

            while (rs.next()) {
                String tempName = rs.getString("product_name");
                Double tempPrice = rs.getDouble("product_price");

                if (qtyInput > rs.getInt("product_qnty")) {
                    JOptionPane.showMessageDialog(null, "Out of Stock. Please enter a quantity value less than stock!");
                    throw new Exception();
                } else {
                    int stockUpdate = (rs.getInt("product_qnty")) - qtyInput;
                    pst = con.prepareStatement(
                            "update product set product_name= ?,product_price=?,product_qnty=? where product_id = "
                                    + idInput);
                    pst.setString(1, tempName);
                    pst.setDouble(2, tempPrice);
                    pst.setInt(3, stockUpdate);
                    int k = pst.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String returnQty(Connection con, CartItem product, int idInput, int qtyInput) {
        try {
            ResultSet rs = null;
            rs = pst.executeQuery("Select * from product where product_id = " + idInput);

            while (rs.next()) {
                String tempName = rs.getString("product_name");
                Double tempPrice = rs.getDouble("product_price");
                int stockUpdate = (rs.getInt("product_qnty")) + qtyInput;
                pst = con.prepareStatement(
                        "update product set product_name= ?,product_price=?,product_qnty=? where product_id = "
                                + idInput);
                pst.setString(1, tempName);
                pst.setDouble(2, tempPrice);
                pst.setInt(3, stockUpdate);
                int k = pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getSum(TableModel table) {
        double sum = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
        }
        return sum;
    }

    public CartItem returnCartItem(Connection con, CartItem item, int idInput, int qtyInput) {
        CartItem i1 = new CartItem();
        ResultSet rs = null;
        try {
            rs = pst.executeQuery("Select * from product where product_id = " + idInput);
            while (rs.next()) {
                item.setProductId(rs.getInt("product_id"));
                item.setProductName(rs.getString("product_name"));
                item.setProductPrice(rs.getDouble("product_price"));
                item.setProductQty(qtyInput);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i1;
    }

    public String prepUpdate(Connection con, Product product) {

        try {

            pst = con
                    .prepareStatement(
                            "update product set product_name= ?,product_price=?,product_qnty=? where product_id =?");

            pst.setString(1, product.getProductName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3, product.getQnty());
            pst.setInt(4, product.getProductId());
            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(null, "Record Update");

            } else {
                JOptionPane.showMessageDialog(null, "Record not Updated");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;

    }

    public void Login(Connection con, User user) {

        try {

            pst = con.prepareStatement("Select username, password from credentials where username=? and password=?");
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            rs = pst.executeQuery();
            if (rs.next()) {
                OrderMenu orderMenu = new OrderMenu();
                orderMenu.show();
                JOptionPane.showMessageDialog(null, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                LoginPage l = new LoginPage();
                l.setVisible(true);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

    public TableModel table_load(Connection con) {
        try {
            pst = con.prepareStatement("select * from product");
            rs = pst.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DbUtils.resultSetToTableModel(rs);

    }

    public Product prepSearch(Connection con, Product product) {
        Product p1 = new Product();
        try {

            pst = con
                    .prepareStatement(
                            "select product_name,product_price,product_qnty from product where product_id = ?");

            pst.setInt(1, product.getProductId());
            rs = pst.executeQuery();

            if (rs.next() == true) {
                p1.setProductName(rs.getString(1));
                p1.setPrice(rs.getInt(2));
                p1.setQnty(rs.getInt(3));
            } else {
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return p1;

    }

    public String prepDelete(Connection con, Product product) {

        try {

            pst = con
                    .prepareStatement("delete from product where product_id =?");
            pst.setInt(1, product.getProductId());
            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(null, "Record Delete");

            } else {
                JOptionPane.showMessageDialog(null, "Record not Delete");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;

    }

    public String addShipDetails(Connection con, ShippingDetails shipDetails) {
        try {

            pst = con.prepareStatement(
                    "insert into shipping(lastname,firstname,streetaddress,city,province,zipcode,phonenumber,email)values(?,?,?,?,?,?,?,?)");
            pst.setString(1, shipDetails.getFirstName());
            pst.setString(2, shipDetails.getLastName());
            pst.setString(3, shipDetails.getAddress());
            pst.setString(4, shipDetails.getCity());
            pst.setString(5, shipDetails.getProvince());
            pst.setString(6, shipDetails.getZipcode());
            pst.setString(7, shipDetails.getPhonenumber());
            pst.setString(8, shipDetails.getEmail());
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(null, "Shipping Addedd");
            } else {
                JOptionPane.showMessageDialog(null, "Shipping Details Existing");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
