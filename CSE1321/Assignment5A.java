import java.util.Scanner;
public class Assignment5A {
    public static void main(String [] args){
        int myArray[] = new int [5]; //1d array
        Scanner scan =new Scanner (System.in);
        System.out.println("[Top 5 Friend's List]");
        int choice;
        do {
            System.out.println("What would you like to do?");
            System.out.println("1) Enter a friend's name");
            System.out.println("2) Replace a friend's name");
            System.out.println("3) Display your friends list");
            System.out.println("4) Quit");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a name:");
                    String name = scan.nextLine();
                    name += myArray;
                    break;
                case 2:
                    System.out.println("Enter a name: ");
                    String name2 = scan.nextLine();
                    System.out.println("Enter an index:");
                    int index2 = scan.nextInt();
                    System.out.println(name2 + " has replaced Scrappy on your friends list!");
                    break;
                case 3:
                    for (int i =0; i<5; i++){
                        System.out.println("Friend's List: ");
                        System.out.println((i+1)+") "+myArray[i]);
                        break;
                    }
                case 4:
                    System.out.println("[Program Ends]");
                    break;
            }
        }
        while(choice!=4);
    }
}
