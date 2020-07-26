package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        String[] ar;
        Locale locale;
        ResourceBundle bundle;
        while (!scan.equals("stop")){
            ar= scan.split((" "));
            locale = new Locale(ar[1]);
            bundle = ResourceBundle.getBundle("resources", locale);
            System.out.println(bundle.getString(ar[0]));
            scan=scanner.nextLine();
        }

    }
    public static int forTest(int a) {
        //for test)
        return ++a;
    }

}
