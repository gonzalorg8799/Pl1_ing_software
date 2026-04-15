/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeroautomatico;

/**
 *
 * @author grodriguez
 */
public interface PasarelaPago {
    /**
* Comprueba si la cuenta tiene saldo suficiente para la retirada
Ing. Software – GISI 2025-26 Fco. Javier Bueno
Universidad de Alcalá 4
*/
public boolean tieneSaldo(double cantidad);
/**
* Una cuenta se bloquea si se ha intentado realizar una retirada de dinero
* sin saldo suficiente de manera previa.
*/
public boolean estaBloqueada();
/**
* Retira dinero de la cuenta.
* Precondición: la cuenta debe tener saldo suficiente.
*/
public void retirar(double cantidad);
}
