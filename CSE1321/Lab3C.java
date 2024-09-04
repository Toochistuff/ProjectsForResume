/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab3C
*/
import java.util.Scanner;
public class Lab3C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dollartotal = 0;

        System.out.println("Enter the number of quarters: ");
        int quarters = scan.nextInt();
        System.out.println("Enter the number of dimes: ");
        int dimes = scan.nextInt();
        System.out.println("Enter the number of nickels: ");
        int nickels = scan.nextInt();
        System.out.println("Enter the number of pennies: ");
        int pennies = scan.nextInt();

        System.out.println("You entered " + quarters + " quarters.");
        System.out.println("You entered " + dimes + " dimes.");
        System.out.println("You entered " + nickels + " nickels.");
        System.out.println("You entered " + pennies + " pennies.");

        int actualamountcents = (quarters * 25) + (dimes * 10) + (nickels * 5) + (pennies * 1);

        int totaldollar = actualamountcents/100;
        int totalcents = actualamountcents%100;

        System.out.println("Your total is "+ totaldollar+" dollars and "+ totalcents+" cents.");


    }
}