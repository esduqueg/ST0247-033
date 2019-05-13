/ **
 * Este programa nos da el n�mero de tablas v�lidas para una tabla nxn espec�fica que puede tener posiciones no v�lidas.
 * Esta clase tiene un m�todo de lectura que lee el tama�o y los cuadrados no v�lidos de la tabla.
 * Tambi�n tiene el m�todo Backtrack utilizado para determinar si una tabla es v�lida o no, y devuelve el n�mero de tablas v�lidas.
 *
* @autor (pedro quintero )
* @version (24/02/2019)
 * /

import  java.io.File ;
importar  java.io.FileNotFoundException ;
import  java.util.Scanner ;

 clase  p�blica nQueens {

     tabla int [] privada ;
     int privado [] no v�lido;

    Public  void  Read ( String  path ) {

        Lector de cuerdas ;
        int cont =  0 ;

        prueba {

            Scanner sca =  new  Scanner ( nuevo  archivo (ruta));

            while (sca . hasNextLine ()) {

                lector = sca . l�nea siguiente();
                if ( ! reader . es igual a ( " " ) &&  ! reader . es igual a ( " 0 " )) {

                    prueba {

                        int queens =  Integer . parseInt (lector);

                        si (cont ! = 0 ) {
                            posibilidades de int = Retroceso (tabla, no v�lido, 1 , 0 );
                            Sistema . a cabo . println (posibilidades);
                        }
                        table =  new  int [queens];
                        invalid =  new  int [queens];
                        cont =  0 ;

                    } catch ( NumberFormatException e) {

                        cont ++ ;

                        si (lector . contiene ( " * " )) {

                            para ( int i =  0 ; i < reader . length (); i ++ ) {

                                if (reader . charAt (i) ==  ' * ' ) {
                                    inv�lido [i] = cont;
                                }

                            }

                        }

                    }

                } else {

                }

            }

        } catch ( exenci�n de FileNotFoundException ) {

        }

    }


    private  int  Backtrack ( int [] table , int [] invalid , int  row , int  column ) {

        int cont =  0 ;

        if (column == table . length) {

            devuelve  1 ;

        } else {

            while (fila <= tabla . longitud) {

                if (inv�lida [columna] == fila) {

                    si (fila + 1 <= tabla . longitud) {
                        fila ++ ;
                    } else {
                        volver cont;
                    }

                } else {

                    tabla [columna] = fila;

                    if (isValid (tabla, columna)) {

                        cont + = Retroceder (tabla, inv�lida, 1 , columna +  1 );

                    }
                }

                fila ++ ;
            }

        }

        volver cont;

    }

    privado  booleano  isValid ( int [] screen , int  n ) {

        si (n ==  0 ) {
            volver  verdadera ;
        } else {

            boolean isValid =  true ;

            para ( int i =  0 ; i < n; i ++ ) {

                if ((pantalla [i] == pantalla [n]) || ( Matem�ticas . abs (pantalla [i] - pantalla [n]) ==  Matem�ticas . abs (i - n))) {

                    isValid =  false ;
                    romper ;

                }

            }

            el retorno es Valido;
        }
    }

}