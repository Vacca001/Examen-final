public class Cita {
    private Cliente cliente;
    private Barbero barbero;
    private Servicio servicio;
    private String fecha;
    private String hora;

    public Cita(Cliente cliente, Barbero barbero, Servicio servicio, String fecha, String hora) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    @Override 
    public String toString() {
        return String.format(
            "Cita:\n- Cliente: %s\n- Barbero: %s (%s)\n- Servicio: %s\n- Fecha y Hora: %s a las %s",
            cliente.getNombre(),
            barbero.getNombre(),
            barbero.getEspecialidad(),
            servicio,
            fecha,
            hora
        );
    }
}