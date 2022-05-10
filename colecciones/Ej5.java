/*
5) Crea una clase que nos permita almacenar una colección de discos. El nombre de la clase será
Coleccion. Los datos miembro serán:
· Un vector de 100 elementos de la clase Disco.
· Un entero al que llamaremos índice que servirá para saber cuántos discos hemos
almacenado en la colección.
Diseña los métodos necesarios para gestionar la colección.
 */

import java.util.*;
public class Ej5 {

	public static void main(String[] args) {
		ArrayList <Discos> colección = rellenarLista(27);
		System.out.println("Discos en la colección: " + colección.size());
		
	}
	static ArrayList <Discos> rellenarLista(int tamaño) {
		ArrayList <Discos> lista = new ArrayList <Discos>(tamaño);
		for(int i = 0; i < tamaño; i++) {
			lista.add(new Discos());
		}
		return lista;
	}
}
