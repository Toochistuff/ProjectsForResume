//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
// convert the currency from and of the following to each other : US Dollars, European Euros, Japanese Yen, Russian Pound, Nigeria Naira, Australian Dollar
public class currencyconvert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();
        System.out.println("Please select your current currency:");
        System.out.println("1) Dollar");
        System.out.println("2) Euro");
        System.out.println("3) Yen");
        System.out.println("4) Pound");
        System.out.println("5) Naira");
        System.out.println("6) Australian Dollar");
        int currentc = scan.nextInt();
        System.out.println();
        System.out.println("Enter the current value of the current currencey:");
        int currentv = scan.nextInt();
        System.out.println();
        System.out.println("Select the currency you want to convert to:");
        System.out.println("1) Dollar");
        System.out.println("2) Euro");
        System.out.println("3) Yen");
        System.out.println("4) Pound");
        System.out.println("5) Naira");
        System.out.println("6) Australian Dollar");
        int expectedcurrency = scan.nextInt();
        switch (currentc){
            case 1:
                if (expectedcurrency ==2){
                    double output = (currentv * (.96));
                    System.out.println("The conversion is from "+ currentv+" dollar(s) to "+output+" euro(s)");
                    break;
            } else if (expectedcurrency == 3) {
                    double output = (currentv * (157.81));
                    System.out.println("The conversion from "+ currentv+" dollar(s) to "+output+" yen(s).");
                    break;
                } else if (expectedcurrency == 4) {
                    double output = (currentv * (0.8));
                    System.out.println("The conversion from "+ currentv+"dollar(s) to "+output+" pound(s).");
                    break;
                } else if (expectedcurrency == 5) {
                    double output = (currentv * (1546.02));
                    System.out.println("The conversion from "+ currentv+" dollar(s) to "+output+" naria.");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (1.6));
                    System.out.println("The conversion from "+ currentv+" dollar(s) to "+output+" Australian dollar(s).");
                    break;
                }
            case 2:
                if (expectedcurrency ==1){
                    double output = (currentv * (1.04));
                    System.out.println("The conversion is from "+ currentv+" euro(s) to "+output+" dollar(s)");
                    break;
                } else if (expectedcurrency == 3) {
                    double output = (currentv * (164.11));
                    System.out.println("The conversion from "+ currentv+" euro(s) to "+output+" yen(s).");
                    break;
                } else if (expectedcurrency == 4) {
                    double output = (currentv * (0.83));
                    System.out.println("The conversion from "+ currentv+" euro(s) to "+output+" pound(s).");
                    break;
                } else if (expectedcurrency == 5) {
                    double output = (currentv * (1608.60));
                    System.out.println("The conversion from "+ currentv+" euro(s) to "+output+" naria.");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (1.66));
                    System.out.println("The conversion from "+ currentv+" euro(s) to "+output+" Australian dollar(s).");
                    break;
                }
            case 3:
                if (expectedcurrency ==1){
                    double output = (currentv * (0.0063));
                    System.out.println("The conversion is from "+ currentv+" yen(s) to "+output+" dollar(s)");
                    break;
                } else if (expectedcurrency == 2) {
                    double output = (currentv * (0.0061));
                    System.out.println("The conversion from "+ currentv+" yen(s) to "+output+" euro(s).");
                    break;
                } else if (expectedcurrency == 4) {
                    double output = (currentv * (0.0051));
                    System.out.println("The conversion from "+ currentv+" yen(s) to "+output+" pound(s).");
                    break;
                } else if (expectedcurrency == 5) {
                    double output = (currentv * (9.85));
                    System.out.println("The conversion from "+ currentv+" yen(s) to "+output+" naria.");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (0.010));
                    System.out.println("The conversion from "+ currentv+" yen(s) to "+output+" Australian dollar(s).");
                    break;
                }
            case 4:
                if (expectedcurrency ==1){
                    double output = (currentv * (1.25));
                    System.out.println("The conversion is from "+ currentv+" pound(s) to "+output+" dollar(s)");
                    break;
                } else if (expectedcurrency == 2) {
                    double output = (currentv * (1.21));
                    System.out.println("The conversion from "+ currentv+" pound(s) to "+output+" euro(s).");
                    break;
                } else if (expectedcurrency == 3) {
                    double output = (currentv * (197.9));
                    System.out.println("The conversion from "+ currentv+" pound(s) to "+output+" yen(s).");
                    break;
                } else if (expectedcurrency == 5) {
                    double output = (currentv * (1939.99));
                    System.out.println("The conversion from "+ currentv+" pound(s) to "+output+" naria.");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (2.00));
                    System.out.println("The conversion from "+ currentv+" pound(s) to "+output+" Australian dollar(s).");
                    break;
                }
            case 5:
                if (expectedcurrency ==1){
                    double output = (currentv * (0.00065));
                    System.out.println("The conversion is from "+ currentv+" naira to "+output+" dollar(s)");
                    break;
                } else if (expectedcurrency == 2) {
                    double output = (currentv * (0.00062));
                    System.out.println("The conversion from "+ currentv+" naira to "+output+" euro(s).");
                    break;
                } else if (expectedcurrency == 3) {
                    double output = (currentv * (0.1));
                    System.out.println("The conversion from "+ currentv+" naira to "+output+" yen(s).");
                    break;
                } else if (expectedcurrency == 4) {
                    double output = (currentv * (0.00052));
                    System.out.println("The conversion from "+ currentv+" naira to "+output+" pound(s).");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (0.0010));
                    System.out.println("The conversion from "+ currentv+" naira to "+output+" Australian dollar(s).");
                    break;
                }
            case 6:
                if (expectedcurrency ==1){
                    double output = (currentv * (0.63));
                    System.out.println("The conversion is from "+ currentv+" Australian Dollar(s) to "+output+" dollar(s)");
                    break;
                } else if (expectedcurrency == 2) {
                    double output = (currentv * (0.6));
                    System.out.println("The conversion from "+ currentv+" Australian Dollar(s) to "+output+" euro(s).");
                    break;
                } else if (expectedcurrency == 3) {
                    double output = (currentv * (98.88));
                    System.out.println("The conversion from "+ currentv+" Australian Dollar(s) to "+output+" yen(s).");
                    break;
                } else if (expectedcurrency == 6) {
                    double output = (currentv * (0.5));
                    System.out.println("The conversion from "+ currentv+" Australian Dollar(s) to "+output+" pound(s).");
                    break;
                } else if (expectedcurrency == 5) {
                    double output = (currentv * (971.38));
                    System.out.println("The conversion from "+ currentv+" Australian Dollar(s) to "+output+" naira.");
                    break;
                }
        }


    }
}