package task01.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    public String dirPath = "./data2";

    public String fileName = "cat_in_the_hat.txt";

    public ArrayList<String> remainingTokens;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }
    public FileReader() {

    }

    public void readFile() throws IOException {
        remainingTokens = new ArrayList<>();

        File file = new File(dirPath + File.separator + fileName);


        java.io.FileReader fr = new java.io.FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String incomingString;

        while (null != (incomingString = br.readLine())){
            incomingString = incomingString.toLowerCase();
            String[] tokens = incomingString.split(" ");
            for (int i = 0; i < tokens.length; i++){
                String incomingToken = tokens[i].replaceAll("\\W", "");
                if (incomingToken.isEmpty()){
                    continue;
                }
                remainingTokens.add(incomingToken);
            }

        }

        fr.close();
        br.close();
    }

    public void showFile(){
        if (remainingTokens == null) {
            System.err.println("No file found :(");
        } else {
            for (String iterator:remainingTokens){
                System.out.println(iterator);
            }
        }
    }


}
