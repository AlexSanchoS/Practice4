package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static Logger logger = Logger.getAnonymousLogger();
    public static void main(String[] args) {
        String inputFile = readFile();
        Scanner scanner = new Scanner(System.in);
        String consoleInp = scanner.nextLine();
        StringBuilder result = new StringBuilder(consoleInp+": ");
        consoleInp=consoleInp.toLowerCase();
        Pattern p;
        String regex;
        Matcher m;
        while (!consoleInp.equals("stop")) {
            if (consoleInp.equals("latn")) {
                regex = "[\\w]+";
            } else {
                if (consoleInp.equals("cyrl")) {
                    regex = "[À-ßà-ÿ¨¸²³¯¿]+";
                } else {
                    result.append("Incorrect input");
                    System.out.println(result);
                    break;
                }
            }
            p = Pattern.compile(regex);
            m = p.matcher(inputFile);
            while (m.find()) {
                result.append(m.group()).append(" ");
            }
            System.out.println(result);
            result.delete(0, result.length() - 1);
            consoleInp = scanner.nextLine();
            result.append(consoleInp).append(": ");
            consoleInp=consoleInp.toLowerCase();
        }
    }

    private static String readFile() {

        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("part6.txt"), "Cp1251")) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File not found", e);
        }
        return result.toString();
    }
    public static int forTest(int a) {
        //for test)
        return ++a;
    }

}
