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

public class ej5 {

	public static void main(String[] args) {
		quita_comentarios("comentarios_si.txt", "comentarios_no.txt");
	}
	static void quita_comentarios (String fichero_original, String fichero_limpio) {
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader(fichero_original)));
			printStream = new PrintStream(
								(new FileOutputStream(fichero_limpio)));
			boolean comentario = false;
			int contadorBarras = 0;
			int c = 0;
			while(c != -1) {
				if ( c == '/' ) {
					contadorBarras++;
					
					
					
					
					
				}
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}finally {
			if (entrada != null) {
				entrada.close();
			}
			if (printStream != null) {
				printStream.close();
			}
		}
	}

}
