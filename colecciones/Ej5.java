/*
5) Crea una clase que nos permita almacenar una colecci�n de discos. El nombre de la clase ser�
Coleccion. Los datos miembro ser�n:
� Un vector de 100 elementos de la clase Disco.
� Un entero al que llamaremos �ndice que servir� para saber cu�ntos discos hemos
almacenado en la colecci�n.
Dise�a los m�todos necesarios para gestionar la colecci�n.
 */

import java.util.*;
public class Ej5 {

	public static void main(String[] args) {
		ArrayList <Discos> colecci�n = rellenarLista(27);
		System.out.println("Discos en la colecci�n: " + colecci�n.size());
		
	}
	static ArrayList <Discos> rellenarLista(int tama�o) {
		ArrayList <Discos> lista = new ArrayList <Discos>(tama�o);
		for(int i = 0; i < tama�o; i++) {
			lista.add(new Discos());
		}
		return lista;
	}
}
