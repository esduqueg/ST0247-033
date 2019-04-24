import java.util.Scanner;

public class Menu {

    public Menu() {
        displayMenu();
    }

    private void displayMenu(){

        boolean still = true;
        while (still) {
            Scanner sca = new Scanner(System.in);
            System.out.println("\t\t\tLevehstein Distance\n\n");
            System.out.println("Enter the first word:\n");
            String word1 = sca.nextLine().toLowerCase();
            System.out.println("Enter the second word:\n");
            String word2 = sca.nextLine().toLowerCase();
            Corrector corrector = new Corrector();
            int lev = corrector.corregir(word1, word2);
            System.out.println("The leveshtein distance between " + word1 + " and " + word2 + " is of: " + lev+"\n");
            System.out.println("Do you wanna exit?\n");

            while(true) {
                try {
                    word1 = sca.nextLine().toLowerCase();
                    if (!word1.equals("yes")) {
                        if(!word1.equals("no")) {
                            throw new Exception();
                        }
                    } else {
                        if (word1.equals("yes")) {
                            still = false;
                            break;
                        }else{
                            break;
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid entry. Enter it again:\n");
                }
            }
        }

        System.out.println("\t\t\tBye!!!");

    }

}
