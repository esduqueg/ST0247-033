public class Backtraking {

    /*
         This method finds if the given screen has an answer or not using recursion.
         It has a row parameter that is used to track the file were a queens is or were it is going to be inserted.

    */

    private int[] standardAux(int screen[], int row, int col){


        if(col == screen.length){

            return screen;


        }else{

            screen[col] = row;


            if(isValid(screen,col)){

                col++;
                standardAux(screen,1,col);

            }else{

                if(row==screen.length){

                    if(screen[col-1]==screen.length && col-2>=0) {

                        col -= 2;

                    }else if(screen[col-1]==screen.length && col-2<0){

                        screen = noSolution(screen);

                        return screen;

                    }else{

                        col--;

                    }

                    standardAux(screen,screen[col]+1,col);

                }else {

                    standardAux(screen, row+1, col);

                }

            }

            return screen;

        }



    }

    private int[] noSolution(int[] arr){

        for(int i = 0; i<arr.length; i++){

            arr[i]=0;

        }

        return arr;

    }

    private boolean isValid(int[] screen, int n){

        if(n == 0){
            return true;
        }
        else{

            boolean isValid = true;

            for(int i = 0; i<n; i++){

                if((screen[i]==screen[n]) || (Math.abs(screen[i]-screen[n])== Math.abs(i-n)) ){

                    isValid = false;
                    break;

                }

            }

            return isValid;
        }

    }

    public int[] standar(int numQueens){

        int[] screen = new int[numQueens];

        return standardAux(screen,1,0);

    }


}
