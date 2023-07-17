package org.example.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/wishlist";
            return DriverManager.getConnection(url, "root", "root");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
