package com.company;

import com.sun.source.tree.IfTree;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Check extends DataBase {

    public void newArray(String s,Boolean c){
        createArray();
        String[] words = s.split(" ");
        HashMap<String,Integer> listQt = new HashMap<>();
        HashMap<String,Double> newName = new HashMap<>();
        int SizeName = 0;
        int SizePrice = 0;
        for (String word : words) {
            String Name;
            Name = identify.get(Integer.parseInt(word.substring(0, 1)));
            if(SizeName < Name.length()){
                SizeName = Name.length();
            }
            String Price = String.valueOf(cost.get(Name));
            if(SizePrice < Price.length()){
                SizePrice = Price.length();
            }
            newName.put(Name, cost.get(Name));
            listQt.put(Name, Integer.valueOf(word.substring(2, 3)));
        }
        title();
        Double Total ;
        Double Discount;
        Double DiscountCount =0.0;
        Double Sum = 0.0;
        ArrayList<String> listWr = new ArrayList<>();
        ArrayList<String> listWrTotal = new ArrayList<>();
        for (Object st: title()) {System.out.println(st);}
        for (Map.Entry<String, Double> pair : newName.entrySet()) {
            Total= pair.getValue() * listQt.get(pair.getKey());
            Sum=Sum+Total;
            if (listQt.get(pair.getKey())>5){
                listWr.add(listQt.get(pair.getKey()) + "  " + getSizeStr(pair.getKey(),SizeName)+ " $" + getSizeStr(pair.getValue(),SizePrice)
                        + " $" + Total);
                //доработать с точностью
                Discount=Total * 0.1;
                DiscountCount= DiscountCount + Discount ;
                listWr.add("                               Discount $" + Discount);
            }else {
                listWr.add(listQt.get(pair.getKey())+ "  " + getSizeStr(pair.getKey(),SizeName) + " $" + getSizeStr(pair.getValue(),SizePrice)
                        + " $" + Total);
            }
        }
        listWrTotal.add("=============================================");
        listWrTotal.add("Taxable Tot.                           $" + Sum);
        if(c){
            listWrTotal.add("Card discount                      $" + Sum * 0.01);
            Total =Sum + Sum * 0.01 - DiscountCount;
        }else {
            Total = Sum - DiscountCount;
        }
        listWrTotal.add("Discount                               $" + DiscountCount);
        listWrTotal.add("TOTAL                                  $" + Total);
        //try(BufferedWriter writer = new BufferedWriter(new FileWriter("Z:\\javaClev\\Check.txt",false)))
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ODINTVOVA\\javaClev\\Check.txt",false)))
        {
            for (Object st: title()) {
                writer.write(st + System.lineSeparator());
            }
            for (String st: listWr) {
                writer.write(st + System.lineSeparator());
                System.out.println(st);
            }
            for (String st: listWrTotal){
                writer.write(st + System.lineSeparator());
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String checkId(String line,boolean value){
        String inId;
        if(value){
            System.out.println("Ведите номер товала и его количество через -\nНовое наименование вводится с пробела!");
            Scanner sc = new Scanner(System.in);
            inId=sc.nextLine();}
        else {
            inId = line;
        }
        String[] words = inId.split(" ");
        createArray();
        for (String word : words) {
            if(word.contains("-")) {
                int Id = Integer.parseInt(word.substring(0, word.indexOf("-")));
                if (identify.containsKey(Id))
                    System.out.println();
                else {
                    System.out.println("Были введены некоректные данные или номер наименования нет в катологе");
                    inId = null;
                }
            }else inId =null;
        }
        return inId;
    }
    static boolean card() {
        Boolean Card = false;
        Scanner sc = new Scanner(System.in);
        int i=0;
        while (i == 0) {
            System.out.println("Имеется скидочная карта?(да/нет)\n");
            String avail =  sc.nextLine();
            switch (avail) {
                case "да":
                    System.out.println("Введите номер карты");
                    int c = sc.nextInt();
                    cardBase();
                    if (cards.contains(c)){
                        Card = true;
                        i = 1;
                        break;
                    }else {
                        System.out.println("Карта не действительна или введены не те данные");
                        i = 0;
                        break;
                    }
                case "нет":
                    i = 1;
                    break;
                default:
                    System.out.println("Не верный ввод! Попробуйте еще раз.\n");
                    i = 0;
                    break;
            }
        }
        return Card;
    }
    String getSizeStr(String str,Integer x){
        String StrName;
        StrName = str + "          ";
        while (StrName.length() !=(x+10)) {
            StrName += " ";
        }
        return StrName;

    }
    String getSizeStr(Double str,Integer x){
        String StrName;
        StrName = str + "          ";
        while (StrName.length() !=(x+10)) {
            StrName += " ";
        }
        return StrName;

    }
}
