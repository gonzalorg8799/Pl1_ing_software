/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cajeroautomatico;

/**
 *
 * @author grodriguez
 */

public class CajeroAutomatico {

    private String _codigo = null;
    /**
     * La cuenta corriente sobre la que se opera en una sesión.
     */
    private String _cuenta;

    public CajeroAutomatico(String codigo) {
        _codigo = codigo;
    }

    public void iniciarSesion(String ccc) {
        assert (_cuenta == null);
        _cuenta = ccc; //cuenta del cliente
    }

    public void cerrarSesion() {
        assert (_cuenta != null);
        _cuenta = null; //pone a null la cuenta
    }

    public boolean realizarRetirada(double cantidad, PasarelaPago p) {
        assert (_cuenta != null);
        if (p.estaBloqueada()) {
            return false;
        }
        if (p.tieneSaldo(cantidad)) {
            p.retirar(cantidad);
            return true;
        }
        return false;
    }

    public boolean evaluarCliente(double cantidad, int plazo, int edad, GestorHipoteca gestor) {
        assert (_cuenta != null);
        if (!gestor.comprobarCantidad(cantidad)) {
            return false;
        }
        if (!gestor.comprobarPlazo(plazo)) {
            return false;
        }
        if (!gestor.comprobarEdad(edad)) {
            return false;
        }
        gestor.abrirHipoteca(cantidad, plazo);
        return true;
    }
}
