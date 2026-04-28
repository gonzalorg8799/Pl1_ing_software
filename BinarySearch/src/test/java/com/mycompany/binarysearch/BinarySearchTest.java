/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.binarysearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void testArrayVacio() {
        // Camino 1: No entra al bucle while (left > right inicial)
        int[] A = {};
        assertEquals(-1, BinarySearch.binarySearch(A, 5));
    }

    @Test
    public void testEncuentraCentro() {
        // Camino 2: Entra al while y cumple el primer if (x == A[mid])
        int[] A = {1, 3, 5};
        assertEquals(1, BinarySearch.binarySearch(A, 3));
    }

    @Test
    public void testBuscaIzquierda() {
        // Camino 3: Entra al while y cumple el else if (x < A[mid])
        int[] A = {1, 3, 5};
        assertEquals(0, BinarySearch.binarySearch(A, 1));
    }

    @Test
    public void testBuscaDerecha() {
        // Camino 4: Entra al while y cae en el else (x > A[mid])
        int[] A = {1, 3, 5};
        assertEquals(2, BinarySearch.binarySearch(A, 5));
    }
}