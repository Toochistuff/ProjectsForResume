/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment2C
*/
import java.util.Scanner;
public class Assignment2C {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("General Bison welcomes you to Pax Bisonica!");
        System.out.println("How many US Dollars do you have? ");
        int USD = scan.nextInt();

        float BP = (float)(.85);
        float BD = 5;

        float UStoBP = (USD * BP);
        float BPtoBD = (UStoBP / BD);

        System.out.println(USD+ " US Dollar(s) is "+ UStoBP+" British Pound(s), which is worth "+ BPtoBD+" Bison Dollar(s)!");

        
    }
}
