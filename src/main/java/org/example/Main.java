package org.example;

import org.example.entity.Item;
import org.example.migrations.CreateWishListTable;
import org.example.repositories.ItemRepository;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        ItemRepository itemRepository = new ItemRepository();

//        Item item = new Item(null, "algo", "test.com", 23.99);
//        itemRepository.save(item);

//        Item updt = new Item(1,"sdasd", "test", 20.00);
//        itemRepository.update(updt);

//        itemRepository.delete(2);


        List<Item> items;
        items = itemRepository.getAll();

        for(Item i : items) {
            System.out.println(i);
        }

        System.out.println(itemRepository.get(1));
    }
}