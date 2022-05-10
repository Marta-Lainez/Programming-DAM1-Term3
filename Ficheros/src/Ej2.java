/*
Ejercicio 2
Realiza un programa que lea el fichero creado en el ejercicio anterior y que
muestre los números por pantalla.
 */
import java.io.*;
import java.util.*;
public class Ej2 {

	public static void main(String[] args) {
		Scanner entrada = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
								new FileReader("primos.txt")));
			
			String linea = entrada.nextLine();
			System.out.print(linea);
			
		}catch(FileNotFoundException e){
			System.out.println("Error con el archivo");
		}finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

}
