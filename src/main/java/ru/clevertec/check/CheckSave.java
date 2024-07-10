package main.java.ru.clevertec.check;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckSave {

    static void saveRecord(String check, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(check);
        }
    }

    static void saveRecord(Check check, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

            writer.println("Date; Time");
            writer.println(date + ";" + time);

            writer.println("QTY; DESCRIPTION; PRICE; DISCOUNT; TOTAL");
            for (CheckItem item : check.getItems()) {
                writer.printf("%d; %s; %.2f$; %.2f$; %.2f$\n",
                        item.getQuantity(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getDiscountAmount(),
                        item.getTotalWithoutDiscount());
            }
            if (check.getDiscountPercentage() > 0) {
                writer.println("DISCOUNT CARD; DISCOUNT PERCENTAGE");
                writer.printf("%d; %d%%\n", check.getDiscountCardNumber(), check.getDiscountPercentage());
            } else
                writer.printf("\n");
            writer.println("TOTAL PRICE; TOTAL DISCOUNT; TOTAL WITH DISCOUNT");
            writer.printf("%.2f$; %.2f$; %.2f$\n",
                    check.getTotalPrice(),
                    check.getTotalDiscount(),
                    check.getTotalWithDiscount());
        }
    }

    public static void printCheck(Check check) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

        System.out.println("Date; Time");
        System.out.println(date + ";" + time);

        System.out.println("QTY; DESCRIPTION; PRICE; DISCOUNT; TOTAL");
        for (CheckItem item : check.getItems()) {
            System.out.printf("%d; %s; %.2f$; %.2f$; %.2f$\n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getProduct().getPrice(),
                    item.getDiscountAmount(),
                    item.getTotalWithoutDiscount());
        }
        System.out.println("DISCOUNT CARD; DISCOUNT PERCENTAGE");
        System.out.printf("%d; %d%%\n", check.getDiscountCardNumber(), check.getDiscountPercentage());
        System.out.println("TOTAL PRICE; TOTAL DISCOUNT; TOTAL WITH DISCOUNT");
        System.out.printf("%.2f$; %.2f$; %.2f$\n",
                check.getTotalPrice(),
                check.getTotalDiscount(),
                check.getTotalWithDiscount());
    }
}
