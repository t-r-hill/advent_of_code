package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Decoder {

    public static void main(String[] args) {
        String fileIn = "src/Day6/input.txt";
        char[] block;


        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static char[] getChars(BufferedReader in, int numChars) throws IOException{
        char[] chars = new char[numChars];
        int charsRead = in.read(chars,0,numChars);
        if (charsRead != -1){
            return chars;
        } else return null;
    }
}
