package org.example;

import org.example.migrations.CreateWishListTable;

public class Main {
    public static void main(String args[]) {
        boolean res = CreateWishListTable.migrate();
        if (res) {
            System.out.println("Successagem!");
        }
    }
}