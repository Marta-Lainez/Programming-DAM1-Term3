/*
Ejercicio del tema 6 Vectores, pero hecho con listas en vez de vectores
1) Se generan 20 números aleatorios de tipo entero y se almacenan en un vector. Hay que calcular
y mostrar la media y, además, mostrar cuántos números hay:
-Superiores a la media
-Inferiores a la media
-Iguales a la media
 */

import java.util.*;
public class Ej1 {

	public static void main(String[] args) {
		ArrayList<NumAleatorio> listaNumeros = rellenarLista();
		
		imprimir(listaNumeros);
		
		int cantidad = listaNumeros.size();
		
		float media = mediaNum(listaNumeros, cantidad);
		System.out.println("La media es: " + media);
		
		calcular(listaNumeros, media);
	}
	// Metodo que crea y rellena una lista con numeros aleatorios
	static ArrayList<NumAleatorio> rellenarLista(){
		ArrayList<NumAleatorio> listaNumeros = new  ArrayList<NumAleatorio>(20);
		for (int i = 0; i < 20; i++) {
			listaNumeros.add(new NumAleatorio());
		}
		return listaNumeros;
	}
	// Metodo que imprime todos los elementos de una lista
	static void imprimir(ArrayList<NumAleatorio> listaNumeros) {
		for(NumAleatorio e: listaNumeros) {
			System.out.println(e.getNum());
		}
	}
	// Metodo que calcula la media de todos los numeros dentro de la lista
	static float mediaNum(ArrayList<NumAleatorio> listaNumeros, int cantidad) {
		float media = 0;
		for (NumAleatorio e: listaNumeros) {
			media += e.getNum();
		}
		media = media/listaNumeros.size();
		return media;
	}
	// Metodo que calcula la cantidad de elementos por encima de la media, inferiores a la media o iguales a ella
	static void calcular(ArrayList<NumAleatorio> listaNumeros, float media) {
		int superior = 0;
		int igual = 0;
		int inferior = 0;
		for(NumAleatorio e: listaNumeros) {
			if(e.getNum() > media) 
				superior++;
			else if(e.getNum() < media)
				inferior++;
			else
				igual++;
		}
		System.out.println("Iguales: " + igual + "\nSuperiores: " + superior + "\nInferiores: " + inferior);
	}
	
}
