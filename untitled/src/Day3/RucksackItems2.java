package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class RucksackItems2 {

    public static void main(String[] args) {
        String fileIn = "src/Day3/input.txt";
        int prioritySum = 0;

        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            String line;
            int count = 0;
            String[] group = new String[3];
            while((line = in.readLine()) != null){
                group[count] = line;
                if (count == 2){
                    prioritySum += matchingItemPriority(group);
                    count = 0;
                } else count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Printing result to console
        System.out.println(prioritySum);
    }

    static int matchingItemPriority(String[] group){

        // Split group into rucksacks
        char[] rucksack1 = group[0].toCharArray();
        char[] rucksack2 = group[1].toCharArray();
        char[] rucksack3 = group[2].toCharArray();

        //System.out.println(new String(comp1));
        //System.out.println(new String(comp2));

        // Find common item within rucksacks and return priority rank
        for (char item1 : rucksack1){
            for (char item2 : rucksack2){
                if (item1 == item2){
                    for (char item3 : rucksack3){
                        if (item1 == item3){
                            return Character.isLowerCase(item1) ? item1 - 96 : item1 - 64 + 26;
                        }
                    }
                }
            }
        } return -1;
    }
}

