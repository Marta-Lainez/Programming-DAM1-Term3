/**
 * Antonio Cepero
 * 202205
 * 
 * Inserta un usuario en el fichero de contraseñas si éste no está
 */
package contraseña;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class Modificar {

	String fichero;
	Scanner s = null;
	
	public Modificar ( String archivo ) throws FileNotFoundException {
		fichero = archivo;
		boolean existe;
		
		System.out.println("Abro fichero: " + fichero);
		s = new Scanner(
				new BufferedReader(
						new FileReader(fichero)));
	}
	
	public void finalizar ( ) {
		if ( s != null )
			s.close();
		s = null;
	}
	
	public boolean comprobarUsuario ( String nombre ) {
		boolean encontrado = false;
		// System.out.println("Compruebo nombre de usuario en archivo");
		while ( ! encontrado && s.hasNextLine() ) {
			String usuario = s.next();
			if ( nombre.equals(usuario) )
				return true;
			s.nextLine();
		}
		return false;
	}
	
	public void annadirUsuario ( String nombre, String passwd ) {
		// System.out.println("inserto usuario: " + nombre);
		s.close();
		s = null;
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(
					new FileOutputStream(fichero, true));
			ps.println(nombre + " " + passwd);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
}
