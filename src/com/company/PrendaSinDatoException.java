package com.company;

public class PrendaSinDatoException extends Exception{

    private String dato;
    private String tipo;

    public PrendaSinDatoException(String datoIngresado, String tipoDelDato) {
        this.dato = dato;
        this.dato = tipoDelDato;
    }

    public String getDato() {
        return dato;
    }

}
