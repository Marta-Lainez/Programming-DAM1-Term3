/*
 7) Escribir una clase Conjunto que gestione un conjunto de enteros (int) con ayuda de una tabla de
tamaño fijo (100) (un conjunto contiene una lista no ordenada de elementos y se caracteriza
por el hecho de que cada elemento es único: no se debe encontrar dos veces el mismo valor en
la tabla). Las operaciones a implementar (métodos de la clase) son las siguientes:
· vaciar: vacía el conjunto.
· agregar: añade un entero al conjunto
· eliminar: retira un entero del conjunto (habrá que desplazar elementos).
· copiar: recopila un conjunto en otro
· esMiembro: devuelve verdadero si existe en el conjunto un entero dado, o falso si no
	existe.
· posicion: reenvía la posición en el conjunto de un entero dado, o el valor -1 si no existe.
· esIgual: devuelve true si un conjunto es igual a otro, teniendo en cuenta que dos
	conjuntos son iguales si tienen los mismos elementos y en el mismo orden
· imprimir: realiza la visualización del conjunto.
 */

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// Creo 2 conjuntos
		Set <Integer> conjunto = new HashSet <Integer>(100);
		/*Set <Integer> conjunto2 = new HashSet <Integer>(100);*/
		// Relleno 2 conjuntos con enteros NO DUPLICADOS hasta que tengan 100 elementos
		while(conjunto.size() < 100) {
			conjunto = agregar(conjunto, (int)(Math.random()*200)+1);
		}
		/*
		while(conjunto2.size() < 100) {
			conjunto2 = agregar(conjunto2, (int)(Math.random()*200)+1);
		}
		*/
		// imprimir(conjunto);
		/*imprimir(conjunto2);
		System.out.println(esIgual(conjunto,conjunto2));*/
		Set copia = copiar(conjunto);
		System.out.println(esIgual(conjunto,copia));
		
	}
	
	// vaciar: vacía el conjunto
	static Set <Integer> vaciar(Set <Integer> conjunto){
		conjunto.clear();
		return conjunto;
	}
	// agregar: añade un entero al conjunto
	static Set <Integer> agregar(Set <Integer> conjunto, Integer elemento){
		conjunto.add(elemento);
		return conjunto;
	} 
	// retirar un entero del conjunto (habrá que desplazar elementos)
	static Set <Integer> retirar(Set <Integer> conjunto, Integer elemento){
		conjunto.remove(elemento);
		return conjunto;
	}
	// copiar: recopila un conjunto en otro PREGUNTAR EN CLASE
	static Set <Integer> copiar(Set <Integer> conjunto){
		Set copia = (Set)((HashSet)conjunto).clone();
		return copia;
	}
	// esMiembro: devuelve verdadero si existe en el conjunto un entero dado, o falso si no existe
	static boolean esMiembro (Set <Integer> conjunto, Integer entero) {
		return conjunto.contains(entero);
	}
	// posicion: reenvía la posición en el conjunto de un entero dado, o el valor -1 si no existe
	static int posicion(Set <Integer> conjunto, Integer entero){
		int posicion = -1;
		if (esMiembro(conjunto, entero)) {
			int i = 0;
			Iterator <Integer> iterador = conjunto.iterator();
			while(iterador.hasNext()) {
				int valor = iterador.next();
				if (valor == entero) {
					posicion = i;
				}
			}
		}
		return posicion;
	}
	// esIgual: devuelve true si un conjunto es igual a otro, teniendo en cuenta que dos
	// conjuntos son iguales si tienen los mismos elementos y en el mismo orden
	static boolean esIgual (Set <Integer> conjunto,Set <Integer> conjunto2) {
		if (conjunto.size() == conjunto2.size() && conjunto.containsAll(conjunto2)) {
			return true;
		}
		return false;
	}
	// imprimir: realiza la visualización del conjunto
	static void imprimir (Set <Integer> conjunto) {
		System.out.println(conjunto);
	}
}
