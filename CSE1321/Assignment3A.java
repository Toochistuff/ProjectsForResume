/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment3A
*/
import java.util.Scanner;
public class Assignment3A {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello stranger! Do you have time to hear my tale? ");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int input = scan.nextInt();

        if (input == 2){
            System.out.println("Ah. then goodbye ...");

        }
        else if (input == 1){
            System.out.println("Thank you! I come from the land of Pax Bisonica. Our country has been taken over by a cruel tyrant!");
            System.out.println("1) That's awful!");
            System.out.println("2) What can I do?");
            int input2 = scan.nextInt();

            if (input2 ==1){
                System.out.println("Alas, it is truly terrible...");
            }
            else if (input2 ==2){
                System.out.println("What can I do? ");

            }
            System.out.println("Please, you must journey to Pax Bisonica and free our country!");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int input3 = scan.nextInt();

            if (input3 == 2){
                System.out.println("Then all is lost... ");
            }
            else if(input3 ==1){
                System.out.println("Hooray!");
            }
        }
    }
}
