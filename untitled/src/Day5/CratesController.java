package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class CratesController {

    public static void main(String[] args) {
        String fileIn = "src/Day5/input.txt";
        ArrayList<Stack<String>> crates = new ArrayList<>();
        ArrayList<ArrayList<String>> crateInput = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            String line;
            while(!(line = in.readLine()).isBlank()) {
                ArrayList<String> temp = new ArrayList<String>();
                for (int i = 0; i < line.length(); i += 4){
                    temp.add(line.substring(i, Math.min(i + 4, line.length())).strip());
                }
                crateInput.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        crateInput.get(crateInput.size() - 1).stream().forEach(i -> crates.add(new Stack<String>()));

        for (int i = crateInput.size() - 2; i >= 0; i--){
            ArrayList<String> temp = crateInput.get(i);
            for (int j = 0; j < temp.size(); j++){
                if (!temp.get(j).isBlank()){
                    crates.get(j).push(temp.get(j));
                }
            }
        }

        System.out.println(crates);

        try(BufferedReader in = new BufferedReader(new FileReader(fileIn))){
            for (int i = 0; i < crateInput.size() + 1; i++){
                in.readLine();
            }

            String line;

            int numBlocks;
            int from;
            int to;

            while((line = in.readLine()) != null) {
                if (line.startsWith("move")){
                    String[] temp = line.split(" ");
                    numBlocks = Integer.parseInt(temp[1]);
                    from = Integer.parseInt(temp[3]) - 1;
                    to = Integer.parseInt(temp[5]) - 1;

                    for (int i = 0; i < numBlocks; i++){
                        crates.get(to).push(crates.get(from).pop());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String answer;

        String message = crates.stream().map(i -> i.peek()).collect(Collectors.joining()).replaceAll("\\[|\\]","");
        System.out.println(message);
    }
}
