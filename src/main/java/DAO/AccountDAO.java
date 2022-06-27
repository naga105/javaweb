package DAO;

import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public  Account login(String username, String password) {
        try {
            String query = "select * from Login where userName=? and password=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);


            rs = ps.executeQuery();

            Account acc = null;
            while (rs.next()) {
                acc = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
                return acc;

            }
            System.out.println(acc);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account signUp(Account acc) {
        try {
            String query = "insert into Login values (?, ?, ?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getRole());


            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}