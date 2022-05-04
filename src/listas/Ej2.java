package listas;
import java.util.ArrayList;
public class Ej2 {
	public static void main (String[]Args) {
		// Creo las 3 listas
		ArrayList<NumAleatorio> lista1 = crearLista(10);
		ArrayList<NumAleatorio> lista2 = crearLista(10);
		ArrayList<NumAleatorio> lista3 = crearLista(10);
		
		// Imprimo las 2 primeras listas
		imprimir(lista1);
		System.out.println("///////");
		imprimir(lista2);
		System.out.println("///////");
		
		// Imprimo el resultado en la tercera lista
		for (int i = 0; i < 10; i++) {
			sumar(lista1, lista2, lista3, i);
		}
	}
	// Con este metodo creo listas del tamaño deseado llenas de numeros aleatorios entre 0 y 99
	static ArrayList <NumAleatorio> crearLista(int tamaño){
		ArrayList<NumAleatorio> lista = new ArrayList<NumAleatorio>(tamaño);
		for (int i = 0; i < tamaño; i++) {
			lista.add(new NumAleatorio());
		}
		return lista;
	}
	// Este metodo imprime cualquier lista
	static void imprimir(ArrayList<NumAleatorio> lista) {
		for(NumAleatorio e: lista) {
			System.out.println(e.getNum());
		}
	}
	// Este metodo suma en la posicion del indice deseado de lista 3, los valores en esa misma posicion de lista 1 y lista 2.
	// Ejemplo: Para i = 0 Lista1 = 3 y Lista2 = 5. Lista3 = 3+5 = 8
	static void sumar(ArrayList<NumAleatorio> lista1,ArrayList<NumAleatorio> lista2,ArrayList<NumAleatorio> lista3, int indice){
		int valor1 =  lista1.get(indice).getNum();
		int valor2 = lista2.get(indice).getNum();
		NumAleatorio e = lista3.get(indice);
		e.setNum(valor1+valor2);
		System.out.println(e.getNum());
	}
}
