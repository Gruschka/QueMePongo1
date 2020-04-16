package com.company;

public class CategoriaIncorrectaException  extends Exception {

    private TipoDePrenda tipoDePrenda;
    private CategoriaDePrenda categoriaDePrenda;

    public CategoriaIncorrectaException(TipoDePrenda tipoDePrenda, CategoriaDePrenda categoriaDePrenda) {
        this.tipoDePrenda = tipoDePrenda;
        this.categoriaDePrenda = categoriaDePrenda;
    }

    public String getTipoDePrenda() {
        return tipoDePrenda.name();
    }

    public String getCategoriaDePrenda() {
        return categoriaDePrenda.name();
    }

}
