/*
Ejercicio 3
Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos
ficheros mezcladas, es decir, la primera línea será del primer fichero, la segunda
será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
Los nombres de los dos ficheros origen y el nombre del fichero destino se deben
pasar como argumentos en la línea de comandos.
Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas
pueden tener tamaños diferentes.
 */
import java.io.*;
import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		boolean vacioF1 = false;
		boolean vacioF2 = false;
		Scanner entrada1 = null;
		Scanner entrada2 = null;
		PrintStream printStream = null;
		try {
			String lineaF1="";
			String lineaF2="";
			int contador = 1;
			
			entrada1 = new Scanner(
							new BufferedReader(
										new FileReader("ej3_primero.txt")));
			entrada2 = new Scanner(
							new BufferedReader(
									new FileReader("ej3_segundo.txt")));
			printStream = new PrintStream(
								new FileOutputStream("ejercicio3.txt"));
			while (entrada1.hasNext() || entrada2.hasNext()) {
			
				if(contador % 2 != 0 && entrada1.hasNext()) {
					lineaF1 = entrada1.nextLine();
					printStream.println(lineaF1);
				}
				else if(contador % 2 != 0){
					lineaF2 = entrada2.nextLine();
					printStream.println(lineaF2);
				}else if(contador % 2 == 0 && entrada2.hasNext()) {
					lineaF2 = entrada2.nextLine();
					printStream.println(lineaF2);
				}
				else if (entrada1.hasNext()) {
					lineaF1 = entrada1.nextLine();
					printStream.println(lineaF1);
				}
				contador++;
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}finally {
			if(entrada1 != null) {
			entrada1.close();
			}
			if(entrada2 != null) {
				entrada2.close();
			}
			if(printStream != null) {
				printStream.close();
			}
		}
		
	}

}
