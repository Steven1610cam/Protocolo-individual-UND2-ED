package edu.unicartagena.BusquedaOrdenamiento.Proyecto;

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
    }

}

