/*
6) Escribe un programa que utilice la clase Empleado, creando un vector de objetos de la clase
Empleado y luego lo llene con datos correspondientes a 50 empleados (utilizar una tabla de
nombres para rellenar con un random). Una vez rellenado, visualizar los datos de todos los
empleados
 */

import java.util.*;
public class Ej6 {

	public static void main(String[] args) {
		
		ArrayList <Empleado> lista = rellenarLista(6);
		
		// Imprime el interior de la lista ojeto a objeto con el bucle for each
		for(Empleado e: lista) {
			System.out.println(e.toString());
		}
	}
		
	// Metodo que crea una lista de 5 nombres de tipo String
	static ArrayList<String> listaNombres (){
		ArrayList <String> lista = new ArrayList<String>(5);
		lista.add("Miguel");
		lista.add("Álvaro");
		lista.add("Eric");
		lista.add("Marta");
		lista.add("Samu");
		return lista;
	}
	// Metodo que devuelve una lista de los elementos pedidos por parametro al que les da un numero en orden y un nombre aleatorio
	// de la lista del metodo anterior
	static ArrayList<Empleado> rellenarLista( int tamaño){
		ArrayList <String> listaNombres = listaNombres();
		ArrayList <Empleado> lista = new ArrayList <Empleado>(tamaño);
		for (int i = 0; i < tamaño; i++) {
			lista.add(new Empleado(listaNombres.get((int)(Math.random()*4)+1), i+1));
		}
		
		return lista;
	}
}
