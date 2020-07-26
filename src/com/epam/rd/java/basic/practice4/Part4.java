package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {
    private static StringBuilder input = new StringBuilder();
    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        input = fileRead();
        Part4 p4 = new Part4();
        Iterator<String> iterator = p4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static StringBuilder fileRead() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("part4.txt"), "Cp1251")) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorForstring();
    }

    private class IteratorForstring implements Iterator<String> {

        Pattern p = Pattern.compile("[A-ZÀ-ß¨²¯]\\D[^.]+[.]");
        Matcher m = p.matcher(input);
        boolean has =false;

        @Override
        public boolean hasNext() {
            has = m.find();
            return has;
        }

        @Override
        public String next() {
            if (has){
            String s = m.group();
            return s.replaceAll(System.lineSeparator(), " ");}
            else{
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static int forTest(int a) {
        //for test)
        return ++a;
    }
}
