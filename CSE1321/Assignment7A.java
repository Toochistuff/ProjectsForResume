import java.util.Scanner;
class FSA{
    int state;

 public FSA(int state) {
            if(state >= 0 && state <= 3) {
                this.state = state;
            }
            else {
                System.out.println("This is an invalid state, Starting at state 0");
                this.state = 0;
            }
    }
    public int goToNextState() {
        if(state == 3) {
            state = 0;
        }
        else {
            state++;
        }
        return state;
    }
    public boolean end() {
        if(state == 3) {
            return true;
        }
        return false;
    }

}
public class Assignment7A {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        FSA machine;


        System.out.println("What state do you want to start at?");
        machine = new FSA(scan.nextInt());
        System.out.println("What will you do?");
        System.out.println("- Go to the next state");
        System.out.println("- End");
        String opt = scan.nextLine();
        if(opt.equals("Go to next state")) {
            System.out.println("\nYou're now at state " + machine.goToNextState() + ".");
        }
        else if(opt.equals("End")) {
            if(machine.end()) {
                System.out.println("\nThe machine has shut down.");

            }
            else {
                System.out.println("\nYou can't top here; you can only stop at state 3.\n");
            }
        }
        else {
            System.out.println("\nInvalid command");
        }
    }

}
