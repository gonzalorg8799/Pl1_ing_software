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

    public int evaluarCliente(double saldo, int antiguedadMeses, int numCuentas) {
        if (saldo < 0 || antiguedadMeses < 0 || numCuentas < 0) {
            return -1;
        }

        if (saldo >= 10000 && antiguedadMeses >= 24 && numCuentas >= 2) {
            return 3;
        } else if (saldo >= 5000 && antiguedadMeses >= 12 && numCuentas >= 1) {
            return 2;
        } else if (saldo >= 1000 || antiguedadMeses >= 6) {
            return 1;
        } else {
            return 0;
        }
    }
}
