/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cajeroautomatico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author grodriguez
 */
public class CajeroAutomaticoTest {
    
    public CajeroAutomaticoTest() {
    }

    /**
     * Test of iniciarSesion method, of class CajeroAutomatico.
     */
    @Test
    public void testIniciarSesion() {
        System.out.println("iniciarSesion");
        String ccc = "";
        CajeroAutomatico instance = null;
        instance.iniciarSesion(ccc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarSesion method, of class CajeroAutomatico.
     */
    @Test
    public void testCerrarSesion() {
        System.out.println("cerrarSesion");
        CajeroAutomatico instance = null;
        instance.cerrarSesion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarRetirada method, of class CajeroAutomatico.
     */
    @Test
    public void testRealizarRetirada() {
        System.out.println("realizarRetirada");
        double cantidad = 0.0;
        PasarelaPago p = null;
        CajeroAutomatico instance = null;
        boolean expResult = false;
        boolean result = instance.realizarRetirada(cantidad, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
