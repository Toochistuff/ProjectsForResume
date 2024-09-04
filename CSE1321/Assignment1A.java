/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment1A
*/
import java.util.Scanner;
public class Assignment1A {
    public static void main (String[] args){

        Scanner scan= new Scanner(System.in);

        System.out.println("[Print Resolution]");
        System.out.println(" ");
        System.out.println("Enter the width (in pixels):");
        int width = scan.nextInt();
        System.out.println("Enter the height (in pixels): ");
        int height = scan.nextInt();
        System.out.println("Enter the resolution (PPI): ");
        int resolution = scan.nextInt();

        float widthininches =(float)width / resolution;
        float heightininches = (float)height/resolution;

        System.out.println("At "+ resolution+" PPI, the image is "+ widthininches+"'' wide by "+heightininches+"'' high.");
    }
}
