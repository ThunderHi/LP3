package Generics;

//Creando excepción personalizada
class InvalidSubscriptException extends IllegalArgumentException {
	// Constructor por defecto
	public InvalidSubscriptException() {}

	// Constructor con parámetro
	public InvalidSubscriptException(String message) {
		super(message); // Inicializando constructor de clase Padre
	}
}

public class ExperienciaUno {
	// Método genérico imprimirArreglo
	public static <E> void imprimirArreglo(E[] arregloEntrada) {
		// Muestra los elementos del arreglo
		for (E elemento : arregloEntrada)
			System.out.printf("%s ", elemento);
		System.out.println();
	} // Fin del método imprimirArreglo

	// Sobrecargando método con parámetros no genéricos
	public static <E> void imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
		if (subindiceInferior >= subindiceSuperior || subindiceInferior < 0
				|| subindiceSuperior >= arregloEntrada.length) {
			throw new InvalidSubscriptException("Error: Indices invalidos");
		}
		// Muestra parte de los elementos del arreglo
		for (int i = subindiceInferior; i <= subindiceSuperior && i < arregloEntrada.length; i++) {
			System.out.printf("%s ", arregloEntrada[i]);
		}
		System.out.println();
	} // fin del método imprimirArreglo sobrecargado

	public static void main(String args[]) {
		// crea arreglos de objetos Integer, Double y Character
		Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
		Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };
		System.out.println("El arreglo arregloInteger contiene:");
		imprimirArreglo(arregloInteger); // pasa un arreglo Integer
		System.out.println("\nEl arreglo arregloDouble contiene:");
		imprimirArreglo(arregloDouble); // pasa un arreglo Double
		System.out.println("\nEl arreglo arregloCharacter contiene:");
		imprimirArreglo(arregloCharacter); // pasa un arreglo Character
		System.out.print("\n"); //Agregando separación entre pruebas

		// Probando método genérico sobrecargado
		try { //Inicio de bloque Try
			System.out.println("El arreglo arregloInteger del 1ro al 4to contiene:");
			imprimirArreglo(arregloInteger, 0, 3); // pasa un arreglo Integer e indices
			System.out.println("\nEl arreglo arregloDouble del 2do al 5to contiene:");
			imprimirArreglo(arregloDouble, 1, 4); // pasa un arreglo Double e indices
			System.out.println("\nEl arreglo arregloCharacter del 1ro al 3ro contiene:");

			// Arrojará una excepción por indices
			imprimirArreglo(arregloCharacter, 3, 2); // pasa un arreglo Character e indices
		} catch (InvalidSubscriptException e) { //Bloque que manejará la excepcion
			System.out.println(e.getMessage());	//Imprime el memsaje personalizado
		}

	}// fin de main
}// fin de la clase PruebaMetodoGenerico
