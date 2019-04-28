import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        Scanner sca  = new Scanner(System.in);
        String word1,word2;
        System.out.println("Digite la primera cadena:\n");
        word1 = sca.nextLine();
        System.out.println("Digite la segunda cadena:\n");
        word2 = sca.nextLine();
        LCS lcs = new LCS();
        String answer = lcs.diff(word1,word2);
        System.out.println("LCS length: "+answer.length() + "\nLCS: "+answer);

    }

}
