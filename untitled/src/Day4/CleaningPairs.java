package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CleaningPairs {

    public static void main(String[] args) {
        String fileIn = "src/Day4/input.txt";
        int overlaps = 0;

        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            String line;
            while((line = in.readLine()) != null){
                if (isPartialOverlap(line)) overlaps++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(overlaps);
    }

    // Method to parse line and determine if overlap
    static boolean isFullOverlap(String pair){
        String[] elf_strings = pair.split(",");
        int[] elf_ints = new int[4];
        // Generate int array from strings
        for (int j = 0; j < 2; j++){
            String[] elf_string = elf_strings[j].split("-");
            for (int i = 0; i < 2; i++) {
                elf_ints[2 * j + i] = Integer.parseInt(elf_string[i]);
            }
        }
        // Return true if overlap
        return (elf_ints[0] <= elf_ints[2] & elf_ints[1] >= elf_ints[3]) |
                (elf_ints[0] >= elf_ints[2] & elf_ints[1] <= elf_ints[3]);
    }

    // Method to parse line and determine if overlap
    static boolean isPartialOverlap(String pair){
        String[] elf_strings = pair.split(",");
        int[] elf_ints = new int[4];
        // Generate int array from strings
        for (int j = 0; j < 2; j++){
            String[] elf_string = elf_strings[j].split("-");
            for (int i = 0; i < 2; i++) {
                elf_ints[2 * j + i] = Integer.parseInt(elf_string[i]);
            }
        }
        // Return true if overlap
        return (elf_ints[0] <= elf_ints[2] & elf_ints[2] <= elf_ints[1]) |
                (elf_ints[2] <= elf_ints[0] & elf_ints[0] <= elf_ints[3]);
    }
}
