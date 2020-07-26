package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static Logger logger = Logger.getAnonymousLogger();
    private static StringBuilder input = new StringBuilder();

    public static void main(String[] args) {
        fileRead();
        Scanner scanner = new Scanner(System.in);
        String consoleLine = scanner.nextLine();
        String pattern = "";
        while (!consoleLine.equals("stop")) {
            switch (consoleLine) {
                case "char":
                    pattern = "\\b[a-zA-Zà-ÿÀ-ß¸³¿]\\s";
                    System.out.println(forInt1(pattern, true));
                    break;
                case "int":
                    pattern = "^[1-9]+\\s|\\s[1-9]+\\s|\\s[1-9]+$";
                    System.out.println(forInt1(pattern, true));
                    break;
                case "double":
                    pattern = "[\\d]*[.][\\d]+";
                    System.out.println(forInt1(pattern, false));
                    break;
                case "String":
                    pattern = "[a-zA-Zà-ÿÀ-ß¸³¿]{2,}";
                    System.out.println(forInt1(pattern, false));
                    break;
                default:
                    input.delete(0,input.length());
                    System.out.println("Incorrect input");
                    return;
            }
            consoleLine = scanner.nextLine();
        }
        input.delete(0,input.length());
    }

    private static String forInt1(String regex, boolean a) {
        StringBuilder sb = new StringBuilder();
        Pattern p;
        Matcher m;
        p = Pattern.compile(regex);
        m = p.matcher(input);
        if (a) {
            while (m.find()) {
                sb.append(m.group().trim()).append(" ");
            }
        } else {
            while (m.find()) {
                sb.append(m.group()).append(" ");
            }
        }
        return sb.toString();
    }

    private static void fileRead() {
        try (Scanner scanner = new Scanner(new File("part3.txt"), "Cp1251")) {
            while (scanner.hasNextLine()) {
                input.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
    }

    public static int forTest(int a) {
        //for test)
        return ++a;
    }

}
