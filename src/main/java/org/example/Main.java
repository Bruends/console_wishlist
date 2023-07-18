package org.example;

import org.example.Menu.Menu;
import org.example.migrations.CreateItemsTable;

public class Main {
    public static void main(String[] args) {
        CreateItemsTable.migrate();
        Menu menu = new Menu();
        menu.mainOptions();
    }
}