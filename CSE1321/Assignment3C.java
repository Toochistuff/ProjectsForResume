/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment3C
*/
import java.util.Scanner;
public class Assignment3C {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What mobile device do you have? ");
        String mobiled = scan.nextLine();

        if (mobiled.equalsIgnoreCase("Android") || mobiled.equalsIgnoreCase("Apple")) {

            System.out.println("What version do you have? ");
            float version = scan.nextFloat();
            if (mobiled.equalsIgnoreCase(("Android")) && version >= 11) {
                String arinput = scan.nextLine();
                System.out.println("Congratulations, you can run the app!");
            }
            else if  (mobiled.equalsIgnoreCase(("Android")) && version <= 11){
                System.out.println("Does your device support Augmented Reality? ");
                String arinput = scan.nextLine();
                arinput = scan.nextLine();
                if (arinput.equalsIgnoreCase("Yes")) {
                    System.out.println("Congratulation, you can run this app!");
                } else if (arinput.equalsIgnoreCase("No")) {
                    System.out.println("I'm sorry, our app does not support your device.");
                }

            }
             if (mobiled.equalsIgnoreCase(("Apple")) && version >= 12) {
                System.out.println("Congratulations, you can run the app!");
            }
             else if (mobiled.equalsIgnoreCase(("Apple")) && version <= 12) {
                System.out.println("Does your device support Bluetooth connections? ");
                 String btinput = scan.nextLine();
                  btinput = scan.nextLine();

                if (btinput.equalsIgnoreCase("Yes")) {
                    System.out.println("Congratulation, you can run the app!");
                } else if (btinput.equalsIgnoreCase("No")) {
                    System.out.println("I'm sorry, our app does not support your device.");
                }
            }

        } else {
            System.out.println("I'm sorry, our app does not support your device.");
        }
    }
    }
