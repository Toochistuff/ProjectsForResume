/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment2B
*/
import java.util.Scanner;
public class Assignment2B {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the X coordinate for Keyframe #1: ");
        int x1= scan.nextInt();
        System.out.println("Enter the X coordinate for Keyframe #2: ");
        int x2= scan.nextInt();
        System.out.println("How many frames have passed? ");
        float framespassed = scan.nextFloat();
        int moveinsecond = x2 - x1;

        System.out.println("The character has to move "+ moveinsecond+" places in a second.");

        float fps30= x1+moveinsecond*framespassed/30;
        float fps60 = x1+moveinsecond*framespassed/60;
        System.out.println("At 30 FPS, their current X position would be "+fps30);
        System.out.println("At 60 FPS, their current X positions would be "+fps60);

    }
}
