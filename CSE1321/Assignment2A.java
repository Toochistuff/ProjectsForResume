/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment2A
*/
import java.util.Scanner;
public class Assignment2A {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many people are in your group? ");
        int people = scan.nextInt();
        System.out.println("How many groups do you want: ");
        int groups = scan.nextInt();

        int remainingpeople = people%groups;

        System.out.println("If we divide "+ people+ " people in "+ groups+" groups evenly, "+ remainingpeople+" person/people will be left without a group.");
    }
}
