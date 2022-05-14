/*
Ejercicio 1
Vamos a gestionar las multas de los veh�culos de un municipio de los que conocemos:
� Matr�cula: cadena formada por cuatro n�meros d�gitos y tres letras consonantes
Nota: las letras consonantes no incluyen la e�e y la cu.
� Marca
� Modelo
� Propietario
� A�o de matriculaci�n
Adem�s, para cada veh�culo si las tiene, se guarda la informaci�n de las sanciones impuestas al mismo,
conteniendo:
� Fecha
� Motivo
� Importe
Crear un programa que muestre un men� y permita:
1. A�adir un veh�culo al municipio
2. Eliminar un veh�culo: si existen sanciones, debe mostrar el n�mero de las mismas y no realizar la
eliminaci�n
3. A�adir una sanci�n a un veh�culo
4. Consultar las sanciones que tiene un veh�culo
5. Eliminar las sanciones de un veh�culo
6. Mostrar un listado de los veh�culos para los que la cuant�a de las sanciones es superior a una cantidad
determinada (que se debe solicitar)
7. Terminar el programa
Los datos de veh�culos deben ser le�dos de un fichero al inicio de la ejecuci�n del programa, si dicho fichero
existe. An�logamente, ser�n almacenados en dicho fichero antes de finalizar el programa que, si no exist�a,
ser� creado en ese momento.
 */
import java.util.*;
import java.io.*;
public class Ej1 {

	public static void main(String[] args) {
		menu();
	}
	static void deCopiaACoche() {
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("copiaCoche.txt")));
			printStream = new PrintStream(
								new FileOutputStream("coche.txt"));
		
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				printStream.println(linea);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada != null) {
				entrada.close();
			}
			if(printStream != null) {
				printStream.close();
			}
		}
	}
	// 1. A�adir un veh�culo al municipio
	static void annadirVehiculo(String matricula, String marca, String modelo, String propietario, String annoMatricula) {
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(
								new FileOutputStream("coche.txt", true));
			Coches miCoche = new Coches(matricula, marca, modelo, propietario, annoMatricula);
			
			printStream.println(miCoche.toString());
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}finally {
			if(printStream != null) {
				printStream.close();
			}
		}
	}
	// 3. A�adir una sanci�n a un veh�culo
	static void annadirMulta(String matricula, String fecha, String motivo, int importe) {
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("coche.txt")));
			printStream = new PrintStream(
								new FileOutputStream("copiaCoche.txt"));
			Multas miMulta = new Multas(fecha, motivo, importe);
			
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String cocheMatricula = datos[0];
				printStream.println(linea);
				if(cocheMatricula.equals(matricula)) {
					printStream.println("Multa:\t" + miMulta.toString());
					
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada != null) {
				entrada.close();
			}
			if(printStream != null) {
				printStream.close();
			}
		}
		deCopiaACoche();
	}
	// 4. Consultar las sanciones que tiene un veh�culo
	static int cuentaMultas(String matricula) {
		int multas = 0;
		boolean cocheCorrecto = false;
		Scanner entrada = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("coche.txt")));
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String cocheMatricula = datos[0];
				if (cocheCorrecto && cocheMatricula.equals("Multa:")) {
					multas++;
				}
				else
					cocheCorrecto = false;
				
				if(cocheMatricula.equals("1863ary")) {
					cocheCorrecto = true;
				}
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada != null) {
				entrada.close();
			}
			
		}
		return multas;
	}
	// 2. Eliminar un veh�culo: si existen sanciones, debe mostrar el n�mero de las mismas y no realizar la eliminaci�n
	static boolean hayMultas(String matricula) {
		Scanner entrada = null;
		boolean tieneMultas = false;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("coche.txt")));
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String cocheMatricula = datos[0];
				if (tieneMultas && cocheMatricula.equals("Multa:")) {
					return true;
				}
				else
					tieneMultas = false;
				
				if(cocheMatricula.equals(matricula)) {
					if(entrada.hasNext()) {
						tieneMultas = true;
					}
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada != null) {
				entrada.close();
			}
		}
		return tieneMultas;
	}
	static void eliminarVehiculo(String matricula) {
		boolean hayMultas = hayMultas(matricula);
		if (hayMultas) {
			System.out.println("No se puede eliminar ese veh�culo porque tiene " + cuentaMultas(matricula) + " multas.");
		}
		else {
			
			Scanner entrada = null;
			PrintStream printStream = null;
			try {
				entrada = new Scanner(
								new BufferedReader(
										new FileReader("coche.txt")));
				printStream = new PrintStream(
									new FileOutputStream("copiaCoche.txt"));
				while(entrada.hasNext()) {
					String linea = entrada.nextLine();
					String[] datos = linea.split("\t");
					String cocheMatricula = datos[0];
					if(!cocheMatricula.equals(matricula)) {
						printStream.println(linea);
					}
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error");
			}
			finally {
				if(entrada != null) {
					entrada.close();
				}
				if(printStream != null) {
					printStream.close();
				}
			}
			
			deCopiaACoche();
			System.out.println("Opci�n 2 realizada con exito.");
		}
	}
	// 5. Eliminar las sanciones de un veh�culo
	static void eliminarMultas(String matricula){
		if (hayMultas(matricula)) {
			Scanner entrada = null;
			PrintStream printStream = null;
			try {
				boolean cocheCorrecto = false;
				entrada = new Scanner(
								new BufferedReader(
										new FileReader("coche.txt")));
				printStream = new PrintStream(
									new FileOutputStream("copiaCoche.txt"));
				while(entrada.hasNext()) {
					String linea = entrada.nextLine();
					String[] datos = linea.split("\t");
					String cocheMatricula = datos[0];
					
					if (cocheCorrecto) {
						if(!cocheMatricula.equals("Multa:")){
							cocheCorrecto = false;
						}
					}
					if (!cocheCorrecto) {
						printStream.println(linea);
					}
					if(cocheMatricula.equals(matricula)) {
						cocheCorrecto = true;
					}
					
				}
			}catch(FileNotFoundException e) {
				System.out.println("Error");
			}
			finally {
				if(entrada != null) {
					entrada.close();
				}
				if(printStream != null) {
					printStream.close();
				}
			}
			
			deCopiaACoche();
			System.out.println("Opci�n 5 realizada con exito.");
		}else
			System.out.println("No hay multas que eliminar.");
	}
	// 6. Mostrar un listado de los veh�culos para los que la cuant�a de las sanciones es superior a una cantidad determinada (que se debe solicitar)
	static int valorMultas(int cantidad) {
		int contador = 0;
		Scanner entrada = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("coche.txt")));
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String multa = datos[3];
				
				try {
					
					int multaInt = Integer.parseInt(multa);
					if (multaInt > cantidad) {
						contador++;
					}
				}catch(NumberFormatException e) {
				
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada != null) {
				entrada.close();
			}
		}
		return contador;
	}

	static void imprimeMenu() {
		System.out.println("Elija una opci�n:\n\t1:A�adir un veh�culo\n\t2:Eliminar un veh�culo\n\t3:A�adir una sanci�n a un veh�culo\n\t4:Consultar las sanciones de un veh�culo\n\t"
				+ "5:Eliminar las sanciones de un veh�culo\n\t6:Mostrar un listado de los veh�culos para los que la cuant�a de las sanciones es superior a una cantidad\n"
				+ "\t\tdeterminada\n\t7:Terminar el programa");
	}
	static void menu() {
		Scanner teclado = new Scanner (System.in);
		boolean terminar = false;
		imprimeMenu();
		int opcion = teclado.nextInt();
		do{
			
			switch (opcion) {
			case 1:
				annadirVehiculo("7429abc", "Kio Plus", "Ultra", "Marte Lenaz", "05/10/2007");
				System.out.println("Opci�n 1 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 2:
				hayMultas("1863ary");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 3:
				annadirMulta("7429abc", "04/02/2021", "Exceso de velocidad", 250);
				System.out.println("Opci�n 5 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 4:
				cuentaMultas("1863ary");
				System.out.println("Opci�n 4 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 5:
				eliminarMultas("7429abc");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 6:
				System.out.println("Introduzca el valor de la multa:");
				int valor = teclado.nextInt();
				valorMultas(valor);
				System.out.println("Opci�n 7 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 7:
				System.out.println("Programa finalizando. Muchas gracias.");
				terminar = true;
				break;
			default:
				System.out.println("Esa opci�n no existe, por favor escoja una existente.");
				imprimeMenu();
				opcion = teclado.nextInt();
			}	
		}while(!terminar);
	}
	
}
