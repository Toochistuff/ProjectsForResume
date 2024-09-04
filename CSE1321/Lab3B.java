/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Lab3B
*/
import java.util.Scanner;
public class Lab3B {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Course 1 hours: ");
        float course1hours = (int)scan.nextInt();
        System.out.println("Grade for course 1: ");
        float gradecourse1 = (int)scan.nextInt();
        System.out.println("Course 2 hours: ");
        float course2hours = (int)scan.nextInt();
        System.out.println("Grade for course 2: ");
        float gradecourse2 = (int)scan.nextInt();
        System.out.println("Course 3 hours: ");
        float course3hours = (int)scan.nextInt();
        System.out.println("Grade for course 3: ");
        float gradecourse3 = (int)scan.nextInt();
        System.out.println("Course 4 hours: ");
        float course4hours = (int)scan.nextInt();
        System.out.println("Grade for course 4: ");
        float gradecourse4 = (int)scan.nextInt();

        float totalhours = (int)(course1hours + course2hours+ course3hours+ course4hours);
        float qualitypoints = (int)((course1hours*gradecourse1)+(course2hours*gradecourse2)+(course3hours*gradecourse3)+(course4hours*gradecourse4));
        float GPA = qualitypoints / totalhours;

        System.out.println("Total hours is: "+ totalhours);
        System.out.println("Total quality points is: "+qualitypoints);
        System.out.println("Your GPA for this semester is "+ GPA);

    }
}
