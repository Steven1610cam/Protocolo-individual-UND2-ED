package edu.unicartagena.BusquedaOrdenamiento.Proyecto;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author STEVEN AF
 */
public class SimuladorDeVentas2 {
    public static void ejecutar() {
        System.out.println("\n--- Proyecto: Simulador de Ventas 2.0 ---");
        
        
        // Productos
        String productos[] = {"Bollo", "Suero", "Queso", "Yuca", "Chicha"};
        double precios[] = {1000, 2500, 25000, 2500, 1500};
        int cantidades[] = {10, 5, 2, 5, 12};
        
               
        // Total por producto
        double totales[] = new double[productos.length];
        for (int i = 0; i < productos.length; i++) {
            totales[i] = precios[i] * cantidades[i];
        }
        
        // Visualizar tabla de ventas
        System.out.printf("%-10s %10s %10s %10s%n", "Producto", "Precio", "Cantidad", "Total");
            for (int i = 0; i < productos.length; i++) {
            System.out.printf("%-10s %10.1f %10d %10.1f%n",
                      productos[i], precios[i], cantidades[i], totales[i]);
        }


        
        // Total general
        double totalGeneral = 0;
        for (double total : totales) {
            totalGeneral += total;
        }
        
        System.out.println("\nTotal general de ventas: " + totalGeneral);
        
        
        // Producto más vendido
        int maxIndex = 0;
        for (int i = 1; i < cantidades.length; i++) {
            if (cantidades[i] > cantidades[maxIndex]) {
                maxIndex = i;
            }
        }
        
        System.out.println("El producto más vendido fue: " + productos[maxIndex] +
                           " con " + cantidades[maxIndex] + " unidades.");
        
        //Busqueda 
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de un producto para buscar (lineal): ");
        String buscado = sc.nextLine();
        busquedaLineal(productos, buscado);

        System.out.print("\nIngrese el nombre de un producto para buscar (binaria): ");
        String buscado2 = sc.nextLine();
        busquedaBinaria(productos, buscado2);
    }

    // Búsqueda lineal
    public static void busquedaLineal(String[] productos, String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].equalsIgnoreCase(nombre)) {
                System.out.println("[LINEAL] Producto encontrado: " + productos[i] +
                        " en la posición " + i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("[LINEAL] Producto no encontrado.");
        }
    }

    // Búsqueda binaria
    public static void busquedaBinaria(String[] productos, String nombre) {
        Arrays.sort(productos); // ordenar antes
        int index = Arrays.binarySearch(productos, nombre);
        if (index >= 0) {
            System.out.println("[BINARIA] Producto encontrado: " + productos[index] +
                    " en la posición " + index);
        } else {
            System.out.println("[BINARIA] Producto no encontrado.");
        }   
    }

}

