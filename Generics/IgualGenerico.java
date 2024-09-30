package Generics;

//Clase IgualGenerico con método genérico esIgualA
public class IgualGenerico {

	// Método genérico que compara dos objetos con equals
	public static <T> boolean esIgualA(T a, T b) {
		if (a == null && b == null) {
			return true; // Ambos son null
		} else if (a == null || b == null) {
			return false; // Uno es null y el otro no
		} else {
			return a.equals(b); // Comparación con equals
		}
	}

	public static void main(String[] args) {
		// Prueba con tipos primitivos (autoboxing a Integer)
		System.out.println("¿5 es igual a 5?: " + esIgualA(5, 5)); // true
		System.out.println("¿5 es igual a 6?: " + esIgualA(5, 6)); // false

		// Prueba con null
		System.out.println("¿null es igual a null?: " + esIgualA(null, null)); // true
		System.out.println("¿null es igual a 'cadena'?: " + esIgualA(null, "cadena")); // false

		// Prueba con Object
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println("¿obj1 es igual a obj2?: " + esIgualA(obj1, obj2)); // false (diferentes referencias)
		System.out.println("¿obj1 es igual a obj1?: " + esIgualA(obj1, obj1)); // true (misma referencia)

		// Prueba con Integer
		Integer num1 = 10;
		Integer num2 = 10;
		System.out.println("¿num1 es igual a num2?: " + esIgualA(num1, num2)); // true (mismo valor)

		// Prueba con String
		String str1 = "hola";
		String str2 = "hola";
		String str3 = new String("hola");
		System.out.println("¿str1 es igual a str2?: " + esIgualA(str1, str2)); // true (igual valor y pool de strings)
		System.out.println("¿str1 es igual a str3?: " + esIgualA(str1, str3)); // true (igual valor, diferente
																				// referencia)
	}// fin de método main
}
