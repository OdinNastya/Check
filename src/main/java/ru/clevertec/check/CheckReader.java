package main.java.ru.clevertec.check;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckReader {
    public static List<Product> readProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length < 5) {
                    throw new IOException("Invalid product entry: " + line);
                }
                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                double price = Double.parseDouble(values[2].trim());
                boolean isWholesaleProduct = values[4].trim().equals("true");
                products.add(new Product(id, name, price, isWholesaleProduct));
            }
        }
        return products;
    }

    public static List<Discount> readDiscountCards(String filePath) throws IOException {
        List<Discount> discountCards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length < 3) {
                    throw new IOException("Invalid discount card entry: " + line);
                }
                int number = Integer.parseInt(values[1].trim());
                int discount = Integer.parseInt(values[2].trim());
                discountCards.add(new Discount(number, discount));
            }
        }
        return discountCards;
    }

}

