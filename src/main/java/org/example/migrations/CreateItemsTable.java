package org.example.migrations;

import org.example.infra.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateItemsTable {
    public static boolean migrate(){

        Connection con= null;

        try {
            con = DB.getConnection();
            String query = "CREATE TABLE IF NOT EXISTS items (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "item_name VARCHAR(255) NOT NULL," +
                        "price DECIMAL(10, 2))";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DB.closeConnection(con);
            return false;
        }
    }
}
