package org.iesvdm;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestUtilesArrays {
    @Test 
    public void limpiar() {
        int[] vacio = UtilesArrays.limpiar();
        assertThat(vacio).isEmpty();
    }

    @Test
    public void rellenarceros() {
        int[] ceros = UtilesArrays.rellenar(new int[5], 0);

        for (int i = 0; i < ceros.length; i++) {
            if (ceros[i] != 0) {
                fail("Indice " + i + " no es 0 es: " + ceros[i]);
            }
        }
    }

    @Test
    public void rellenar2ahoramasquenunca() {
        int[] prueba = UtilesArrays.rellenar(new int[12], 13);

        for (int i = 0; i < prueba.length; i++) {
            if (prueba[i] != 7) {
                fail("Indice " + i + " no es 0 es: " + prueba[i]);
            }
        }
    }

    @Test
    public void alfinal() {
        int nuovo = 13;
        int[] array = {6, 9, 6, 9, 6, 9};
        int[] array2 = UtilesArrays.insertarAlFinal(array, nuovo);

        assertThat(array2).hasSize(7);
        for (int i = 0; i < array.length; i++) {
            assertThat(array2[i]).isEqualTo(array[i]);
        }
        assertThat(array2[array2.length - 1]).isEqualTo(nuovo);
    }

    @Test
    public void principio() {
        int nuovo = 18;
        int[] array = {14, 19, 20, 11, 13};
        int[] array2 = UtilesArrays.insertarAlPrincipio(array, nuovo);

        assertThat(array2).hasSize(6);
        assertThat(array2[0]).isEqualTo(nuovo);
        for (int i = 1; i < array2.length; i++) {
            assertThat(array2[i]).isEqualTo(array[i - 1]);
        }
    }

    @Test
    public void enposicion() {
        int posicion = 2;
        int nuovo = 18;
        int[] array = {14, 19, 20, 11, 13};
        int[] array2 = UtilesArrays.insertarEnPosicion(array, nuovo, posicion);

        assertThat(array2).hasSize(6);
        for (int i = 0; i < posicion; i++) {
            assertThat(array2[i]).isEqualTo(array[i]);
        }
        assertThat(array2[posicion]).isEqualTo(nuovo);
        for (int i = posicion + 1; i < array2.length; i++) {
            assertThat(array2[i]).isEqualTo(array[i - 1]);
        }
    }

    @Test
    public void ordenadation() {
        int nuovo = 18;
        int[] array = {14, 19, 20, 11, 13};
        int[] array2 = UtilesArrays.insertarAlPrincipio(array, nuovo);

        assertThat(array2).hasSize(6);
        assertThat(array2).isSorted();
    }

    @Test
    public void deletelast() {
        int[] array = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3};

        int[] arraysinultimo = UtilesArrays.eliminarUltimo(array);
        assertThat(arraysinultimo).isEqualTo(array2);
    }


    @Test
    public void deletefirst() {
        int[] array = {1, 2, 3, 4};
        int[] array2 = {2, 3, 4};
        int[] array3 = UtilesArrays.eliminarPrimero(array);

        assertThat(array3).isEqualTo(array2);
    }

    @Test
    public void deleteselect() {
        int posicion = 2;
        int[] array = {6, 9, 8, 10};
        int[] array2 = {6, 9, 10};
        int[] array3 = UtilesArrays.eliminarPosicion(array, posicion);

        assertThat(array3).hasSize(3);
        assertThat(array3).isEqualTo(array2);
    }

    @Test
    public void delete() {
        int elemento = 42;
        int[] array = {23, 42, 98, 12, 42, 22};
        int[] array2 = {1, 2, 4, 2};
        int[] array3 = UtilesArrays.eliminar(array, elemento);

        assertThat(array3).hasSize(array2.length);
        assertThat(array3).containsExactlyInAnyOrder(array2);
    }

    @Test
    public void sort() {
        int[] array = {5, 1, 4, 3, 2};
        int[] sorted = UtilesArrays.ordenar(array);

        assertThat(sorted).isSorted();
    }

    @Test
    public void rumble() {
        int[] sorted = {1, 2, 3, 4, 5};
        UtilesArrays.desordenar(sorted);

        assertThat(sorted).isNotEqualTo(UtilesArrays.ordenar(sorted));
    }

    @Test
    public void invertir() {
        int[] array = {3, 4, 5, 6, 7};
        int[] array2 = {7, 6, 5, 4, 3};
        int[] array3 = UtilesArrays.invertir(array);

        assertThat(array3).isEqualTo(array2);
    }

    @Test
    public void isSorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {5, 1, 4, 3, 2};

        assertThat(UtilesArrays.estaOrdenado(array)).isTrue();
        assertThat(UtilesArrays.estaOrdenado(array2)).isFalse();
    }

    @Test
    public void buscar() {
        int elemento = 5;
        int[] array = {3, 4, 5, 6, 1, 2};
        int posicion = UtilesArrays.buscar(array, elemento);
        assertThat(posicion).isEqualTo(2);
    }
    @Test
    public void buscarno() {
        int elemento = 6;
        int[] array = {2, 3, 1, 4, 7};
        int posicion = UtilesArrays.buscar(array, elemento);
        assertThat(posicion).isEqualTo(-1);
    }
    @Test
    public void cortar() {
        int[] array = {1, 2, 3, 4, 5};
        int inicio = 2;
        int fin = 4;
        int[] cortado = UtilesArrays.partirPor(array, inicio, fin);
        assertThat(cortado).hasSize(2);
        assertThat(cortado).containsExactly(3, 4);
    }
    @Test
    public void cortaroutofindex() {
        int[] array = {2, 4, 5, 9, 8, 1};
        int inicio = 2;
        int corte = 32;
        int[] array2 = UtilesArrays.partirPor(array, inicio, corte);
        assertThat(array2).hasSize(0);
    }
    @Test
    public void equals() {
        int[] array1 = {2, 3, 4};
        int[] array2 = {1, 9, 8};
        int[] array3 = {2, 3, 4};

        assertThat(UtilesArrays.sonIguales(array1, array2)).isTrue();
        assertThat(UtilesArrays.sonIguales(array1, array3)).isFalse();
    }

    @Test
    public void concat() {
        int[] array1 = {2, 3, 4, 1};
        int[] array2 = {4, 2, 1, 2};

        int[] arrayConcatenado = UtilesArrays.concatenarArrays(array1, array2);
        assertThat(arrayConcatenado).hasSize(8);
        assertThat(arrayConcatenado).containsSequence(2, 3, 4, 1, 4, 2, 1, 2);
    }
}