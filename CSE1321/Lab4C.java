/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab4C
*/
import java.util.Scanner;
public class Lab4C {
    public static void main(String [] args){
        Scanner scan = new Scanner (System.in);
        System.out.println("Welcome!");
        System.out.println("Please input a number: ");
        float input = scan.nextFloat();
        System.out.println("What would you like to do to this number: ");
        System.out.println("0- Get the additive inverse of the number");
        System.out.println("1- Get the reciprocal of the number");
        System.out.println("2- Square the number ");
        System.out.println("3- Cube the number ");
        System.out.println("4- Exit the program ");
        int choice = scan.nextInt();

        switch(choice){
            case 0:
                System.out.println("The additive inverse of "+input+" is "+(-1*input));
                break;

            case 1:
                System.out.println("The reciprocal of "+input + " is "+(1/input));
                break;

            case 2:
                System.out.println("The square of "+input+ " is "+ (input*input));
                break;

            case 3:
                System.out.println("The cube of "+input+ " is "+ (input*input*input));
                break;

            case 4:
                System.out.println("Thank you, goodbye!");
                break;

            default:
                System.out.println("Invalid input, please try again!");



        }
    }
}
