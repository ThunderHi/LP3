package Generics;

//Creando excepcion personalizada
class ExcepcionPilaVacia extends IllegalArgumentException {
	public ExcepcionPilaVacia() {}

	public ExcepcionPilaVacia(String message) {
		super(message);
	}
}

//Creando excepcion personalizada
class ExcepcionPilaLlena extends IllegalArgumentException {
	public ExcepcionPilaLlena() {}

	public ExcepcionPilaLlena(String message) {
		super(message);
	}
}

public class Pila<E> {
	private final int tamanio; // número de elementos en la pila
	private int superior; // ubicación del elemento superior
	private E[] elementos; // arreglo que almacena los elementos de lapila

	// el constructor sin argumentos crea una pila del tamaño predeterminado
	public Pila() {
		this(10); // tamaño predeterminado de la pila
	} // fin del constructor de Pila sin argumentos

	// constructor que crea una pila del número especificado de elementos
	public Pila(int s) {
		tamanio = s > 0 ? s : 10; // establece el tamaño de la Pila
		superior = -1; // al principio, la MarcoTeorico.Pila está vacía
		elementos = (E[]) new Object[tamanio]; // crea el arreglo
	} // fin del constructor de Pila sin argumentos

	// mete un elemento a la pila; si tiene éxito, devuelve verdadero;
	// en caso contrario, lanza excepción ExcepcionPilaLlena
	public void push(E valorAMeter) {
		if (superior == tamanio - 1) // si la pila está llena
			throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter));
		elementos[++superior] = valorAMeter; // mete valorAMeter enPila
	} // fin del método push

	// devuelve el ultimo elemento o lanza ExcepcionPilaVacia
	public E pop() {
		if (superior == -1) // si la pila está vacía
			throw new ExcepcionPilaVacia("Pila vacia, no se puede sacar");
		return elementos[superior--]; // elimina y devuelve el ultimo
	} // fin del método pop

	// Método que verifica si elemento es contenido
	public Boolean contains(E elemento) {
		for (int i = superior; i >= 0; i--) { // Recorrer desde el tope hacia abajo
			if (elementos[i].equals(elemento)) { // Comparar utilizando equals()
				return true;
			}
		}
		return false; // Si no encuentra el elemento, retorna false
	}

	// Método genérico que compara dos pilas para verificar si contienen los mismos
	// elementos en el mismo orden
	public boolean esIgual(Pila<E> otraPila) {
		// Verificar si ambas pilas tienen el mismo tamaño
		if (this.superior != otraPila.superior) {
			return false; // Si el tamaño es diferente, no son iguales
		}

		// Comparar elemento por elemento desde el tope hacia abajo
		for (int i = 0; i <= this.superior; i++) {
			if (!this.elementos[i].equals(otraPila.elementos[i])) {
				return false; // Si algún elemento es diferente, las pilas no son iguales
			}
		}

		return true; // Si todos los elementos son iguales, las pilas son iguales
	}

	public static void main(String[] args) {
		// Crear dos pilas de enteros con tamaño 5
		Pila<Integer> pila1 = new Pila<>(5);
		Pila<Integer> pila2 = new Pila<>(5);

		// Añadiendo los mismos elementos a ambas pilas
		pila1.push(1);
		pila1.push(2);
		pila1.push(3);

		pila2.push(1);
		pila2.push(2);
		pila2.push(3);

		// Probando método esIgual
		System.out.println("¿Las pilas son iguales?: " + pila1.esIgual(pila2)); // true

		// Añadiendo un elemento adicional a una pila
		pila2.push(4);

		// Probando método esIgual después de agregar un elemento extra
		System.out.println("¿Las pilas son iguales después de agregar un elemento a pila2?: " + pila1.esIgual(pila2)); // false
		
		//Probando pop()
		pila2.pop();
		
		//Probando contains()
		System.out.println("¿La pila2 aun contiene 4?: "+ pila2.contains(4));
	}// fin del main
}// fin de la clase Pila< E >