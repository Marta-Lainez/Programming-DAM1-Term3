/*
4) Generar dos vectores de dimensión 10 (dar valores aleatorios entre 1 y 5) y comprobar para
cada uno de los elementos del primer vector cuántas veces está en el segundo, es decir
primero: 3,7,2
segundo: 3,3,5
el resultado debe ser:
elemento 1 (3): 2 veces
elemento 2 (7): 0 veces
elemento 3 (2): 0 veces
 */
import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		ArrayList <Integer> lista1 =  rellenarLista(10);
		ArrayList <Integer> lista2 =  rellenarLista(10);
		imprimir(lista1);
		imprimir(lista2);
		
		contarVeces(lista1,lista2);
		
	}
	// Metodo que rellena cualquier lista del tamaño pedido por parametro
	static ArrayList <Integer> rellenarLista(int tamaño){
		ArrayList <Integer> lista = new ArrayList <Integer>(tamaño);
		for (int i = 0; i < tamaño; i++) {
			lista.add((int)(Math.random()*5)+1);
		}
		return lista;
	}
	/*
	 * Metodo para contar cuantas veces esta cada elemento de la primera lista en la segunda lista
	 */
	static void contarVeces(ArrayList <Integer> lista1, ArrayList <Integer> lista2) {
		int contador = 0;
		//boolean esta = false;
		int contadorVistos = 0;
		ArrayList <Integer> vistos = new ArrayList();
		// Iterador que recorre la primera lista
		Iterator <Integer> iterador1 = lista1.iterator();
		while(iterador1.hasNext()) {
			int valor1 = iterador1.next();
			int valor2 = 0;
			// Iterador que recorre la segunda lista para cada elemento de la primera lista
			Iterator <Integer> iterador2 = lista2.iterator();
			while(iterador2.hasNext()) {
				valor2 = iterador2.next();
				if(valor1 == valor2) {
					contador++;
				}
			}
			// Tengo una lista que acumula los elementos que han sido ya analizados de la lista1 para que no se repitan al imprimir
			vistos.add(valor1);
			Iterator <Integer> iteradorVistos = vistos.iterator();
			while(iteradorVistos.hasNext()) {
				int valor3 = iteradorVistos.next();
				if (valor1 == valor3) {
					contadorVistos++;
				}
			}
			if(contadorVistos == 1) {
				System.out.println("Valor " + valor1 + ": " + contador);
			}
			contador = 0;
			contadorVistos = 0;
		}
	
	}
	static void imprimir (ArrayList <Integer> lista) {
		for(Integer e: lista) {
			System.out.println(e);
		}
		System.out.println("////////");
	}
}
