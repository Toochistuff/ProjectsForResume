/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment4A
*/
import java.util.Scanner;
public class Assignment4A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ghanatotal = 0;
        int italytotal = 0;
        int costaricatotal = 0;
        int paxtotal = 0;
        String input;
        int numstu = 1;
        String countrycount;

        do {
            System.out.println("Student #" + numstu + ": Which country we go to for our next study aboard program?");
            System.out.println("Italy");
            System.out.println("Costa Rica");
            System.out.println("Pax Bisonica");
            System.out.println("Ghana");
            System.out.println("(Type Quit to end the survey)");
            countrycount = scan.nextLine();
            System.out.println("Thank you!");
            numstu++;

            if (countrycount.equalsIgnoreCase("Ghana")) {
                ++ghanatotal;
            } else if (countrycount.equalsIgnoreCase("Italy")) {
                ++italytotal;
            } else if (countrycount.equalsIgnoreCase("Costa Rica")) {
                ++costaricatotal;
            } else if (countrycount.equalsIgnoreCase("Pax Bisonica")) {
                ++paxtotal;
            }
        }
        while (!(countrycount.equalsIgnoreCase("Quit")));

        if (countrycount.equalsIgnoreCase("Quit")){
            System.out.println("Results:");
            System.out.println("Italy: "+italytotal);
            System.out.println("Costa Rica: "+ costaricatotal);
            System.out.println("Pax Bisonica: "+paxtotal);
            System.out.println("Ghana: "+ghanatotal);
        }

    }
}
