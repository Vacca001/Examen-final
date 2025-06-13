public class Barbero extends Persona {
    private final String especialidad;

    public Barbero(String nombre, String cedula, String especialidad) {
        super(nombre, cedula);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Barbero: " + getNombre() + " - Especialidad: " + especialidad; // Usa getNombre()
    }
}