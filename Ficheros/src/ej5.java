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
import java.util.regex.Pattern;
import java.io.*;

public class Ej5 {

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
			// Pattern = Pattern.compile(["\n"]);
		
			/*
			boolean comentarioBloque = false;
			boolean comentario = false;
			int contadorBarras = 0;
			int contadorCierreBloque = 0;
			int c = entrada.read();
			while(c != -1) {
			
				if( c != '/' && contadorBarras == 1) {
					contadorBarras = 0;
				}
				if(c != '*' && contadorCierreBloque == 1) {
					contadorCierreBloque = 0;
				}
				
				if ( c == '/' ) {
					contadorBarras++;
				
				}
				
				if (c == '/' && contadorBarras == 2) {
					comentario = true;
					contadorBarras = 0;
				}
				else if (c == '*' && contadorBarras == 1) {
					comentarioBloque = true;
				}
				if (comentario) {
					if (c == '\n') {
						
						comentario = false;
					}
				}
				if (comentarioBloque) {
					if (c == '*') {
						contadorCierreBloque++;
					}
					else if(c == '/' && contadorCierreBloque == 1) {
						comentarioBloque = false;
						contadorCierreBloque = 0;
					}
				}
				if (!comentarioBloque && !comentario) {
					printStream.print((char)c);
				}
					
			}
				
			*/
		}catch(IOException e) {
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
