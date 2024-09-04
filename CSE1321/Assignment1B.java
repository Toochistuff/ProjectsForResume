/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment1B
*/
import java.util.Scanner;
public class Assignment1B {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your average lab grade: ");
        float labgrade = scan.nextFloat();
        System.out.println("Enter your average assignment grade: ");
        float assignmentgrade = scan.nextFloat();
        System.out.println("Enter your midterm exam grade: ");
        float midtermgrade = scan.nextFloat();
        System.out.println("Enter your final exam grade: ");
        float finalgrade = scan.nextFloat();

        double labaverage = labgrade * .1;
        double assignmentaverage = assignmentgrade * .4;
        double midtermaverage = midtermgrade * .2;
        double finalaverage = finalgrade * .3;

        System.out.println("Your weighted lab average is "+ labaverage);
        System.out.println("Your weighted midterm exam average is "+ assignmentaverage);
        System.out.println("Your weighted midterm exam average is "+ midtermaverage);
        System.out.println("Your weighted final exam average is "+finalaverage);
        double completefinal = (labaverage+assignmentaverage+midtermaverage+finalaverage);

        System.out.println("Adding numbers...");

        System.out.println("Your final grade in CSE1321L is "+ completefinal);


    }
}
