package org.example.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static java.sql.Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/wishlist";
        return DriverManager.getConnection(url, "root", "root");
    }

    public static void closeConnection(Connection con){
        if (con == null) return;

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
