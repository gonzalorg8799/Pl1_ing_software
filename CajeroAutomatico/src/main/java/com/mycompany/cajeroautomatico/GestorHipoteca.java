package com.mycompany.cajeroautomatico;

/**
 * Simula el gestor que valora solicitudes de prestamos hipotecarios.
 */
public interface GestorHipoteca {

    /**
     * Comprueba si la cantidad solicitada esta dentro del limite permitido.
     */
    public boolean comprobarCantidad(double cantidad);

    /**
     * Comprueba si el plazo solicitado esta dentro del limite permitido.
     */
    public boolean comprobarPlazo(int plazo);

    /**
     * Comprueba si la edad del solicitante esta dentro del limite permitido.
     */
    public boolean comprobarEdad(int edad);

    /**
     * Abre la hipoteca cuando todas las condiciones se han validado.
     */
    public void abrirHipoteca(double cantidad, int plazo);
}
