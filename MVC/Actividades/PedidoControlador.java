package Actividades;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    // Constructor que inicializa el modelo y la vista
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Agregar un nuevo pedido
    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }

    // Eliminar un pedido por su índice
    public void eliminarPedido(int index) {
        List<Pedido> pedidos = modelo.getPedidos();
        if (index >= 0 && index < pedidos.size()) {
            pedidos.get(index).eliminar();
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("Índice de pedido inválido.");
        }
    }

    // Completar un pedido por su índice
    public void completarPedido(int index) {
        List<Pedido> pedidos = modelo.getPedidos();
        if (index >= 0 && index < pedidos.size()) {
            pedidos.get(index).completar();
            vista.mostrarMensaje("Pedido completado.");
        } else {
            vista.mostrarMensaje("Índice de pedido inválido.");
        }
    }

    // Mostrar todos los pedidos
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    // Mostrar pedidos pendientes
    public void mostrarPedidosPendientes() {
        List<Pedido> pendientes = modelo.getPedidosPendientes();
        vista.mostrarPedidos(pendientes);
    }

    // Mostrar pedidos completados
    public void mostrarPedidosCompletados() {
        List<Pedido> completados = modelo.getPedidosCompletados();
        vista.mostrarPedidos(completados);
    }

    // Mostrar historial de pedidos (completados o eliminados)
    public void mostrarHistorialPedidos() {
        List<Pedido> historial = modelo.getHistorialPedidos();
        vista.mostrarPedidos(historial);
    }

    // Contar los pedidos pendientes
    public void contarPedidosPendientes() {
        int cantidadPendientes = modelo.contarPedidosPendientes();
        vista.mostrarMensaje("Cantidad de pedidos pendientes: " + cantidadPendientes);
    }

    // Método principal para controlar el flujo de la aplicación
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    int indiceEliminar = vista.solicitarIndicePedido();
                    eliminarPedido(indiceEliminar);
                    break;
                case "4":
                    // Lógica para actualizar un pedido (se puede añadir si es necesario)
                    break;
                case "5":
                    int indiceCompletar = vista.solicitarIndicePedido();
                    completarPedido(indiceCompletar);
                    break;
                case "6":
                    mostrarPedidosPendientes();
                    break;
                case "7":
                    mostrarPedidosCompletados();
                    break;
                case "8":
                    contarPedidosPendientes();
                    break;
                case "9":
                    mostrarHistorialPedidos();
                    break;
                case "10":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("10"));
        vista.cerrarScanner();
    }
}