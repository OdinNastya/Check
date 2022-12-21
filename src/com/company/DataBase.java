package com.company;

import java.sql.SQLOutput;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

abstract class DataBase {
    static HashMap<Integer, String> identify = new HashMap<>();
    static HashMap<String,Double> cost = new HashMap<>();
    static ArrayList <Integer> cards = new ArrayList<>();
    static void createArray(){
        identify.put(1,"Pasta");
        identify.put(2,"Flesh");
        identify.put(3,"Mushrooms");
        identify.put(4,"Chips");
        identify.put(5,"Pineapple");
        identify.put(6,"Oil");
        identify.put(7,"Eggs");
        identify.put(8,"Buckwheat");
        identify.put(9,"Lemon");
        identify.put(10,"Sugar");
        cost.put("Pasta",1.65);
        cost.put("Flesh",11.85);
        cost.put("Mushrooms",3.45);
        cost.put("Chips",2.35);
        cost.put("Pineapple",5.20);
        cost.put("Oil",7.45);
        cost.put("Eggs",2.55);
        cost.put("Buckwheat",1.89);
        cost.put("Lemon",4.23);
        cost.put("Sugar",2.74);
    }
    static ArrayList cardBase(){
        cards.add(1234);
        cards.add(4587);
        cards.add(2582);
        cards.add(5754);
        cards.add(8852);
        cards.add(7777);
        return cards;
    }

    ArrayList title(){
        ArrayList<String> haedTitle = new ArrayList<>();
        SimpleDateFormat formaterDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formaterTime = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        haedTitle.add("            CASH RECEIPT");
        haedTitle.add("          SUPERMARKET 123");
        haedTitle.add("       12, MILKYNAY Galaxy/ Earth");
        haedTitle.add("                             DATE:" +formaterDate.format(date));
        haedTitle.add("                               TIME:" +formaterTime.format(date));
        haedTitle.add("QTY DESCRIPTION        PRICE            TOTAL ");
    return haedTitle;
    }
}
