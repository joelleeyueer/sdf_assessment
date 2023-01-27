package task01.src;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        //read file and store each word into hashmap
        //if new, add to hashmap, value = 1
        //if existing, get key and value++
        //store hashmap into arraylist class and sort
        //print arraylist class

//        String fileName = args[0];
//
        FileReader fr = new FileReader();

        fr.readFile();
//        fr.showFile();

        HashMap<String, Integer> frequency = new HashMap<>();

        while (!fr.remainingTokens.isEmpty()){
            String currentToken = fr.remainingTokens.get(0);
            fr.remainingTokens.remove(0);

            //if contains, value+1
            if (frequency.containsKey(currentToken)){
                frequency.put(currentToken,frequency.get(currentToken)+1);
            } else { //add to hashmap
                frequency.put(currentToken, 1);
            }
        }

        //print out hashmap
        frequency.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //sort hashmap by value in ascending order
        







    }
}
