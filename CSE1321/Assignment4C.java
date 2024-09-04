/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment4C
*/
import java.util.Scanner;
public class Assignment4C {
    public static void main(String [] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your sentence:");
        String sentence = scan.nextLine();
        System.out.println("How many letters do you want to backsapce? ");
        int backspace =scan.nextInt();
        char bc = 0;
        
        for(int i =1; i<backspace; i++){
            bc='\b';
            Thread.sleep(500);
            sentence = sentence +bc;

        }
        System.out.println(sentence + bc );
    }
}
