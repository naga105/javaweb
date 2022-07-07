package DAO;

import Model.Account;
import Model.Cart;
import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public Account login(String username, String password) {
        try {
            String query = "select * from Login where username=? and password=?";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            Account acc = null;
            while (rs.next()) {
                acc = new Account(rs.getString(1), rs.getString(2));
                return acc;
            }
            System.out.println(acc);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void signUp(Account acc) {
        try {
            String query = "insert into Login values (?, ?, ?, ?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassword());
            ps.setInt(3, acc.getRole());
            ps.setString(4, acc.getFullName());
            ps.setString(5, "null");
            ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Product> displayEachPage(String catagory,int beginProduct, int endProduct){
    try{
    String query = "SELECT * FROM Product where ProductType=? ORDER BY ProductId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    conn = new DBContext().getConnection();
    ps = conn.prepareStatement(query);
    ps.setString(1,catagory);
    ps.setInt(2, beginProduct);
    ps.setInt(3, endProduct);
    rs = ps.executeQuery();
    ArrayList<Product> prdList = new ArrayList<>();
    while(rs.next()){
        Product pd = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5) );
        prdList.add(pd);
    }
    return prdList;
} catch (SQLException | ClassNotFoundException e) {
    throw new RuntimeException(e);
}
    }

public ArrayList<Cart> showCart(Account acc){
    try {
        String query = "SELECT * FROM Cart where username=?";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ArrayList<Cart> cart = new ArrayList<>();

        return cart;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
    public ArrayList<Product> displayAll(String catagory) {
        try {
            String query = "select * from Product where ProductType=?";
            ArrayList<Product> prod = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, catagory);
            rs = ps.executeQuery();
            while(rs.next()){
            Product pd = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5) );
            prod.add(pd);
            }
            return prod;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}