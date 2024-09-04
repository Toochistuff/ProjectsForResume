/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab3A
*/
import java.util.Scanner;
public class Lab3A {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Amount owed: ");
        int owedamount = scan.nextInt();
        System.out.println("APR: ");
        float apr = scan.nextFloat();

        double aprdecimal = (apr /100);

        double monthlyrate = (apr / 12);
        double minpayment = ((owedamount*aprdecimal)/12);

        System.out.println("Monthly percentage rate: "+monthlyrate);
        System.out.println("Minimum payment: $"+minpayment);

    }
}
