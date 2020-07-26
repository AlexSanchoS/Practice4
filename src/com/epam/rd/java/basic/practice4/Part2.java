package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {
    private static final int N = 10;
    private static Logger logger = Logger.getAnonymousLogger();
    private static int[] randomNumber = new int[10];
    private static int[] inputNumber = new int[10];

    public static void main(String[] args) {
        SecureRandom r = new SecureRandom ();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            randomNumber[i]=r.nextInt(50);
            sb.append(randomNumber[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        writeFile("part2.txt", sb.toString());
        getInput();
        StringBuilder sb1 = new StringBuilder("input ==> ");
        StringBuilder sb4 = new StringBuilder();
        for (int a: inputNumber) {
            sb1.append(a).append(" ");
        }
        StringBuilder sb2 = new StringBuilder("output ==> ");
        for (int i = 0; i < N; i++) {
            int min=i;
            for (int j = i; j < N; j++) {
                if(inputNumber[j]<inputNumber[min]){
                    min=j;
                }
            }
            sb2.append(inputNumber[min]).append(" ");
            sb4.append(inputNumber[min]).append(" ");
            inputNumber[min]=inputNumber[min]+inputNumber[i];
            inputNumber[i]=inputNumber[min]-inputNumber[i];
            inputNumber[min]=inputNumber[min]-inputNumber[i];
        }
        sb1.deleteCharAt(sb1.length()-1);
        sb2.deleteCharAt(sb2.length()-1);
        writeFile("part2_sorted.txt", sb4.toString().trim());
        System.out.println(sb1);
        System.out.println(sb2);
    }

    public static void getInput() {
        try (Scanner scanner = new Scanner(new File("part2.txt"), "Cp1251")) {
            int i =0;
            while (scanner.hasNextInt()) {
                inputNumber[i]=scanner.nextInt();
                i++;
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
    }

    public static void writeFile(String fileName, String text){
        try (PrintStream file = new PrintStream(fileName, "Cp1251")) {
            file.print(text);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
    }
    public static int forTest(int a){
        //for test)
        return ++a;
    }

}
