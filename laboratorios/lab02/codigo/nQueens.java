
/**
 * This program gives us the number of valid tables for a specified nxn table taht miay have invalid positions.
 * This class has a Read method that reads the size and invalid squares of the table.
 * It also has the method Backtrack used to determine whether a table is valid or not, and it returns the number of valid tables.
 *
 * @author (Pedro Quintero)
 * @version (24/02/2019)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class nQueens {

    private int[] table;
    private int[] invalid;

    public void Read(String path){

        String reader;
        int cont = 0;

        try{

            Scanner sca = new Scanner(new File(path));

            while(sca.hasNextLine()){

                reader = sca.nextLine();
                if(!reader.equals("") && !reader.equals("0")){

                    try{

                        int queens = Integer.parseInt(reader);

                        if(cont!=0){
                            int possibilities = Backtrack(table,invalid,1,0);
                            System.out.println(possibilities);
                        }
                        table = new int[queens];
                        invalid = new int[queens];
                        cont = 0;

                    }catch (NumberFormatException e){

                        cont++;

                        if(reader.contains("*")){

                            for(int i = 0; i<reader.length(); i++){

                                if(reader.charAt(i) == '*'){
                                    invalid[i] = cont;
                                }

                            }

                        }

                    }

                }else{

                }

            }

        }catch (FileNotFoundException ex){

        }

    }


    private int Backtrack(int[] table, int[] invalid, int row, int column){

        int cont = 0;

        if(column == table.length){

            return 1;

        }else{

            while(row<=table.length) {

                if(invalid[column]== row){

                    if(row+1<=table.length){
                        row++;
                    }else{
                        return cont;
                    }

                }else {

                    table[column] = row;

                    if (isValid(table, column)) {

                        cont += Backtrack(table, invalid, 1, column + 1);

                    }
                }

                row++;
            }

        }

        return cont;

    }

    private boolean isValid(int[] screen, int n) {

        if (n == 0) {
            return true;
        } else {

            boolean isValid = true;

            for (int i = 0; i < n; i++) {

                if ((screen[i] == screen[n]) || (Math.abs(screen[i] - screen[n]) == Math.abs(i - n))) {

                    isValid = false;
                    break;

                }

            }

            return isValid;
        }
    }

}
