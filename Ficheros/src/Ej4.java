/*
Ejercicio 4
Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
contenidas en un fichero de texto. El nombre del fichero que contiene las
palabras se debe pasar como argumento en la línea de comandos. El nombre
del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort,
por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una línea.
 */
import java.util.*;
import java.io.*;
public class Ej4 {
	public static void main (String [] Args) {
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("ej4.txt")));
			printStream = new PrintStream(
								new FileOutputStream("ej4_sort.txt"));
			// Forma de separar palabras de una linea por espacios y almacenarlas por separado en un vector de Strings
			String linea = entrada.nextLine();
			String[] palabras = linea.split(" ");
			String palabra1 = palabras[0];
			String palabra2 = palabras[1];
			String palabra3 = palabras[2];
			String palabra4 = palabras[3];
			
			ArrayList <String> lista = new ArrayList<String>(); // Paso los elementos del vector a una lista
			for (int i = 0; i < palabras.length; i++) {
				lista.add(palabras[i]);
			}
			Collections.sort(lista); // Ordeno los elementos de la lista en orden alfabetico
			for(String e: lista) {
				printStream.print(e + " ");
			}
		}catch(FileNotFoundException e){
			System.out.println("Error.");
		}finally {
			if (entrada != null) {
				entrada.close();
			}
			if(printStream != null) {
				printStream.close();
			}
		}
	}
}
