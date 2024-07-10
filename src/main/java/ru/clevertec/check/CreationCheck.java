package main.java.ru.clevertec.check;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreationCheck {
    private List<Product> products;
    private List<Discount> discountCards;

    public CreationCheck(List<Product> products, List<Discount> discountCards) {
        this.products = products;
        this.discountCards = discountCards;
    }

    public Check bildCheck(Map<Integer, Integer> productQuantities, int discountCardNumber, double balance) throws Exception {
        List<CheckItem> items = new ArrayList<>();
        final double[] totalAmount = {0.0};
        final double[] totalDiscount = {0.0};

        int discount = discountCards.stream()
                .filter(card -> card.getNumber() == discountCardNumber)
                .findFirst()
                .map(Discount::getDiscount)
                .orElse(0);

        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("BAD REQUEST: Product with ID " + productId + " not found"));

            if (quantity <= 0) {
                throw new Exception("BAD REQUEST: Invalid quantity for product with ID " + productId);
            }

            double itemDiscount = 0;
            if (product.isWholesaleProduct()&& quantity >4 ) {
                itemDiscount = 10;
            } else {
                itemDiscount = discount;
            }

            CheckItem checkItem = new CheckItem(product, quantity, itemDiscount);
            items.add(checkItem);
            totalAmount[0] += checkItem.getTotalWithoutDiscount();
            totalDiscount[0] += checkItem.getDiscountAmount();
        }

        double totalWithDiscount = totalAmount[0] - totalDiscount[0];
        return new Check(items, totalAmount[0], totalDiscount[0], totalWithDiscount, discountCardNumber, discount);
    }
}
