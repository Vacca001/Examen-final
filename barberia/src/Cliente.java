public class Cliente extends Persona {
    private int idCliente;

    public Cliente(String nombre, String cedula, int idCliente) {
        super(nombre, cedula);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    
    @Override
    public String toString() {
        return "Cliente: " + getNombre() + " - ID: " + idCliente; 
    }
}