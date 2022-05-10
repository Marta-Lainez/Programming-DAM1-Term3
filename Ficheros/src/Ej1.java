/*
Ejercicio 1
Escribe un programa que guarde en un fichero con nombre primos.txt los
n�meros primos que hay entre 1 y 500. (Busca en Wikipedia "Criba de
Erat�stenes)
 */

import java.io.*;
public class Ej1 {

	public static void main(String[] args) {
		CribaErat�stenes criba = new CribaErat�stenes(500);
        
        PrintStream printStream = null;
		
		try {
			printStream = new PrintStream(
					new FileOutputStream("primos.txt"), true);
			
			printStream.print(criba.primos);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} finally {
			if (printStream != null) {
				printStream.close();
			}
		}
	}
}
