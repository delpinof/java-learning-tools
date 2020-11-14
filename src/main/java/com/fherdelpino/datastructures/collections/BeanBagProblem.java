package com.fherdelpino.datastructures.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BeanBagProblem {

    public static void main(String[] args) {
        List<Product> stock = new ArrayList<>();

        stock.add(new Product("bean", 5, 30));
        stock.add(new Product("rice", 4, 28));
        stock.add(new Product("almond", 3, 24));


        System.out.println(new BeanBagProblem().run(stock, 9));
    }

    private int run(Collection<Product> products, int bag) {
        int maxProfit = 0;
        Queue<Product> stock = new PriorityQueue<>(products);

        while (bag > 0) {
            Product p = stock.poll();
            int tmpAmount = Math.min(p.amount, bag);
            maxProfit += tmpAmount * p.getPricePerKg();
            bag -= tmpAmount;
        }

        return maxProfit;

    }


}

class Product implements Comparable<Product> {

    String name;
    int amount;
    int pricePerKg;

    Product(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.pricePerKg = price / amount;
    }

    int getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public int compareTo(Product p) {
        return p.getPricePerKg() - this.getPricePerKg();
    }
}
