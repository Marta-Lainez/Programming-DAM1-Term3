package listas;
// Ejercicio del tema 6 Vectores, pero hecho con listas en vez de vectores
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
	
	static ArrayList<NumAleatorio> rellenarLista(){
		ArrayList<NumAleatorio> listaNumeros = new  ArrayList<NumAleatorio>(20);
		for (int i = 0; i < 20; i++) {
			listaNumeros.add(new NumAleatorio());
		}
		return listaNumeros;
	}
	
	static void imprimir(ArrayList<NumAleatorio> listaNumeros) {
		for(NumAleatorio e: listaNumeros) {
			System.out.println(e.getNum());
		}
	}
	
	static float mediaNum(ArrayList<NumAleatorio> listaNumeros, int cantidad) {
		float media = 0;
		for (NumAleatorio e: listaNumeros) {
			media += e.getNum();
		}
		media = media/listaNumeros.size();
		return media;
	}
	
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
