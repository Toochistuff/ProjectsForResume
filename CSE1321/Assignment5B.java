import java.util.Scanner;
public class Assignment5B {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What month were you born in?");
        int month = scan.nextInt();
        System.out.println("And what day?");
        int day = scan.nextInt();



        int [][] myArray  = new int [12][]; // set it up with 12 foe each month
        myArray[1] = new int [31];
        myArray[2] = new int [28];
        myArray[3] = new int [31];
        myArray[4] = new int [30];
        myArray[5] = new int [31];
        myArray[6] = new int [30];
        myArray[7] = new int [31];
        myArray[8] = new int [31];
        myArray[9] = new int [30];
        myArray[10] = new int [31];
        myArray[11] = new int [30];
        myArray[12] = new int [31];



    }
}
