/*
Ejercicio 2
Una empresa de ventas desea gestionar el control de viajantes de la misma. Para cada viajante, controla:
• DNI
• Nombre
• Antigüedad
• Distancia recorrida (Km)
• Ventas realizadas
Las ventas contienen la información siguiente:
• Fecha
• Importe
• Cliente
• Cobrada (según se haya ingresado su importe o no)
Crear un programa que muestre un menú y permita:
1. Añadir un viajante
2. Eliminar un viajante
3. Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de las ventas cobradas
4. Inicializar ventas: la distancia recorrida de todos los viajantes pasará a ser cero y las ventas cobradas
	de todos ellos se almacenarán en el histórico, eliminándolas (del programa)
5. Incrementar la distancia recorrida por un viajante (deberá pedir el número de kilómetros recorridos)
6. Añadir una venta de un viajante
7. Cobrar una venta de un viajante
8. Mostrar un listado de todas las ventas no cobradas de un viajante
9. Terminar el programa
Los datos de los viajantes deben ser leídos de un fichero al inicio de la ejecución del programa, si dicho
fichero existe. Análogamente, serán almacenados en dicho fichero antes de finalizar el programa que, si no
existía, será creado en ese momento. Existirán dos ficheros más: de histórico de ventas y de ventas; el
programa solo leerá, al inicio, el de ventas, si existe, y almacenará en el mismo los datos antes de finalizar.
El histórico de ventas almacenará las ventas cobradas hasta el momento de inicialización de ventas (opción
4): si no existe, se creará; si existe, se añadirán las ventas al fichero actual.
 */
import java.util.*;
import java.io.*;
public class Ej2 {

	public static void main(String[] args) {
		
		Set <Viajante> lista = new TreeSet <Viajante>();
		menu(lista);
	}
	static void imprimeMenu() {
		System.out.println("Elija una opción:\n\t1:Añadir un viajante\n\t2:Eliminar un viajante\n\t3:Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de las ventas cobradas\n\t"
				+ "4:Inicializar ventas: la distancia recorrida de todos los viajantes pasará a ser cero y las ventas cobradas de todos ellos se almacenarán en el histórico, eliminándolas (del programa)\n\t"
				+ "5:Incrementar la distancia recorrida por un viajante (deberá pedir el número de kilómetros recorridos)\n\t6:Añadir una venta de un viajante"
				+ "\n\t7:Cobrar una venta de un viajante\n\t8:Mostrar un listado de todas las ventas no cobradas de un viajante\n\t9:Terminar el programa");
	}
	static void menu(Set <Viajante> lista) {
		Scanner teclado = new Scanner (System.in);
		boolean terminar = false;
		imprimeMenu();
		int opcion = teclado.nextInt();
		do{
			
			switch (opcion) {
			case 1:
				añadirViajante(lista, "1a", "Marisa Lopez", 8, 9);
				System.out.println("Opción 1 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 2:
				eliminarViajante(lista,"1a");
				System.out.println("Opción 2 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
				//MIRAR LA 3
			case 3:
				muestraViajantes();
				System.out.println("Opción 3 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 4:
				inicializarVentas(lista);
				System.out.println("Opción 4 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 5:
				incrementaDistancia(lista,"1a", 2);
				System.out.println("Opción 5 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 6:
				añadirVenta(lista, "1a","01/06/2007", 7000, "Michael");
				System.out.println("Opción 6 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 7:
				cobrarVenta("1a", 1);
				System.out.println("Opción 7 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 8:
				listarVentas("1a");
				System.out.println("Opción 8 realizada con exito.");
				imprimeMenu();
				opcion = teclado.nextInt();
				break;
			case 9:
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
	
	static void deCopiaAOriginal(String copia, String original) {
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader(copia)));
			printStream = new PrintStream(
								new FileOutputStream(original));
		
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
	// 1. Añadir un viajante
	static void añadirViajante(Set <Viajante> lista, String dni, String nombre, int antiguedad, int distancia) {
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(
								new FileOutputStream("viajante.txt"));
			lista.add(new Viajante(dni, nombre, antiguedad, distancia)) ;
			
			for(Viajante e: lista) {
				printStream.println(e.toString());
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}finally {
			if(printStream != null) {
				printStream.close();
			}
		}
	}
	// 2. Eliminar un viajante
	static void eliminarViajante(Set <Viajante> lista,String dni) {
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(
								new FileOutputStream("viajante.txt"));
			Iterator <Viajante> iterador = lista.iterator();
			while(iterador.hasNext()) {
				Viajante viajante = iterador.next();
				String getDni = viajante.getDni();
				if(getDni.equals(dni)) {
					iterador.remove();
				}
				else
					printStream.println(viajante.toString());
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(printStream != null) {
				printStream.close();
			}
		}
	}
	// 3. Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de las ventas cobradas
	static void muestraViajantes() {
		ArrayList <String> lista = new ArrayList <String> ();
		int contador;
		Scanner entrada = null;
		Scanner entrada2 = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("venta.txt")));
			entrada2 = new Scanner(
							new BufferedReader(
									new FileReader("viajante.txt")));
			while(entrada2.hasNext()) {
				String linea = entrada2.nextLine();
				String[] datos = linea.split("\t");
				lista.add(datos[0]);
			}
			
			Iterator <String> iterador = lista.iterator();
			while(iterador.hasNext()) {
				contador = 0;
				String id = iterador.next();
				while(entrada.hasNext()){
					String linea = entrada.nextLine();
					String[] datos = linea.split("\t");
					if (id.equals(datos[0]) && datos[4].equals("true")) {
						contador += Integer.parseInt(datos[2]);
					}
				}
				System.out.println(id + "\t" + contador);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if (entrada != null) {
				entrada.close();
			}
		}
		
	}
	// 4. Inicializar ventas: la distancia recorrida de todos los viajantes pasará a ser cero y las ventas cobradas
	// de todos ellos se almacenarán en el histórico, eliminándolas (del programa)
	static void inicializarVentas(Set <Viajante> lista) {
		deCopiaAOriginal("venta.txt", "historialVentas.txt");
		Scanner entrada1 = null;
		Scanner entrada2 = null;
		PrintStream printStream1 = null;
		PrintStream printStream2 = null;
		PrintStream printStream3 = null;
		try {
			entrada1 = new Scanner(
							new BufferedReader(
									new FileReader("venta.txt")));
			entrada2 = new Scanner(
							new BufferedReader(
									new FileReader("viajante.txt")));

			printStream1 = new PrintStream(
								new FileOutputStream("historialVentas.txt"));
			printStream2 = new PrintStream(
					new FileOutputStream("copiaVentas.txt"));
			printStream3 = new PrintStream(
					new FileOutputStream("copiaViajante.txt"));
				
			while(entrada1.hasNext()) {
				String linea = entrada1.nextLine();
				String[] datos = linea.split("\t");
				String estadoCompra = datos[4];
				if(estadoCompra.equals("true")) {
					printStream1.println(linea);
				}
				else {
					printStream2.println(linea);
				}
			}
			deCopiaAOriginal("copiaVentas.txt", "venta.txt");
				
			Iterator <Viajante> iterador = lista.iterator();
			while(iterador.hasNext()) {
				Viajante viajante = iterador.next();
				viajante.setDistancia(0);
			}
			while(entrada2.hasNext()) {
				String linea = entrada2.nextLine();
				String[] datos = linea.split("\t");
				datos[3] = "0 km";
				printStream3.println(datos[0] + "\t" +datos[1] + "\t" +datos[2] + "\t" +datos[3] + "\t" +datos[4]);
			}
			deCopiaAOriginal("copiaViajante.txt", "viajante.txt");
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(entrada1 != null) {
				entrada1.close();
			}
			if(entrada2 != null) {
				entrada2.close();
			}
			if(printStream1 != null) {
				printStream1.close();
			}
			if(printStream2 != null) {
				printStream2.close();
			}
		}
	}
	// 5. Incrementar la distancia recorrida por un viajante (deberá pedir el número de kilómetros recorridos)
	static void incrementaDistancia(Set <Viajante> lista, String dni, int distancia) {
		PrintStream printStream = null;
		Scanner entrada = null;
		try {
			entrada = new Scanner(
					new BufferedReader(
							new FileReader("viajante.txt")));
			printStream = new PrintStream(
								new FileOutputStream("copiaViajante.txt"));
			Iterator <Viajante> iterador = lista.iterator();
			while(iterador.hasNext()) {
				Viajante viajante = iterador.next();
				if(viajante.getDni().equals(dni)) {
					viajante.setDistancia(distancia);
				}
			}
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String id = datos[0];
				if(id.equals(dni)) {
					datos[3] = distancia + " km";
				}
				printStream.println(datos[0] + "\t" +datos[1] + "\t" +datos[2] + "\t" +datos[3] + "\t" +datos[4]);
			}
			deCopiaAOriginal("copiaViajante.txt", "viajante.txt");

		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}finally {
			if(printStream != null) {
				printStream.close();
			}
			if(entrada != null) {
				entrada.close();
			}
		}
		
	}
	// 6. Añadir una venta de un viajante
	static void añadirVenta(Set <Viajante> lista, String dni,String fecha, int importe, String cliente) {
		PrintStream printStream = null;
		PrintStream printStream2 = null;
		try {
			printStream = new PrintStream(
								new FileOutputStream("viajante.txt"));
			printStream2 = new PrintStream(
								new FileOutputStream("venta.txt", true));
			// new Venta("01/06/2007", 7000, "Michael", false);
			Iterator <Viajante> iterador = lista.iterator();
			while(iterador.hasNext()) {
				Viajante viajante = iterador.next();
				String getDni = viajante.getDni();
				if(getDni.equals(dni)) {
					Venta venta = new Venta(fecha, importe, cliente, false);
					viajante.setNumVentas(viajante.getNumVentas() + 1);
					printStream2.println(viajante.getDni() + "\t" + venta.toString());
				}
				
			}
			for(Viajante e: lista) {
				printStream.println(e.toString());
			}
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Error");
		}
		finally {
			if(printStream != null) {
				printStream.close();
			}
			if(printStream2 != null) {
				printStream2.close();
			}
		}
	}
	// 7. Cobrar una venta de un viajante
	static void cobrarVenta(String dni, int posicion) {
		int contador = 0;
		Scanner entrada = null;
		PrintStream printStream = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("venta.txt")));
			printStream = new PrintStream(
								new FileOutputStream("copiaVentas.txt"));
		
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String datoDni = datos[0];
				if(datoDni.equals(dni)) {
					contador++;
					if(contador == posicion) {
						datos[4] = "true";
						printStream.println(datos[0] + "\t" + datos[1] + "\t" + datos[2] + "\t" + datos[3] + "\t" + datos[4]);
					}
					else
						printStream.println(linea);
				}
				else
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
		deCopiaAOriginal("copiaVentas.txt", "venta.txt");
	}
	// 8. Mostrar un listado de todas las ventas no cobradas de un viajante
	static void listarVentas(String dni) {
		Scanner entrada = null;
		try {
			entrada = new Scanner(
							new BufferedReader(
									new FileReader("venta.txt")));
			while(entrada.hasNext()) {
				String linea = entrada.nextLine();
				String[] datos = linea.split("\t");
				String datoDni = datos[0];
				String estado = datos[4];
				if(datoDni.equals(dni) && estado.equals("false")) {
					System.out.println(linea);
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
	}
	
}
