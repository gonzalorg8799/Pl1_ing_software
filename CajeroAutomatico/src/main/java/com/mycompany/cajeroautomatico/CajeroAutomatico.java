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
        if (p.estaBloqueada()) { //Si está bloqueada nada
            return false;
        }
        if (p.tieneSaldo(cantidad)) { //Si está activa y tiene saldo
            p.retirar(cantidad); //llamo al método retirar dinero
            return true;
        }
        return false;
    }
}
