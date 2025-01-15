package br.com.alura.exercicios;

public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void applyDiscount(double discount) {

        if (discount > 0 && discount <= 100) {
            price -= price * (discount / 100);
        } else {
            System.out.println("Desconto inválido! Deve estar entre 0 e 100.");
        }
    }
}
