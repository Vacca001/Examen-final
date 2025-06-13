import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Barbero> barberos = new ArrayList<>();
        ArrayList<Servicio> servicios = new ArrayList<>();
        ArrayList<Cita> citas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Datos iniciales
        barberos.add(new Barbero("Juan", "1010", "Cortes clásicos"));
        barberos.add(new Barbero("Pedro", "2020", "Barba y bigode"));
        
        servicios.add(new Servicio("Corte básico", 10000));
        servicios.add(new Servicio("Corte premium", 15000));
        servicios.add(new Servicio("Afeitado", 8000));

        int opcion;
        do {
            System.out.println("\n=== BARBERÍA EL ESTILO ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Agendar cita");
            System.out.println("3. Ver citas");
            System.out.println("0. Salir");
            opcion = Utilidades.leerEntero("Seleccione una opción: ", sc);

            switch (opcion) {
                case 1:
                    registrarCliente(clientes, sc);
                    break;

                case 2:
                    agendarCita(clientes, barberos, servicios, citas, sc);
                    break;

                case 3:
                    mostrarCitas(citas);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida!");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void registrarCliente(ArrayList<Cliente> clientes, Scanner sc) {
        String nombre = Utilidades.leerTexto("Nombre del cliente: ", sc);
        String cedula = Utilidades.leerTexto("Cédula: ", sc);
        clientes.add(new Cliente(nombre, cedula, clientes.size() + 1));
        System.out.println("Cliente registrado exitosamente!");
    }

    private static void agendarCita(ArrayList<Cliente> clientes, ArrayList<Barbero> barberos,
                                  ArrayList<Servicio> servicios, ArrayList<Cita> citas, Scanner sc) {
        if (clientes.isEmpty() || barberos.isEmpty() || servicios.isEmpty()) {
            System.out.println("Error: Debe existir al menos 1 cliente, 1 barbero y 1 servicio.");
            return;
        }

        // Selección de cliente con validación
        int clienteIdx = seleccionarElemento("cliente", clientes, sc);
        if (clienteIdx == -1) return;

        // Selección de barbero con validación
        int barberoIdx = seleccionarElemento("barbero", barberos, sc);
        if (barberoIdx == -1) return;

        // Selección de servicio con validación
        int servicioIdx = seleccionarElemento("servicio", servicios, sc);
        if (servicioIdx == -1) return;

        String fecha = Utilidades.leerFecha("Fecha (dd/mm/aaaa): ", sc);
        String hora = Utilidades.leerHora("Hora (hh:mm): ", sc);

        // Verificar si ya existe una cita para el barbero en esa fecha y hora
        if (citaExistente(citas, barberos.get(barberoIdx), fecha, hora)) {
            System.out.println("Error: El barbero ya tiene una cita agendada en esa fecha y hora.");
            return;
        }

        citas.add(new Cita(
            clientes.get(clienteIdx),
            barberos.get(barberoIdx),
            servicios.get(servicioIdx),
            fecha,
            hora
        ));
        System.out.println("\n¡Cita agendada con éxito!");
    }

    private static <T> int seleccionarElemento(String tipo, ArrayList<T> lista, Scanner sc) {
        System.out.println("\n--- Selección de " + tipo + " ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).toString());
        }

        int seleccion = Utilidades.leerEntero("Seleccione " + tipo + " (número): ", sc) - 1;
        if (seleccion < 0 || seleccion >= lista.size()) {
            System.out.println("Índice inválido.");
            return -1;
        }
        return seleccion;
    }

    private static void mostrarCitas(ArrayList<Cita> citas) {
        if (citas.isEmpty()) {
            System.out.println("No hay citas agendadas.");
        } else {
            System.out.println("\n--- CITAS AGENDADAS ---");
            for (int i = 0; i < citas.size(); i++) {
                System.out.println((i + 1) + ". " + citas.get(i));
            }
        }
    }

    private static boolean citaExistente(ArrayList<Cita> citas, Barbero barbero, String fecha, String hora) {
        for (Cita cita : citas) {
            if (cita.getBarbero().equals(barbero) && 
                cita.getFecha().equals(fecha) && 
                cita.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }
}