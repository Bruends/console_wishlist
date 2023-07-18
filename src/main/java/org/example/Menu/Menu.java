package org.example.Menu;

import org.example.entity.Item;
import org.example.repositories.ItemRepository;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    ItemRepository itemRespository;

    public Menu() {
        this.itemRespository = new ItemRepository();
        this.scanner = new Scanner(System.in);
    }

    public void showAllItems(){
        System.out.println("WishList: ");
        System.out.println(itemRespository.getAll());
    }

    public void newItem(){
        // pegando dados
        System.out.println("nome do item: ");
        String name = scanner.nextLine();

        System.out.println("Preço: ");
        Double price = this.scanner.nextDouble();
        scanner.nextLine();

        // salvando
        boolean success = itemRespository.save(new Item(null, name, price));
        if (success) System.out.println("item salvo com sucesso!");

        mainOptions();
    }

    public void updateItem(){
        System.out.println("id do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("nome do item: ");
        String name = scanner.nextLine();

        System.out.println("Preço: ");
        Double price = scanner.nextDouble();
        scanner.nextLine();

        // editando
        boolean success = itemRespository.update(new Item(id, name, price));
        if (success) System.out.println("item editado com sucesso!");

        mainOptions();
    }

    public void deleteItem(){
        System.out.println("Deletar item: ");
        System.out.println("id do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // deletando
        boolean success = itemRespository.delete(id);
        if (success) System.out.println("item deletado com sucesso!");

        mainOptions();
    }

    public void mainOptions(){
        showAllItems();
        System.out.println("digite a opção desejada: ");
        System.out.println("1- Adicionar: ");
        System.out.println("2- Editar: ");
        System.out.println("3- Deletar: ");
        System.out.println("0- Cancelar: ");

        int op = this.scanner.nextInt();

        scanner.nextLine();

        if (op == 1) newItem();
        if (op == 2) updateItem();
        if (op == 3) deleteItem();

    }
}
