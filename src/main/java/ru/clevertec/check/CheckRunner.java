package main.java.ru.clevertec.check;

import java.io.*;
import java.util.*;

public class CheckRunner {

    public static void main(String[] args){
        try {
            List<Product> products = CheckReader.readProducts("./src/main/resources/products.csv");
            List<Discount> discountCards = CheckReader.readDiscountCards("./src/main/resources/discountCards.csv");

            CreationCheck creationCheck = new CreationCheck(products, discountCards);

            Map<Integer, Integer> productQuantities = new HashMap<>();
            updateValue(productQuantities,3, 1);
            updateValue(productQuantities,2, 5);
            updateValue(productQuantities,3, 1);

            int discountCardNumber = 3333;
            double balance = 100.00;
            Check check = creationCheck.bildCheck(productQuantities, discountCardNumber, balance);
            if (check.getTotalWithDiscount()>balance)
                CheckSave.saveRecord("ERROR\n NOT ENOUGH MONEY", "./src/results.csv");
            else
                CheckSave.saveRecord(check, "./src/results.csv");
            CheckSave.printCheck(check);

        } catch (IOException e) {
            System.err.println("BAD REQUEST: Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateValue(Map<Integer, Integer> map, Integer key, Integer value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }
}


