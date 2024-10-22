package Actividades;

public class Main {
    public static void main(String[] args) {
        // Inicialización del modelo, vista y controlador
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);

        // Iniciar el controlador
        controlador.iniciar();
    }
}