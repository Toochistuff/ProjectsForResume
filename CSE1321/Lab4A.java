/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab4A
*/
import java.util.Scanner;
public class Lab4A {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the score of your exam: ");
        float grade= scan.nextFloat();

        if (grade >= 97.5 ){
            System.out.println("Letter grade is: A+");
        }
        else if (grade >= 94.5 ){
            System.out.println("Letter grade is: A");
        }
        else if (grade >= 90.5 ){
            System.out.println("Letter grade is: A-");
        }
        else if (grade >= 88.5 ){
            System.out.println("Letter grade is: B+");
        }
        else if (grade >= 85.5){
            System.out.println("Letter grade is: B");
        }
        else if (grade >= 82.5 ){
            System.out.println("Letter grade is: B-");
        }
        else if (grade >= 79.5 ){
            System.out.println("Letter grade is: C+");
        }
        else if (grade >= 76.5 ){
            System.out.println("Letter grade is: C");
        }
        else if (grade >= 73.5 ){
            System.out.println("Letter grade is: C-");
        }
        else if (grade >= 70.5 ){
            System.out.println("Letter grade is: D+");
        }
        else if (grade >= 67.5 ){
            System.out.println("Letter grade is: D");
        }
        else if (grade >= 64.5 ){
            System.out.println("Letter grade is: D-");
        }
        else if (grade <= 64.4 ){
            System.out.println("Letter grade is: F");
        }
    }
}
