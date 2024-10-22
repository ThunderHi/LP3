package Actividades;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;  // Lista de pedidos

    // Constructor que inicializa la lista de pedidos
    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Método para agregar un nuevo pedido
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Método para obtener la lista de todos los pedidos
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Método para obtener solo los pedidos pendientes
    public List<Pedido> getPedidosPendientes() {
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.esPendiente()) {
                pendientes.add(pedido);
            }
        }
        return pendientes;
    }

    // Método para obtener solo los pedidos completados
    public List<Pedido> getPedidosCompletados() {
        List<Pedido> completados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("completado")) {
                completados.add(pedido);
            }
        }
        return completados;
    }

    // Método para contar los pedidos pendientes
    public int contarPedidosPendientes() {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.esPendiente()) {
                contador++;
            }
        }
        return contador;
    }

    // Método para obtener el historial de pedidos completados o eliminados
    public List<Pedido> getHistorialPedidos() {
        List<Pedido> historial = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("completado") || pedido.getEstado().equals("eliminado")) {
                historial.add(pedido);
            }
        }
        return historial;
    }
}