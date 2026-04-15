/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cajeroautomatico;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author grodriguez
 */
public class CajeroAutomaticoTest {

    private CajeroAutomatico CajeroBajoPrueba;
    private PasarelaPago mock;

    @Test
    public void testRealizarRetirada1() {
        System.out.println("Caso 1: pasarela no bloqueada y cuenta con saldo");

        /* (1) Se crea el objeto de la clase a probar y un mock para simular la
 clase PasarelaPago
         */
        CajeroBajoPrueba = new CajeroAutomatico("1111111111");
        CajeroBajoPrueba.iniciarSesion("1234");
        mock = createMock(PasarelaPago.class);
        /* (2) En estado de "grabación", se le dice al objeto Simulado las
 llamadas que debe esperar y cómo responder a ellas.
         */
        expect(mock.estaBloqueada()).andReturn(false);
        expect(mock.tieneSaldo(500)).andReturn(true);
        mock.retirar(500);
        /* (3) Ahora, el objeto simulado comienza a esperar las llamadas
         */
        replay(mock);
        /* (4) Se programa la prueba del objeto de la clase a probar
         */
        boolean result = CajeroBajoPrueba.realizarRetirada(500, mock);
        assertTrue(result);
        /* (5) Forzamos a que la ausencia de todas las llamadas previstas sea
 también un error
         */
        verify(mock);
        /* (6) Se ejecutan instrucciones necesarias de finalización de la prueba
 y se resetea el mock
         */
        CajeroBajoPrueba.cerrarSesion();
        reset(mock);
    }
}
