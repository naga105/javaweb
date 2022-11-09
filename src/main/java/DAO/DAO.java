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
                acc = new Account(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
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

    public Product getProduct(String id){
        try{
            String query = "SELECT * FROM Product where ProductId=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            rs = ps.executeQuery();
            ArrayList<Product> prdList = new ArrayList<>();
            while(rs.next()){
                Product pd = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5) );
                prdList.add(pd);
            }
            return prdList.get(0);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Product> displayEachPage(String catagory, int beginProduct, int endProduct){
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

public  ArrayList<Cart> showCart(String acc){
    try {
        String query = "select Cart.OrderId,ProductName,Price,quantity,Cart.productImg from (Cart inner join Product on Cart.ProductId=Product.ProductId) where username=? order by OrderId";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        System.out.println("username:"+acc);
        ps.setString(1,acc);
        rs = ps.executeQuery();
        ArrayList<Cart> cart = new ArrayList<>();
        while(rs.next()){
            Cart crt = new Cart(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
            cart.add(crt);
            System.out.println(crt);
        }
        return cart;
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
    public ArrayList<String> getAllCart(){
        try {
        String query = "Select OrderId FROM Cart order by OrderId";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        ArrayList<String> cart = new ArrayList<>();
        while(rs.next()){
           cart.add(rs.getString(1));
        }
        return cart;
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
    public void deleteformCart(String id, String username){
        try {
            String query = "Delete from Cart where username=? and OrderId=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,id);
            ps.executeUpdate();
    } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
public void addCart(String id ,String username,String productid, int quantity,String img ){
        try{
            String query= "insert into Cart(OrderId, username, ProductId, quantity,productImg) values(?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,username);
            ps.setString(3,productid);
            ps.setInt(4,quantity);
            ps.setString(5,img);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
}
public void checkoutCart(String username){
        try{
            String query="Delete from Cart where username=? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
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