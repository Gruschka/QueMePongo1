package com.company;

import java.util.*;

public class Gestor {

    //Tanto la lista de prendas como el map de categorias serian persistidos y el programa
    //levantaria su ultimo estado al iniciarse
    static List<Prenda> prendas = new ArrayList<>();
    static List<Atuendo> atuendos = new ArrayList<>();
    //categoryMap junta los pares de prenda-categoria que son validos.
    // Asumo que inicialmente ya tiene cargados los pares validos.
    static Map<CategoriaDePrenda, CategoriaDePrenda> categoryMap = new HashMap<CategoriaDePrenda, CategoriaDePrenda>();

    public static void cargarNuevaPrenda(){

        try {

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object

            System.out.println("Ingrese tipo de prenda");
            String input =  scanner.nextLine();
            TipoDePrenda type = TipoDePrenda.valueOf(input);  // Read user input
            validarIngreso(input, type.name());

            System.out.println("Ingrese categoria de prenda");
            input =  scanner.nextLine();
            CategoriaDePrenda category = CategoriaDePrenda.valueOf(scanner.nextLine());  // Read user input
            validarIngreso(input, category.name());

            validarCategoria(type, category);

            System.out.println("Ingrese material de prenda");
            input =  scanner.nextLine();
            MaterialDePrenda material = MaterialDePrenda.valueOf(scanner.nextLine());  // Read user input
            validarIngreso(input, material.name());

            System.out.println("Ingrese color principal");
            input =  scanner.nextLine();
            Color colorPrimario = Color.valueOf(scanner.nextLine());  // Read user input
            validarIngreso(input, colorPrimario.name());

            System.out.println("Quiere ingresar color secundario? y/n");
            String option = scanner.nextLine();

            Prenda nuevaPrenda;

            if ((option.equals("y"))) {
                System.out.println("Ingrese color principal");
                Color colorSecundario = Color.valueOf(scanner.nextLine());  // Read user input
                nuevaPrenda = new Prenda(type, category, material, colorPrimario, colorSecundario);
                prendas.add(nuevaPrenda);
            }else{
                nuevaPrenda = new Prenda(type, category, material, colorPrimario);
                prendas.add(nuevaPrenda);
            }

        } catch (PrendaSinDatoException e) {
            System.out.println("No ha ingresado un dato valido:" + e.getDato());
            e.printStackTrace();
        } catch(IllegalArgumentException e){
            System.out.println("No ingresaste un dato valido");
        }catch(CategoriaIncorrectaException e){
            System.out.println("El tipo" + e.getTipoDePrenda() + "no es valido para la categoria" + e.getCategoriaDePrenda());
        }

    }


    public static void validarIngreso(String input, String inputType) throws PrendaSinDatoException {
        if(input == null) throw new PrendaSinDatoException(input, inputType);
    }

    public static void validarCategoria(TipoDePrenda tipo, CategoriaDePrenda categoria) throws CategoriaIncorrectaException {
        if (categoryMap.get(tipo) == null) { //Si el par tipo - categoria no esta en el mapa de tipos
            throw new CategoriaIncorrectaException(tipo, categoria);
        }
    }



    public static void generarAtuendo(){

        //Pseudocodigo
        Scanner scanner = new Scanner(System.in);
        Atuendo nuevoAtuendo = new Atuendo();

        while (sigueIngresandoPrendas){
            System.out.println("Prendas disponibles");
            mostrarPrendas();
            int indiceDePrendaSeleccionado = scanner.nextLine();
            nuevoAtuendo.prendas.add(prendas.get(indiceDePrendaSeleccionado));
        }

        atuendos.add(nuevoAtuendo);

    }

    public static void mostrarPrendas(){

        int index = 0;
        prendas.stream().forEach(Prenda::getInfo);
    }
}
