package main.java.ru.clevertec.check;
import java.util.List;


public class Check {
    private List<CheckItem> items;
    private double totalPrice;
    private double totalDiscount;
    private double totalWithDiscount;
    private int discountCardNumber;
    private int discountPercentage;

    public Check(List<CheckItem> items, double totalPrice, double totalDiscount, double totalWithDiscount, int discountCardNumber, int discountPercentage) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalWithDiscount = totalWithDiscount;
        this.discountCardNumber = discountCardNumber;
        this.discountPercentage = discountPercentage;
    }

    public Check(String s) {
    }

    public List<CheckItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public int getDiscountCardNumber() {
        return discountCardNumber;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

}
