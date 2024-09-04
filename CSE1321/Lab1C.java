/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab1C
*/
import java.util.Scanner;
public class Lab1C {
    public static void main (String[]args){
        int miles;
        double gallons,mpg;
        Scanner scan =new Scanner (System.in);
        System.out.print("Enter the number of miles: ");
        miles = scan.nextInt();
         System.out.print ("Enter the gallons of fuel used: ");
         gallons = scan.nextDouble();
         mpg = miles / gallons;
         System.out.println("Miles Per Gallon: " + mpg);
    }
}
