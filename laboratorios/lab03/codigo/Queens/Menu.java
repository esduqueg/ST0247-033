import  java.util.Scanner;


public class Menu {

    Scanner sca;
    Backtraking bt;

    public Menu(){

        sca = new Scanner(System.in);
        bt = new Backtraking();
        displayMenu();

    }

    private void displayMenu(){

        while(true) {

            System.out.println("\n\t\t\tBacktraking Program!!\n" +
                    "This program uses a Backtraking algorithm to find a solution for the n-Queen problem.\n"+
                    "If in the solution you got just n num of 0, it means that there is not an answer for that number of queens.\n"+
                    "\nTHIS PROGRAM JUST WORKS FOR 13 OR LESS QUEENS!!!\n\n"+
                    "Please enter the number of queens: ");

            int queens = sca.nextInt();

            if(queens<0){

                break;

            }

            int[] solution = bt.standar(queens);

            System.out.println("\nLa solucion es:\n");

            for (int i = 0; i < solution.length; i++) {

                System.out.print(solution[i] + " ");

            }
        }
    }

}
