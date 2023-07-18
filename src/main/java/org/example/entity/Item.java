package org.example.entity;

public record Item(
        Integer id,
        String name,
        Double price
) {
    @Override
    public String toString() {
        String str = id + " - " + name + " R$" + price.toString() + "\n";
        return str;
    }
}
