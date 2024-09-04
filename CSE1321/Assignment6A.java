/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment6A
*/
import java.util.Random;
import java.util.Scanner;
public class Assignment6A {

    public static void create_random_array(int[]array, int array_size){
        Random rand = new Random();

        for (int i =0;i < array_size; i++){
            array[i] = rand.nextInt(1000)-500;
        }
    }

    public static boolean is_array_sorted(int[] array, int array_size){
        if(array[0]<array[1] && array[1]<array[2]){
           return true;
        }
        return false;
    }

    public static void sort_array(int[]array, int array_size){
        for(int i =0; i <array_size-1; i++){
            int index = i;
            for(int j=i+1; j<array_size; j++){
                if (array[j]<array[index]){
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }


    public static void main(String[] args) {
        int n =10;
        int array[] = new int[n];
        Scanner sc = new Scanner(System.in);
        create_random_array(array, n);
        System.out.print("Random Array: ");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[n - 1]);
        int choice = 0;
        while (choice != 4) {
            // give choice
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Generate a new random array");
            System.out.println("2) Is the array is sorted?");
            System.out.println("3) Sort the array");
            System.out.println("4) Quit");
            System.out.print("\nChoice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                create_random_array(array, n);
                System.out.print("\nRandom Array: ");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(array[i] + ", ");
                }
                System.out.println(array[n - 1]);
            } else if (choice == 2) {
                if (is_array_sorted(array, n)) {
                    System.out.println("\nThe array is sorted.");

                } else {
                    System.out.println("\nThe array is not sorted.");

                }
            } else if (choice == 3) {
                sort_array(array, n);
                System.out.print("\nSorted Array: ");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(array[i] + ", ");
                }
                System.out.println(array[n - 1]);
            } else if (choice != 4) {
                System.out.println("\nTry again..");
            }
        }
        sc.close();
    }
}

