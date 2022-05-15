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

public class Insertar {

	String fichero;
	Scanner s = null;
	boolean add = true;
	
	public Insertar ( String archivo ) {
		fichero = archivo;
		
		//System.out.println("Abro fichero: " + fichero);
		try {
			s = new Scanner(
					new BufferedReader(
							new FileReader(fichero)));
		} catch (FileNotFoundException e1) {
			add = false;
		}
	}
	
	public void finalizar ( ) {
		if ( s != null )
			s.close();
		s = null;
	}
	
	public boolean comprobarUsuario ( String nombre ) {
		if ( s == null )
			return false;
		boolean encontrado = false;
		// System.out.println("Compruebo nombre de usuario en archivo");
		while ( ! encontrado && s.hasNext() ) {
			String usuario = s.next();
			if ( nombre.equals(usuario) )
				return true;
			s.nextLine();
		}
		return false;
	}
	
	public void annadirUsuario ( String nombre, String passwd ) {
		// System.out.println("inserto usuario: " + nombre);
		if ( s != null )
			s.close();
		s = null;
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(
					new FileOutputStream(fichero, add));
			ps.println(nombre + " " + passwd);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
}
