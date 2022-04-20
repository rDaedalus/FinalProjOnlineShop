package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import model.Product;
import model.User;
import net.proteanit.sql.DbUtils;
import view.LoginPage;
import view.OrderMenu;

public class DataBaseController {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public Connection Connect() {

        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/onlineshop";
            String username = "Daedalus";
            String password = "1Casiowatch";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            JOptionPane.showMessageDialog(null, "Connected");
        } catch (ClassNotFoundException | SQLException e) {

        }
        return connection;

    }

    public String prepAdd(Connection con, Product product) {
        try {

            pst = con
                    .prepareStatement("insert into product(product_name,product_price,product_qnty)values(?,?,?)");
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

}
