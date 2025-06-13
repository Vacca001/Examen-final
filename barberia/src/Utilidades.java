import java.util.Scanner;

public class Utilidades {
    
    // Método para leer texto genérico
    public static String leerTexto(String mensaje, Scanner sc) {
        System.out.print(mensaje);
        return sc.nextLine().trim(); // .trim() elimina espacios en blanco al inicio/final
    }

    // Método para leer enteros con validación
    public static int leerEntero(String mensaje, Scanner sc) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }
    }

    // Método para leer fechas con validación de formato Y valores reales (dd/mm/aaaa)
    public static String leerFecha(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String fecha = sc.nextLine();
            
            if (fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
                String[] partes = fecha.split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int año = Integer.parseInt(partes[2]);
                
                // Validación de valores reales
                if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && año >= 2023) {
                    return fecha;
                }
            }
            System.out.println("Error: Formato inválido o fecha no válida. Use dd/mm/aaaa (ej: 15/06/2024).");
        }
    }

    // Método para leer horas con validación de formato Y valores reales (hh:mm)
    public static String leerHora(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String hora = sc.nextLine();
            
            if (hora.matches("\\d{2}:\\d{2}")) {
                String[] partes = hora.split(":");
                int horas = Integer.parseInt(partes[0]);
                int minutos = Integer.parseInt(partes[1]);
                
                // Validación de valores reales
                if (horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59) {
                    return hora;
                }
            }
            System.out.println("Error: Formato inválido o hora no válida. Use hh:mm (ej: 14:30).");
        }
    }

    // Método opcional para leer números decimales (útil si agregas precios)
    public static double leerDecimal(String mensaje, Scanner sc) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido (ej: 15000 o 15000.50).");
            }
        }
    }
}