package com.mycompany.cajeroautomatico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.EasyMock;

@ExtendWith(EasyMockExtension.class)
public class CajeroAutomaticoTest {

    private CajeroAutomatico cajero;

    @Mock
    private PasarelaPago mockPasarela;

    @BeforeEach
    public void setUp() {
        cajero = new CajeroAutomatico("1234");
        mockPasarela = EasyMock.createMock(PasarelaPago.class);
    }

    @Test
    public void testEvaluarCliente_CasosLimiteValidos() {
        assertEquals(3, cajero.evaluarCliente(10000, 24, 2));
        assertEquals(2, cajero.evaluarCliente(5000, 12, 1));
        assertEquals(1, cajero.evaluarCliente(1000, 6, 0));
        assertEquals(0, cajero.evaluarCliente(500, 3, 1));
    }

    @Test
    public void testEvaluarCliente_CasosNoValidos() {
        assertEquals(-1, cajero.evaluarCliente(-1, 10, 1));
        assertEquals(-1, cajero.evaluarCliente(1000, -1, 1));
        assertEquals(-1, cajero.evaluarCliente(1000, 10, -1));
    }

    @Test
    public void testEvaluarCliente_FronterasSuperiores() {
        assertEquals(2, cajero.evaluarCliente(9999.99, 23, 1));
        assertEquals(1, cajero.evaluarCliente(4999.99, 11, 0));
        assertEquals(0, cajero.evaluarCliente(999.99, 5, 0));
    }

    @Test
    public void testEvaluarCliente_FronterasInferiores() {
        assertEquals(2, cajero.evaluarCliente(10000, 12, 1));
        assertEquals(1, cajero.evaluarCliente(5000, 6, 0));
        assertEquals(0, cajero.evaluarCliente(999, 5, 0));
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
    public void testRealizarRetirada_CuentaBloqueada() {
        cajero.iniciarSesion("ES1234567890");
        
        EasyMock.expect(mockPasarela.estaBloqueada()).andReturn(true);
        EasyMock.replay(mockPasarela);
        
        boolean resultado = cajero.realizarRetirada(100.0, mockPasarela);
        
        assertFalse(resultado);
        EasyMock.verify(mockPasarela);
    }
}