package task01.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //read file and store each word into hashmap
        //if new, add to hashmap, value = 1
        //if existing, get key and value++
        //store hashmap into arraylist class and sort
        //print arraylist class

        String fileName = args[0];
//        FileReader fr = new FileReader();
        FileReader fr = new FileReader(fileName);

        fr.readFile();
//      fr.showFile();

        Double tokenSize = Double.valueOf(fr.remainingTokens.size());
        System.out.println("Total words: " + tokenSize);

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


        List<Word> sortedFrequency = new ArrayList<>();

        //add hashmap to new list
        frequency.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
            sortedFrequency.add(new Word(entry.getKey(), entry.getValue()));
        });

        //store hashmap into arraylist and sort hashmap by value in ascending order.

        Collections.sort(sortedFrequency, Collections.reverseOrder());

        System.out.println("Printing the top 10 words in " + fr.fileName);
        try {
            for (int i = 0; i < 10; i++){

                System.out.println( i+1 + ". " +sortedFrequency.get(i).word + " - " + sortedFrequency.get(i).frequency + " words (term frequency: " + Double.valueOf(sortedFrequency.get(i).frequency)/tokenSize + ")");
            }
        } catch (Exception e){
            System.out.println("End of file");
        }











    }
}
