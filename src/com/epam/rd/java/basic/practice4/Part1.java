package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final String LINE_SEP = System.lineSeparator();
    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        Pattern p;
        StringBuilder rez = new StringBuilder();

        p = Pattern.compile("[\\S]+["+ LINE_SEP +"]*");
        Matcher m = p.matcher(getInput("part1.txt"));
        List<String> words = new ArrayList<>();
        while (m.find()){
            words.add(m.group());
        }
        for (String word : words){
            if(word.contains(LINE_SEP)){
                if(word.length()>=4+ LINE_SEP.length()){
                    rez.append(word.substring(2));
                }else{
                    rez.append(word);
                }
            }else {
                if(word.length()>=4){
                    rez.append(word.substring(2)).append(" ");
                }else{
                    rez.append(word).append(" ");
                }
            }

        }
        rez.deleteCharAt(rez.length()-1);
        System.out.println(rez);
    }

    public static String getInput(String fileName) {

        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName), "Cp1251")){
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
        return sb.toString();
    }
    public static int forTest(int a){
        //for test)
        return ++a;
    }
}
