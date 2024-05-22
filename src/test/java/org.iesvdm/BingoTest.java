package org.iesvdm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BingoTest {

    @Test
    void test1() {

        assertThat(1 == 1).isTrue();


    }

    @Test
    void ponerBlancos() {
        //When

        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];


        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

        //for(int[]col:carton)
        // System.out.println(Arrays.toString(col));

        //DO
        Bingo.ponerBlancos(carton);


        for (int j = 0; j < carton[0].length; j++) {
            for (int i = 0; i < carton.length; i++) {
                System.out.printf((carton[i][j] == 0 ? " 0" : carton[i][j]) + " ");
            }
            System.out.println("");
        }

        int contTotal = 0;
        for (int[] col : carton) {
            int contBlancas = 0;
            for (int celda : col) {
                if (celda == -1) {
                    contBlancas++;
                    contTotal++;
                }
            }
            assertThat(contBlancas).isLessThan(3);

        }
        assertThat(contTotal).isEqualTo(12);


        //Then
        for (int j = 0; j < carton[0].length; j++) {
            int contFilas = 0;
            for (int i = 0; i < carton.length; i++) {
                if (carton[i][j] == -1) {
                    contFilas++;
                }
            }
            assertThat(contFilas).isEqualTo(4);
        }
//

    }

    @Test
    void buscarFila(){ //SALE TRUE

        //DO
        int[][] arrayBi = {{1, 2, 3}, {4, 5, 6}, {7, 8, -1}};
        int fila = 6;
        int posicion = 6;

    }

    @Test
    void buscarFila2(){ //SALE FALSE

        //DO
        int[][] arrayBi = {};
        int fila = 0;
        int posicion = 0;
    }



    @Test
    void buscarColumna(){

        int[][] arrayBi = {{1, 2, 3}, {4, -1, 6}, {7, 8, -1}};
        int posicionAleatoria = 1;



    }


}
