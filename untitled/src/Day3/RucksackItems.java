package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class RucksackItems {

    public static void main(String[] args) {
        String fileIn = "src/Day3/input.txt";
        int prioritySum = 0;

        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            String line;
            while((line = in.readLine()) != null){
            //System.out.println(line);
            //System.out.println(matchingItemPriority(line));
                prioritySum += matchingItemPriority(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Printing result to console
        System.out.println(prioritySum);
    }

    static int matchingItemPriority(String rucksack){

        // Split rucksack into compartments
        char[] comp1 = rucksack.substring(0, rucksack.length()/2).toCharArray();
        char[] comp2 = rucksack.substring(rucksack.length()/2).toCharArray();

        //System.out.println(new String(comp1));
        //System.out.println(new String(comp2));

        // Find common item within compartments and return priority rank
        for (char item1 : comp1){
            for (char item2 : comp2){
                if (item1 == item2){
                    return Character.isLowerCase(item1) ? item1 - 96 : item1 - 64 + 26;
                }
            }
        } return -1;
    }
}
