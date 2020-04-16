package com.company;

public class Prenda {

    TipoDePrenda tipo;
    CategoriaDePrenda categoria;
    MaterialDePrenda material;
    Color colorPrincipal;
    Color colorSecundario;

    //Si tiene solo color principal
    Prenda(TipoDePrenda tipo, CategoriaDePrenda categoria, MaterialDePrenda material, Color principal ){
        this.tipo = tipo;
        this.categoria = categoria;
        this.material = material;
        this.colorPrincipal = principal;
    }

    //Si tiene solo color secundario
    Prenda(TipoDePrenda tipo, CategoriaDePrenda categoria, MaterialDePrenda material, Color principal, Color secundario){
        this.tipo = tipo;
        this.categoria = categoria;
        this.material = material;
        this.colorPrincipal = principal;
        this.colorSecundario = secundario;
    }

    public void getInfo(){
        System.out.println("Tipo: "+ this.tipo.toString() +
                " Categoria: " + this.categoria.toString() +
                " Material: " + this.material.toString() +
                " Color Principal: " + this.colorPrincipal.toString());
    }
}
