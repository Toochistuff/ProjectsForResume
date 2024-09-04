/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment1C
*/
import java.util.Scanner;
public class Assignment1C {
    public static void main(String [] args){
        Scanner scan= new Scanner(System.in);
        System.out.println("[And the next letter is] ");
        System.out.println("Please enter a letter:  ");
        char input = scan.next().charAt(0);

        int num = (int)input; // casting//
        num++;//increasd letter up one space
        char input1 = (char)num;//changed it back to a char

        int num2 = (int)input; // casting//
        num2 = num2+2;//increasd letter up two space
        char input2 = (char)num2;//changed it back to a char

        int num3 = (int)input; // casting//
        num3=num3+3;//increasd letter up three space
        char input3 = (char)num3;//changed it back to a char



        System.out.println("The next letters after "+ input+ " are "+ input1 +", "+input2+", and "+input3+"!");






    }
}
