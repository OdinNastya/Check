package main.java.ru.clevertec.check;

public class CheckItem {

    private Product product;
    private int quantity;
    private double discountPercentage;
    private double totalWithoutDiscount;
    private double discountAmount;

    public CheckItem(Product product, int quantity, double discountPercentage) {
        this.product = product;
        this.quantity = quantity;
        this.discountPercentage = discountPercentage;
        this.totalWithoutDiscount = product.getPrice() * quantity;
        this.discountAmount = totalWithoutDiscount * (discountPercentage / 100);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getTotalWithoutDiscount() {
        return totalWithoutDiscount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getTotalWithDiscount() {
        return totalWithoutDiscount - discountAmount;
    }
}
