/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment4B
*/
import java.util.Scanner;
public class Assignment4B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Please input a number: ");
        int input = scan.nextInt();
        System.out.println("What would you like to do to this number: ");
        int select = scan.nextInt();
        System.out.println("-1- Re-enter the number");
        System.out.println("0- Get the additive inverse of the number");
        System.out.println("1- Get the reciprocal of the number ");
        System.out.println("2- Square the number");
        System.out.println("3- Cube the number");
        System.out.println("4- Exit the program");

        do {

            switch (select) {
                case -1:
                    System.out.println("Please input a number: ");
                    input = scan.nextInt();
                    break;
                case 0:
                    int additive = (input * -1);
                    break;
                case 1:
                    int reciprocal = 1 / (1 / input);
                    break;
                case 2:
                    int square = input * input;
                    System.out.println("The sqaure of "+ input+ " is "+ square);
                    break;
                case 3:
                    int cube = input * input * input;
                    System.out.println("The cube of "+ input+ " is "+ cube);
                    break;
                case 4:
                    break;

            }


        }
        while (select != 4);
    }
}

