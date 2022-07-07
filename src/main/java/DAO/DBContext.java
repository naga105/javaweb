package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class DBContext {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "localhost";
    private final String dbName = "Assignment";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

    public static void main(String[] args) {
        try {
            Connection connection = new DBContext().getConnection();

            if(connection!=null) {
                ArrayList<Product>  pcd= new DAO().displayEachPage("office",1,3);
                System.out.println(pcd);


            } else {
                System.out.println("Connect failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
