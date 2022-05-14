/*
Ejercicio 1
Vamos a gestionar las multas de los vehículos de un municipio de los que conocemos:
• Matrícula: cadena formada por cuatro números dígitos y tres letras consonantes
Nota: las letras consonantes no incluyen la eñe y la cu.
• Marca
• Modelo
• Propietario
• Año de matriculación
Además, para cada vehículo si las tiene, se guarda la información de las sanciones impuestas al mismo,
conteniendo:
• Fecha
• Motivo
• Importe
Crear un programa que muestre un menú y permita:
1. Añadir un vehículo al municipio
2. Eliminar un vehículo: si existen sanciones, debe mostrar el número de las mismas y no realizar la
eliminación
3. Añadir una sanción a un vehículo
4. Consultar las sanciones que tiene un vehículo
5. Eliminar las sanciones de un vehículo
6. Mostrar un listado de los vehículos para los que la cuantía de las sanciones es superior a una cantidad
determinada (que se debe solicitar)
7. Terminar el programa
Los datos de vehículos deben ser leídos de un fichero al inicio de la ejecución del programa, si dicho fichero
existe. Análogamente, serán almacenados en dicho fichero antes de finalizar el programa que, si no existía,
será creado en ese momento.
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
	// 1. Añadir un vehículo al municipio
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
	// 3. Añadir una sanción a un vehículo
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
	// 4. Consultar las sanciones que tiene un vehículo
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
	// 2. Eliminar un vehículo: si existen sanciones, debe mostrar el número de las mismas y no realizar la eliminación
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
			System.out.println("No se puede eliminar ese vehículo porque tiene " + cuentaMultas(matricula) + " multas.");
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
			System.out.println("Opción 2 realizada con exito.");
		}
	}
	// 5. Eliminar las sanciones de un vehículo
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
			System.out.println("Opción 5 realizada con exito.");
		}else
			System.out.println("No hay multas que eliminar.");
	}
	// 6. Mostrar un listado de los vehículos para los que la cuantía de las sanciones es superior a una cantidad determinada (que se debe solicitar)
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
		System.out.println("Elija una opción:\n\t1:Añadir un vehículo\n\t2:Eliminar un vehículo\n\t3:Añadir una sanción a un vehículo\n\t4:Consultar las sanciones de un vehículo\n\t"
				+ "5:Eliminar las sanciones de un vehículo\n\t6:Mostrar un listado de los vehículos para los que la cuantía de las sanciones es superior a una cantidad\n"
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
				System.out.println("Opción 1 realizada con exito.");
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
				System.out.println("Opción 5 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 4:
				cuentaMultas("1863ary");
				System.out.println("Opción 4 realizada con exito.");
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
				System.out.println("Opción 7 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 7:
				System.out.println("Programa finalizando. Muchas gracias.");
				terminar = true;
				break;
			default:
				System.out.println("Esa opción no existe, por favor escoja una existente.");
				imprimeMenu();
				opcion = teclado.nextInt();
			}	
		}while(!terminar);
	}
	
}
