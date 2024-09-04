/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab2A
*/
import java.util.Scanner;
public class Lab2A {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = scan.nextLine();
        System.out.println("Enter another name: ");
        String anothername = scan.nextLine();
        System.out.println("Enter a verb: ");
        String verb = scan.nextLine();
        System.out.println("Enter an adverb: ");
        String adverb = scan.nextLine();
        System.out.println("Once upon a time, there was a person named "+ name+" who had a child named "+anothername+". This child would "+ verb+" "+adverb+" while singing to strangers.");
    }
}
