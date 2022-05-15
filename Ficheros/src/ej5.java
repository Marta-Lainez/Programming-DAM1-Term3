/*
Ejercicio 5
Escribe un programa capaz de quitar los comentarios de un programa de Java.
Se utilizaría de la siguiente manera:
quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
Por ejemplo:
quita_comentarios hola.java holav2.java

crea un fichero con nombre holav2.java que contiene el código de hola.java pero
sin los comentarios.
 */

import java.util.*;
import java.io.*;
public class Ej5 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner teclado = new Scanner(System.in);
		boolean java = false;
		String fichero="";
		String aux;
		do {
			System.out.println("escribe el documento .java que deseas descomentar");
			fichero = teclado.next();
			if(fichero.endsWith(".txt"))java=true;
		}while(!java);
		Scanner read = new Scanner(
							new BufferedReader(
									new FileReader(fichero)));
		PrintStream write = new PrintStream
								(new FileOutputStream(fichero.substring(0,fichero.indexOf(".txt"))+"v2.txt"));
		while(read.hasNext()) {
			aux=read.nextLine();
			if(!aux.contains("//")&&!aux.contains("/**")&&!aux.contains("*")&&!aux.contains("*/")) {
				write.println(aux);
			}
				
		}
		write.close();
		read.close();
	}

}
