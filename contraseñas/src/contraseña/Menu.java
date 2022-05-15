/**
 * Menú principal del programa
 */
package contraseña;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

	// Nombre del archivo de trabajo
	String fichero;
	
	// Entrada de datos
	Scanner in = new Scanner(System.in);
	
	public Menu ( String archivo ) {
		fichero = archivo;
		boolean fin;
		do {
			fin = trabajo();
		} while ( ! fin );
	}
	
	private void imprimir ( ) {
		System.out.println("Elija una opción");
		System.out.println("1.- Insertar usuario, clave\n"
				+ "2.- Borrar usuarios\n"
				+ "3.- Modificar claves de un usuario\n"
				+ "4.- Validar si la clave de un usuario es correcta");
		System.out.println("5.- Terminar");
		
	}
	private boolean trabajo ( ) {
		int opcion;
		do {
			imprimir();
			try {
				opcion = in.nextInt();
			} catch ( Exception e ) {
				System.out.println("Debe introducir un número entre 1 y 5");
				opcion = 0;
				in.next();
			}
		} while ( opcion < 1 || opcion > 5 );
		if ( opcion == 5 )
			return true;
		switch ( opcion ) {
		case 1:
			insertar();
			break;
		case 2:
			System.out.println("Borrar");
			break;
		case 3:
			System.out.println("Modificar");
			break;
		case 4:
			System.out.println("Validar");
			break;
		}
		return false;
	}
	
	private void insertar ( ) {
		Insertar i = new Insertar(fichero);
		String nombre;

		System.out.println("introduzca un nombre de usaurio");
		try {
			nombre = in.next();
		} catch ( Exception e ) {
			System.out.println("Debe introducir un nombre válido");
			in.next();
			i.finalizar();
			return;
		}
		
		String passwd;
		if ( i.comprobarUsuario(nombre) ) {
			i.finalizar();
			System.out.println("Ese usuario ya existe");
		} else {
			System.out.println("Introduzca la contraseña");
			try {
				passwd = in.next();
				i.annadirUsuario(nombre, passwd);
			} catch ( Exception e ) {
				System.out.println("Debe introducir una contraseña válido");
				in.next();
				return;
			} finally {
				i.finalizar();
			}
		}
	}
}
