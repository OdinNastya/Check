package main.java.ru.clevertec.check;

public class Product {
    private int id;
    private String name;
    private double price;
    private boolean wholesaleProduct;

    public Product(int id, String name, double price, boolean WholesaleProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.wholesaleProduct = WholesaleProduct;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWholesaleProduct() {
        return wholesaleProduct;
    }
}
