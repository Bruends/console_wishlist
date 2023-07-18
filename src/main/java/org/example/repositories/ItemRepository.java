package org.example.repositories;

import org.example.entity.Item;
import org.example.infra.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    java.sql.Connection connection;

    public List<Item> getAll() {
        return executeQuery(null);
    }

    public Item get(int id) {
        Item item;
        List<Item> itemList = executeQuery(id);
        item = itemList != null ? itemList.get(0) : null;
        return item;
    }

    public boolean save(Item newItem) {
        String query = "INSERT INTO items VALUES (DEFAULT, ?, ?)";
        return executeUpdate(query, newItem);
    }

    public boolean update(Item newItem) {
        String query = "UPDATE items SET item_name = ?, price = ? WHERE id = ?";
        return executeUpdate(query, newItem);
    }

    public boolean delete(int id) {
        String query = "DELETE FROM items WHERE id = ?";
        return executeUpdate(query, id);
    }


    private List<Item> executeQuery(Integer id){
        List<Item> itemsList = new ArrayList<>();

        String query = "Select * FROM items";

        if (id != null) {
            query += " WHERE id = ?";
        }

        Connection con = null;

        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            if (id != null) {
                stmt.setInt(1, id);
            }
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("item_name"),
                        resultSet.getDouble("price")
                );

                itemsList.add(item);
            }

            return itemsList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            DB.closeConnection(con);
        }
    }

    private boolean executeUpdate(String query, Item item) {
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, item.name());
            stmt.setDouble(2, item.price());
            if (item.id() != null) {
                stmt.setInt(3, item.id());
            }

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected >= 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DB.closeConnection(con);
        }
    }

    private boolean executeUpdate(String query, int id) {
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected >= 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DB.closeConnection(con);
        }
    }
}
