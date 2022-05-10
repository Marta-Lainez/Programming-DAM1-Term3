/*
3) Leer un vector de 10 componentes enteros; calcular el mayor, el menor y los lugares donde se
encuentran.
 */

import java.util.*;
public class Ej3 {

	public static void main(String[] args) {
		ArrayList<NumAleatorio> lista = crearLista(10);
		
		ListIterator <NumAleatorio> iterador = lista.listIterator();
		int mayor = lista.get(0).getNum();
		int posicionMayor = 0;
		int menor = mayor;
		int posicionMenor = 0;
		
		imprimir(lista);
		System.out.println("////");
		
		/*
		 * Creo un ListIterador que va recorriendo la lista elemento a elemento. Guardo el elemento en cada ronda en la variable valor, y la voy comparando
		 * con el mas grande y el mas pequeño. Cuando encuentro un mayor o menor, guardo su valor y tambien su posicion con un  nextIndex()
		 */
		while (iterador.hasNext()) {
			int valor = iterador.next().getNum();
			if (valor > mayor) {
				mayor = valor;
				posicionMayor = iterador.nextIndex();
			}
			if (valor < menor) {
				menor = valor;
				posicionMenor = iterador.nextIndex();
			}	
		}
		
		System.out.println("Mayor en la posicion " + posicionMayor + ": " + mayor);
		System.out.println("Menor en la posicion " + posicionMenor + ": " + menor);
		
	}
	static ArrayList<NumAleatorio> crearLista(int tamaño){
		ArrayList<NumAleatorio> lista = new ArrayList<NumAleatorio>(tamaño);
		for(int i = 0; i < 10; i++) {
			lista.add(new NumAleatorio());
		}
		return lista;
	}
	static void imprimir(ArrayList<NumAleatorio> lista) {
		for(NumAleatorio e: lista) {
			System.out.println(e.getNum());
		}
	}
	
}
