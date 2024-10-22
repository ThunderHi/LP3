package Actividades;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Clase Personaje que representa los personajes del videojuego con nivel incluido
class Personaje {
    private String nombre;
    private int vida, ataque, defensa, alcance, nivel;

    // Constructor para inicializar el personaje
    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = 1;  // Nivel inicial por defecto
    }

    // Getters para acceder a los atributos
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    // Método para establecer un nuevo valor a un atributo específico
    public void setAtributo(String atributo, int valor) {
        switch (atributo.toLowerCase()) {
            case "vida": this.vida = valor; break;
            case "ataque": this.ataque = valor; break;
            case "defensa": this.defensa = valor; break;
            case "alcance": this.alcance = valor; break;
            default: System.out.println("Atributo no válido."); break;
        }
    }

    // Método para subir de nivel y mejorar atributos
    public void subirNivel() {
        nivel++;
        vida += 10;
        ataque += 5;
        defensa += 3;
        alcance += 2;
        System.out.println(nombre + " ha subido al nivel " + nivel + ". Atributos mejorados.");
    }

    // Método toString para mostrar la información del personaje
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Vida: " + vida + ", Ataque: " + ataque +
               ", Defensa: " + defensa + ", Alcance: " + alcance + ", Nivel: " + nivel;
    }
}

// Clase Gestor que maneja las operaciones sobre los personajes
class Gestor {
    private List<Personaje> personajes = new ArrayList<>();  // Lista de personajes
    private final String rutaArchivo = "personajes.txt";  // Ruta del archivo donde se almacenan personajes

    // Constructor que carga personajes existentes y personajes aleatorios al iniciar
    public Gestor() throws IOException {
        cargarPersonajes();
        cargarPersonajesAleatorios();
    }

    // Método para cargar personajes desde archivo
    private void cargarPersonajes() throws IOException {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");  // Dividimos los atributos del personaje separados por comas
                personajes.add(new Personaje(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));  // Añadimos el personaje a la lista
            }
            lector.close();
        }
    }

    // Método para guardar personajes en archivo
    private void guardarPersonajes() throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
        for (Personaje p : personajes) {
            escritor.write(p.getNombre() + "," + p.getVida() + "," + p.getAtaque() + "," 
                    + p.getDefensa() + "," + p.getAlcance() + "," + p.getNivel() + "\n");
        }
        escritor.close();  // Cerramos el escritor para guardar los cambios
    }

    // Método para cargar personajes aleatorios al iniciar el programa
    private void cargarPersonajesAleatorios() {
        String[] nombres = {"Guerrero", "Mago", "Arquero", "Asesino"};
        Random rand = new Random();
        for (String nombre : nombres) {
            personajes.add(new Personaje(nombre, rand.nextInt(100) + 50, rand.nextInt(50) + 20,
                    rand.nextInt(40) + 10, rand.nextInt(30) + 5));
        }
        System.out.println("Personajes aleatorios añadidos.");
    }

    // Método para filtrar personajes por un atributo específico y mostrarlos en orden
    public void filtrarPorAtributo(String atributo) {
        List<Personaje> ordenados;
        switch (atributo.toLowerCase()) {
            case "vida":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getVida)).collect(Collectors.toList());
                break;
            case "ataque":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getAtaque)).collect(Collectors.toList());
                break;
            case "defensa":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getDefensa)).collect(Collectors.toList());
                break;
            case "alcance":
                ordenados = personajes.stream().sorted(Comparator.comparingInt(Personaje::getAlcance)).collect(Collectors.toList());
                break;
            default:
                System.out.println("Atributo no válido.");
                return;
        }
        // Mostrar personajes ordenados por el atributo seleccionado
        ordenados.forEach(System.out::println);
    }

    // Método para actualizar un atributo específico de un personaje
    public void actualizarAtributo(String nombre, String atributo, int valor) throws IOException {
        for (Personaje p : personajes) {
            if (p.getNombre().equals(nombre)) {
                p.setAtributo(atributo, valor);  // Actualizamos el atributo seleccionado
                guardarPersonajes();  // Guardamos los cambios en el archivo
                System.out.println("Atributo actualizado.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    // Método para mostrar estadísticas generales de los personajes
    public void mostrarEstadísticas() {
        int totalPersonajes = personajes.size();
        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("Total de personajes: " + totalPersonajes);
        System.out.println("Promedio de vida: " + promedioVida);
        System.out.println("Promedio de ataque: " + promedioAtaque);
        System.out.println("Promedio de defensa: " + promedioDefensa);
        System.out.println("Promedio de alcance: " + promedioAlcance);
    }

    // Método para importar personajes desde un archivo externo
    public void importarPersonajes(String rutaArchivoExterno) throws IOException {
        File archivo = new File(rutaArchivoExterno);
        if (archivo.exists()) {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                personajes.add(new Personaje(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));
            }
            lector.close();
            guardarPersonajes();  // Guardamos los personajes importados
            System.out.println("Personajes importados exitosamente.");
        } else {
            System.out.println("Archivo no encontrado.");
        }
    }

    // Método para subir de nivel a todos los personajes y mejorar sus atributos
    public void subirNivelTodos() throws IOException {
        for (Personaje p : personajes) {
            p.subirNivel();  // Subimos el nivel de cada personaje
        }
        guardarPersonajes();  // Guardamos los cambios en el archivo
    }

    // Método para mostrar todos los personajes
    public void mostrarPersonajes() {
        personajes.forEach(System.out::println);  // Imprimimos la lista de personajes
    }
}

// Clase principal para probar el Gestor con funcionalidades avanzadas
public class Main {
    public static void main(String[] args) throws IOException {
        Gestor gestor = new Gestor();  // Creamos el gestor

        // Mostrar personajes cargados
        gestor.mostrarPersonajes();

        // Mostrar estadísticas
        gestor.mostrarEstadísticas();

        // Filtrar personajes por ataque
        gestor.filtrarPorAtributo("ataque");

        // Actualizar atributo de un personaje
        gestor.actualizarAtributo("Guerrero", "vida", 150);

        // Importar personajes desde un archivo externo
        gestor.importarPersonajes("personajesExternos.txt");

        // Subir nivel a todos los personajes
        gestor.subirNivelTodos();

        // Mostrar personajes después de subir de nivel
        gestor.mostrarPersonajes();
    }
}
