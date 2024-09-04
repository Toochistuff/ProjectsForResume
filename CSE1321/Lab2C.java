/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab2C
*/
import java.util.Scanner;
public class Lab2C {
    public static void main(String [] args){
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a width: ");
        int width = scan.nextInt();
        System.out.println("Enter a height: ");
        int height = scan.nextInt();

        int area = width * height;
        int perimeter = width + width + height+ height;

        System.out.println("The area is "+area);
        System.out.println("The perimeter is "+perimeter);
    }
}
