/ **
 * Este programa nos da el número de tablas válidas para una tabla nxn específica que puede tener posiciones no válidas.
 * Esta clase tiene un método de lectura que lee el tamaño y los cuadrados no válidos de la tabla.
 * También tiene el método Backtrack utilizado para determinar si una tabla es válida o no, y devuelve el número de tablas válidas.
 *
* @autor (pedro quintero )
* @version (24/02/2019)
 * /

import  java.io.File ;
importar  java.io.FileNotFoundException ;
import  java.util.Scanner ;

 clase  pública nQueens {

     tabla int [] privada ;
     int privado [] no válido;

    Public  void  Read ( String  path ) {

        Lector de cuerdas ;
        int cont =  0 ;

        prueba {

            Scanner sca =  new  Scanner ( nuevo  archivo (ruta));

            while (sca . hasNextLine ()) {

                lector = sca . línea siguiente();
                if ( ! reader . es igual a ( " " ) &&  ! reader . es igual a ( " 0 " )) {

                    prueba {

                        int queens =  Integer . parseInt (lector);

                        si (cont ! = 0 ) {
                            posibilidades de int = Retroceso (tabla, no válido, 1 , 0 );
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
                                    inválido [i] = cont;
                                }

                            }

                        }

                    }

                } else {

                }

            }

        } catch ( exención de FileNotFoundException ) {

        }

    }


    private  int  Backtrack ( int [] table , int [] invalid , int  row , int  column ) {

        int cont =  0 ;

        if (column == table . length) {

            devuelve  1 ;

        } else {

            while (fila <= tabla . longitud) {

                if (inválida [columna] == fila) {

                    si (fila + 1 <= tabla . longitud) {
                        fila ++ ;
                    } else {
                        volver cont;
                    }

                } else {

                    tabla [columna] = fila;

                    if (isValid (tabla, columna)) {

                        cont + = Retroceder (tabla, inválida, 1 , columna +  1 );

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

                if ((pantalla [i] == pantalla [n]) || ( Matemáticas . abs (pantalla [i] - pantalla [n]) ==  Matemáticas . abs (i - n))) {

                    isValid =  false ;
                    romper ;

                }

            }

            el retorno es Valido;
        }
    }

}