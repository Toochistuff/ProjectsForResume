/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment3B
*/
import java.util.Scanner;
public class Assignment3B {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What belt grade are you?");
        int grade = scan.nextInt();
        switch(grade){
            case 0:
                System.out.println("You have a black belt, with 0 stripes!");
                break;
            case 1:
                System.out.println("You have a brown belt, with 2 stripes!");
                break;
            case 2:
                System.out.println("You have a brown belt, with 1 stripe!");
                break;
            case 3:
                System.out.println("You have a green belt, with 2 stripes!");
                break;
            case 4:
                System.out.println("You have a green belt, with 1 stripe!");
                break;
            case 5:
                System.out.println("You have a blue belt, with 2 stripes!");
                break;
            case 6:
                System.out.println("You have a blue belt, with 1 stripe!");
                break;
            case 7:
                System.out.println("You have a yellow belt, with 2 stripes!");
                break;
            case 8:
                System.out.println("You have a yellow belt, with 1 stripe!");
                break;
            case 9:
                System.out.println("You have a white belt, with 1 stripes!");
                break;
            case 10:
                System.out.println("You have a white belt, with 0 stripes!");
                break;

            default:System.out.println("You have no belt...");
            break;
        }
    }
}
