package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;



public class CheckRunner extends DataBase {
    //при  общем Scanner не считывает следующий элемент
   //public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // write your code here
        Check check = new Check();
        int NumberItem = CheckRunner.vv();
        while (NumberItem!= 0) {
            if (NumberItem == 1) {
                String z = check.checkId(null,true);
                if (z != null) {
                    check.newArray(z, check.card());
                }else System.out.println("Некорректные данные. Попробуйте еще раз!");
            }else if (NumberItem == 3){
                check.checkId(CheckRunner.readingFile(),false);
            }
            NumberItem = CheckRunner.vv();
        }
    }
    private static String readingFile() {
        String Base=null;
        try {
            Base = Files.readString(Path.of("ReadFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base;
    }
    static int vv(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите пункт:\n1. Создать новый чек\n2. Загрузить чек с файла\n" +
                "3. Загрузить входные данные с файла \n0. Выход");
        int x=0;
        int number = 0;
        while (x == 0){
            number = sc.nextInt();
            switch (number){
                case 1:
                    number=1;
                    x=1;
                    break ;
                case 2:
                    try(FileReader reader = new FileReader("Check.txt"))
                    {   int c;
                        while((c=reader.read())!=-1){
                            System.out.print((char)c);
                        }
                        x=1;
                        break ;
                    }
                    catch(IOException ex){
                        number=2;
                        x=1;
                        System.out.println(ex.getMessage());
                        break ;
                    }
                case 3:
                    number=3;
                    x=1;
                    break ;
                case 0:
                    number=0;
                    x=1;
                    break ;
                default:
                    System.out.println("Введена неверная цифра! Попробуйте еще раз.\n");
                    break;
            }
        }
        return number;
    }
}
