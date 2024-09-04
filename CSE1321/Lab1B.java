/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab1B
*/
import java.util.Scanner;
public class Lab1B {

    public static void main ( String [] args ){
        String message;
        Scanner scan = new Scanner(System.in);
        System.out.print ("Enter a line of text: ");
        message = scan.nextLine();
        System.out.println("You wrote '" + message + "'");

    }
}
