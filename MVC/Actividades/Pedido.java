package Actividades;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado; // Atributo para manejar el estado del pedido

    // Constructor que inicializa el nombre, tipo y estado del pedido
    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "pendiente"; // Todos los pedidos comienzan como "pendientes"
    }

    // Getter para obtener el nombre del plato
    public String getNombrePlato() {
        return nombrePlato;
    }

    // Setter para actualizar el nombre del plato
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    // Getter para obtener el tipo del plato
    public String getTipoPlato() {
        return tipoPlato;
    }

    // Setter para actualizar el tipo del plato
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    // Getter para obtener el estado del pedido
    public String getEstado() {
        return estado;
    }

    // Método para marcar el pedido como completado
    public void completar() {
        this.estado = "completado";
    }

    // Método para marcar el pedido como eliminado
    public void eliminar() {
        this.estado = "eliminado";
    }

    // Método para verificar si el pedido está pendiente
    public boolean esPendiente() {
        return estado.equals("pendiente");
    }
}