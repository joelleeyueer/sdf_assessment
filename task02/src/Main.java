package task02.src;

import java.io.Console;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Console console = System.console();

        System.out.println("Hi! Welcome to my simple calculator! " +
                "Please input an expression with the following syntax: number space operator space number. e.g. 4 + 3\n" +
                "$last + 3 adds 3 to your last calculated value!\n" +
                "Or type exit to quit!");

        Integer last = 0;

        while (true){
            try{
                String incomingLine = console.readLine();
                String[] incomingTokens = incomingLine.split(" ");
//            String[] incomingTokens = {"$last", "+", "3"};
                if (incomingTokens[0].equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                } else {
                    Integer firstNumber = 0;
                    Integer secondNumber = 0;

                    if (incomingTokens[0].equalsIgnoreCase("$last")) {
                        firstNumber = last;
                    }

                    if (incomingTokens[2].equalsIgnoreCase("$last")) {
                        secondNumber = last;
                    }

                    if (firstNumber == 0){
                        firstNumber = Integer.valueOf(incomingTokens[0]);
                    }

                    if (secondNumber == 0){
                        secondNumber = Integer.valueOf(incomingTokens[2]);
                    }



                    Integer answer = 0;

                    switch (incomingTokens[1]) {
                        case "+":
                            answer = firstNumber + secondNumber;
                            System.out.println(answer);
                            last = answer;

                            break;

                        case "-":
                            answer = firstNumber - secondNumber;
                            System.out.println(answer);
                            last = answer;
                            break;

                        case "/":
                            answer = firstNumber / secondNumber;
                            System.out.println(answer);
                            last = answer;
                            break;

                        case "*":
                            answer = firstNumber * secondNumber;
                            System.out.println(answer);
                            last = answer;
                            break;
                    }
                }
            } catch (Exception e){
                System.out.println("You entered an invalid value!\n"+
                        "Please input an expression with the following syntax: number space operator space number. e.g. 4 + 3\n" +
                        "$last + 3 adds 3 to your last calculated value!\n" +
                        "Or type exit to quit!");
            }

        }

    }
}
