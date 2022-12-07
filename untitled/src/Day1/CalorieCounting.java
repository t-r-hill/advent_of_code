package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CalorieCounting {

    public static void main(String[] args) {
        String fileInput = "src/Day1/input.txt";
        ArrayList<Integer> elves;

        // Stream in input file
        try (BufferedReader in = new BufferedReader(new FileReader(fileInput))) {
            String line;
            elves = new ArrayList<Integer>();
            int cals = 0;

            // Stream each line of calories and sum each line until a blank line
            // then add sum to elves array list and reset sum
            while ((line = in.readLine()) != null) {
                if (line.equals("")) {
                    elves.add(cals);
                    cals = 0;
                } else cals += Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Variables for elves with three largest amounts of calories
        int elf1 = 0;
        int elf2 = 0;
        int elf3 = 0;

        // Loop through elves and if elf has one of three largest amounts than replace the elf
        // currently in that position and shuffle each elf down
        for (int elf : elves){
            if (elf > elf3){
                if (elf > elf2){
                    if (elf > elf1){
                        elf3 = elf2;
                        elf2 = elf1;
                        elf1 = elf;
                    } else {
                        elf3 = elf2;
                        elf2 = elf;
                    }
                } else elf3 = elf;
            }
        }

        // Sum of three largest calories
        int total = elf1 + elf2 + elf3;

        // Print sum to console
        System.out.println(total);
    }
}