package com.mycompany.cajeroautomatico;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajeroAutomaticoTest {

    private CajeroAutomatico cajero;
    private PasarelaPago mockPasarela;
    private GestorHipoteca mockHipoteca;

    @BeforeEach
    public void setUp() {
        cajero = new CajeroAutomatico("1234");
        mockPasarela = EasyMock.createMock(PasarelaPago.class);
        mockHipoteca = EasyMock.createMock(GestorHipoteca.class);
    }

    @Test
    public void testRealizarRetirada_SaldoSuficiente() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockPasarela.estaBloqueada()).andReturn(false);
        EasyMock.expect(mockPasarela.tieneSaldo(100.0)).andReturn(true);
        mockPasarela.retirar(100.0);
        EasyMock.replay(mockPasarela);

        boolean resultado = cajero.realizarRetirada(100.0, mockPasarela);

        assertTrue(resultado);
        EasyMock.verify(mockPasarela);
    }

    @Test
    public void testRealizarRetirada_SaldoInsuficiente() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockPasarela.estaBloqueada()).andReturn(false);
        EasyMock.expect(mockPasarela.tieneSaldo(100.0)).andReturn(false);
        EasyMock.replay(mockPasarela);

        boolean resultado = cajero.realizarRetirada(100.0, mockPasarela);

        assertFalse(resultado);
        EasyMock.verify(mockPasarela);
    }

    @Test
    public void testRealizarRetirada_CuentaBloqueadaConSaldo() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockPasarela.estaBloqueada()).andReturn(true);
        EasyMock.replay(mockPasarela);

        boolean resultado = cajero.realizarRetirada(100.0, mockPasarela);

        assertFalse(resultado);
        EasyMock.verify(mockPasarela);
    }

    @Test
    public void testRealizarRetirada_CuentaBloqueadaSinSaldo() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockPasarela.estaBloqueada()).andReturn(true);
        EasyMock.replay(mockPasarela);

        boolean resultado = cajero.realizarRetirada(100.0, mockPasarela);

        assertFalse(resultado);
        EasyMock.verify(mockPasarela);
    }

    /*
     * Casos de equivalencia para evaluarCliente:
     * Valido: cantidad <= 200000, plazo <= 20 anios, edad <= 50.
     * Invalido por cantidad: cantidad > 200000.
     * Invalido por plazo: plazo > 20 anios.
     * Invalido por edad: edad > 50.
     */
    @Test
    public void testEvaluarCliente_HipotecaValida() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockHipoteca.comprobarCantidad(200000.0)).andReturn(true);
        EasyMock.expect(mockHipoteca.comprobarPlazo(20)).andReturn(true);
        EasyMock.expect(mockHipoteca.comprobarEdad(50)).andReturn(true);
        mockHipoteca.abrirHipoteca(200000.0, 20);
        EasyMock.replay(mockHipoteca);

        boolean resultado = cajero.evaluarCliente(200000.0, 20, 50, mockHipoteca);

        assertTrue(resultado);
        EasyMock.verify(mockHipoteca);
    }

    @Test
    public void testEvaluarCliente_CantidadInvalida() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockHipoteca.comprobarCantidad(200001.0)).andReturn(false);
        EasyMock.replay(mockHipoteca);

        boolean resultado = cajero.evaluarCliente(200001.0, 20, 50, mockHipoteca);

        assertFalse(resultado);
        EasyMock.verify(mockHipoteca);
    }

    @Test
    public void testEvaluarCliente_PlazoInvalido() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockHipoteca.comprobarCantidad(150000.0)).andReturn(true);
        EasyMock.expect(mockHipoteca.comprobarPlazo(21)).andReturn(false);
        EasyMock.replay(mockHipoteca);

        boolean resultado = cajero.evaluarCliente(150000.0, 21, 50, mockHipoteca);

        assertFalse(resultado);
        EasyMock.verify(mockHipoteca);
    }

    @Test
    public void testEvaluarCliente_EdadInvalida() {
        cajero.iniciarSesion("ES1234567890");

        EasyMock.expect(mockHipoteca.comprobarCantidad(150000.0)).andReturn(true);
        EasyMock.expect(mockHipoteca.comprobarPlazo(20)).andReturn(true);
        EasyMock.expect(mockHipoteca.comprobarEdad(51)).andReturn(false);
        EasyMock.replay(mockHipoteca);

        boolean resultado = cajero.evaluarCliente(150000.0, 20, 51, mockHipoteca);

        assertFalse(resultado);
        EasyMock.verify(mockHipoteca);
    }
}
