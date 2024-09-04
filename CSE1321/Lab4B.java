/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab4B
*/
import java.util.Scanner;
public class Lab4B {
    public static void main(String [] args){
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter the day: ");
        String dayname= scan.nextLine();

        if (dayname.equalsIgnoreCase("Monday")){
            System.out.println("I have class today!");
        }
        if (dayname.equalsIgnoreCase("Tuesday")){
            System.out.println("I should use this time to do my homework.");
        }
        if (dayname.equalsIgnoreCase("Wednesday")){
            System.out.println("I have class today!");
        }
        if (dayname.equalsIgnoreCase("Thursday")){
            System.out.println("I should use this time to do my homework.");
        }
        if (dayname.equalsIgnoreCase("Friday")){
            System.out.println("It's Friday! Friday! Gotta get down on Friday!");
        }
    }
}
//How do I get this one to  worry about the lowercase days and not just the Uppercase ones?