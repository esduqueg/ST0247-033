public class Corrector {

    public int corregir(String word1, String word2){

        int levehstein [][] = new int [word1.length()+1][word2.length()+1];
        levehstein[0][0] = 0;

        for(int i = 1; i < word1.length(); i++){
            levehstein[i][0] = i;
        }

        for(int i = 1; i < word2.length(); i++){
            levehstein[0][i] = i;
        }

        assistant(word1,word2,levehstein,1,1);
        return levehstein[word1.length()][word2.length()];


    }

    private int[][] assistant (String word1, String word2, int lev [][], int col, int row){

        //System.out.println(word2.charAt(col-1));
        if(word1.charAt(row-1) == word2.charAt(col-1)){
            lev[row][col] = Math.min(Math.min(lev[row-1][col],lev[row-1][col-1]),lev[row][col-1]);
        }else if(col == 1){
            lev[row][col] = lev[row][col-1];
        }else{
            lev[row][col] = lev[row][col-1]+1;
        }

        if(col==word2.length() && row==word1.length()){

        }else if (col==word2.length() && row+1!= word1.length()+1){
            row++;
            col = 1;
            assistant(word1,word2,lev,col,row);
        }else{
            col++;
            assistant(word1,word2,lev,col,row);
        }

        return lev;
    }

}
