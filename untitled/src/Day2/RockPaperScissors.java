package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

    public static void main(String[] args) {
        String fileIn = "src/Day2/input.txt";
        int score = 0;

        // Guessed strategy
        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            String line;
            while((line = in.readLine()) != null){
                score += calculateScore2(line.charAt(0), line.charAt(2));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(score);

    }

    public static int calculateScore(char oppHand, char myHand){
        int handScore = 0;
        // Points for hand
        switch(myHand){
            case 'X' :
                handScore = 1;
                break;
            case 'Y' :
                handScore = 2;
                break;
            case 'Z' :
                handScore = 3;
                break;
        }
        switch(myHand - oppHand){
            case 23 :
                handScore += 3;
                break;
            case 22 :
            case 25 :
                handScore += 0;
                break;
            case 21 :
            case 24 :
                handScore += 6;
                break;
        }
        return handScore;
    }

    public static int calculateScore2(char oppHand, char outcome){
        int handScore = 0;
        int hand = 0;
        // Points for hand
        switch(outcome){
            case 'X' :
                handScore = 0;
                hand = -1;
                break;
            case 'Y' :
                handScore = 3;
                hand = 0;
                break;
            case 'Z' :
                handScore = 6;
                hand = 1;
                break;
        }
        switch(oppHand){
            case 'A' :
                handScore += Math.floorMod(hand, 3) + 1;
                break;
            case 'B' :
                handScore += Math.floorMod(1 + hand, 3) + 1;
                break;
            case 'C' :
                handScore += Math.floorMod(2 + hand, 3) + 1;
                break;
        }
        return handScore;
    }
}
