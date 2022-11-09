package DAO;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DAO_2 {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void changePassword(String newPassword,String username){
        try{
            String query="Update userDetail set user_password=? where username=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,newPassword);
            ps.setString(2,username);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }
        public User viewProfile(String username){
        try{
            String query="Select * from userDetail where username=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            rs= ps.executeQuery();
            ArrayList<User> user= new ArrayList<>();
            while(rs.next()) {
                User user1 = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                    user.add(user1);
            }
                return user.get(0);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }
        public String updateProfile(User user){
            try{
                String query="Update user detail set email=? set phone=? set name=?  set avatar=? set self_description=? where username=?";
                conn = new DBContext().getConnection();
                ps.setString(1,user.getEmail());
                ps.setString(2,user.getPhone());
                ps.setString(3,user.getName());
                ps.setString(4,user.getAvatar());
                ps.setString(5,user.getSelfDescription());
                ps.setString(6,user.getUsername());
                ps = conn.prepareStatement(query);
                ps.executeQuery();
                return "update Successfully";
            }catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
    }
    }
    public static void main(String[] args) {
        DAO_2 dao= new DAO_2();
        User user=dao.viewProfile("sa");
        System.out.println(user);
        return;
    }
}
