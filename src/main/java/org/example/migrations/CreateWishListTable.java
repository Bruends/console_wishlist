package org.example.migrations;

import org.example.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateWishListTable {
    public static boolean migrate(){
        Connection con = ConnectionFactory.getConnection();

        if (con == null) {
            return false;
        }

        try {
            String query = "CREATE TABLE IF NOT EXISTS items (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "item_name VARCHAR(255) NOT NULL," +
                        "store_link VARCHAR(255)," +
                        "price DECIMAL(10, 2))";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
