
/**
 * This class impements LCS (Longest Common Subsequence)
 *
 *
 * @author Pedro Quintero Longas
 */

public class LCS {

    /**
     * diff methos setups the needed tools to solve the LCS problem, taking two strings sequence1 and sequence2 and returning a string lcs.
     * Tools:
     * rows, cols: length of each sequence plus one
     * table : integer table with rows x cols size.
     *
     * @param sequence1
     * @param sequence2
     * @return lcs
     */

    public String diff(String sequence1, String sequence2){

        String lcs;
        int rows = sequence1.length()+1;
        int cols = sequence2.length()+1;
        int table [][] = new int[rows][cols];

        /*
          This two for loops fill the fist row and the first column with ceros.
          This serves the purpose that the LCS of nothing and each string is 0.,
        */
        table[0][0] = 0;
        for(int i = 1; i<rows;i++){
            table[i][0] = 0;
        }

        for(int j = 1;j<cols;j++){
            table[0][j] = 0;
        }

        table = length(sequence1,sequence2,table);        //Actualize the table with the new filled table returned from the length method
        lcs = getSubsequence(sequence1,sequence2,rows - 1,cols - 1,table);       //Get the the LCS String returned from the getSubsequence method.
        return lcs;

    }

    /**
     * This method fills the matrix by checking every character of a subsequence with the characters of the other subsequence.
     * if they are equal then the value of the LCS in the respective row is 1 + the LCS value of the previous row and column.
     * else, the value of the biggest subsequence between upto the last character of each sequence (row-1, col-1) is taken.
     *
     * @param sequence1
     * @param sequence2
     * @param table
     * @return table
     */
    private int[][] length(String sequence1, String sequence2, int[][] table){

        for(int i = 1; i<sequence1.length()+1;i++){

            for(int j = 1;j<sequence2.length()+1;j++){

                if(sequence1.charAt(i-1) == sequence2.charAt(j-1)){

                    table[i][j] = table[i-1][j-1]+1;
                    //System.out.print(table[i][j]);             Used along with the println in the following else statement to print the entire matrix
                }else{
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                    //System.out.print(Math.max(table[i-1][j],table[i][j-1]));        Used along with the println in the previous if statement to print the entire matrix
                }

            }
            System.out.println();

        }

        return table;

    }

    /**
     * This method takes the table filled by length and traces the increase in the total LCS
     * by cheking when the accumulated LCS value of the las two character of each sequence is the same
     * meaning that if the value of the upper left diagonal has incremented, then the caracter that is being evaluated, makes part of the LCS.
     *
     * @param sequence1
     * @param sequence2
     * @param row_iterator
     * @param col_iterator
     * @param table
     * @return response
     */
    private String getSubsequence(String sequence1, String sequence2,int row_iterator,int col_iterator, int table[][]){

        String response = "";

        if(row_iterator == 0 || col_iterator == 0){

            return response;

        }else{

            int left = table[row_iterator][col_iterator - 1];
            int up = table[row_iterator - 1][col_iterator];
            int indx = table[row_iterator][col_iterator];

            if(left == up &&  indx>left){

                response = sequence1.charAt(row_iterator - 1) + response;
                row_iterator--;
                col_iterator--;

            }else{

                if(up>left && left<indx){

                    row_iterator--;

                }else {

                    col_iterator--;

                }
            }
        }

        response = getSubsequence(sequence1, sequence2, row_iterator, col_iterator, table) + response;
        return response;

    }

}
