//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();


            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("Enter your first value:");
            int firstint = scan.nextInt();
            System.out.println("Enter your second value:");
            int secondint = scan.nextInt();
            System.out.println(" ");
            System.out.println("Next, please select your operation:");
            System.out.println("1) Addition ");
            System.out.println("2) Subtraction ");
            System.out.println("3) Multiplication ");
            System.out.println("4) Division ");
            System.out.println("5) Modulus");
            System.out.println("6) Exit Program");
            int option = scan.nextInt();

            switch (option){
                case 1:
                    int sum =(firstint + secondint);
                    System.out.println("The sum of "+firstint+" and "+ secondint+" is "+sum);
                    break;
                case 2:
                    int difference =(firstint - secondint);
                    System.out.println("The difference of "+firstint+" and "+ secondint+" is "+difference);
                    break;
                case 3:
                    int product =(firstint * secondint);
                    System.out.println("The product of "+firstint+" and "+ secondint+" is "+product);
                    break;
                case 4:
                    int quotient =(firstint / secondint);
                    System.out.println("The sum of "+firstint+" and "+ secondint+" is "+quotient);
                    break;
                case 5:
                    int mod =(firstint % secondint);
                    System.out.println("The modulus of "+firstint+" and "+ secondint+" is "+mod);
                    break;
                case 6:
                    break;
            }

        }
    }
