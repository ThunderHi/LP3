package Actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    // Constructor que inicializa el escáner para entradas del usuario
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Solicitar al usuario el nombre del plato
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // Solicitar el tipo de plato al usuario
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato: ");
        return scanner.nextLine();
    }

    // Solicitar el índice del pedido
    public int solicitarIndicePedido() {
        System.out.print("Introduce el índice del pedido: ");
        return scanner.nextInt();
    }

    // Mostrar la lista de pedidos
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println(i + ": " + pedido.getNombrePlato() + " - Tipo: " + pedido.getTipoPlato() + " - Estado: " + pedido.getEstado());
            }
        }
    }

    // Mostrar un mensaje al usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Mostrar el menú de opciones
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Completar Pedido");
        System.out.println("6. Mostrar Pedidos Pendientes");
        System.out.println("7. Mostrar Pedidos Completados");
        System.out.println("8. Contar Pedidos Pendientes");
        System.out.println("9. Ver Historial de Pedidos");
        System.out.println("10. Salir");
    }

    // Solicitar la opción seleccionada del usuario
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Cerrar el escáner
    public void cerrarScanner() {
        scanner.close();
    }
}
