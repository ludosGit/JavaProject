 
 // public means that any other class can access it

import java.util.Scanner;

public class HelloWorld {
    // static means that you do not have to initialize an object to get the method
    // void it is returning nothing 
    // the args are an array of strings
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a string");
        String userInput = scanner.nextLine();;
        String formattedString = String.format("Hello %s, World pal!!!!", userInput);
        System.out.println(formattedString);
    }
}
