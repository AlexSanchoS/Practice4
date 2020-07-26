import com.epam.rd.java.basic.practice4.Part1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static String getInput(String fileName) {

        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (PrintWriter file = new PrintWriter(System.getProperty("user.dir") + "\\part6.txt", "Cp1251")) {
            file.print("Is there anybody going to listen to my story \n" +
                    "Лягає день. Він віддає свої надії ночі. \n" +
                    "Робітники \n" +
                    "Заморились працювати. \n" +
                    "С барабаном ходит ёжик. Бум-бум-бум.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(getInput("part1.txt"));
        Part1.main(new String[]{"", ""});
    }

}
