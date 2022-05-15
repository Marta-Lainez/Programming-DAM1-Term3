/*
Ejercicio 2
Una empresa de ventas desea gestionar el control de viajantes de la misma. Para cada viajante, controla:
� DNI
� Nombre
� Antig�edad
� Distancia recorrida (Km)
� Ventas realizadas
Las ventas contienen la informaci�n siguiente:
� Fecha
� Importe
� Cliente
� Cobrada (seg�n se haya ingresado su importe o no)
Crear un programa que muestre un men� y permita:
1. A�adir un viajante
2. Eliminar un viajante
3. Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de
	las ventas cobradas
4. Inicializar ventas: la distancia recorrida de todos los viajantes pasar� a ser cero y las ventas cobradas
de todos ellos se almacenar�n en el hist�rico, elimin�ndolas (del programa)
5. Incrementar la distancia recorrida por un viajante (deber� pedir el n�mero de kil�metros recorridos)
6. A�adir una venta de un viajante
7. Cobrar una venta de un viajante
8. Mostrar un listado de todas las ventas no cobradas de un viajante
8. Terminar el programa
Los datos de los viajantes deben ser le�dos de un fichero al inicio de la ejecuci�n del programa, si dicho
fichero existe. An�logamente, ser�n almacenados en dicho fichero antes de finalizar el programa que, si no
exist�a, ser� creado en ese momento. Existir�n dos ficheros m�s: de hist�rico de ventas y de ventas; el
programa solo leer�, al inicio, el de ventas, si existe, y almacenar� en el mismo los datos antes de finalizar.
El hist�rico de ventas almacenar� las ventas cobradas hasta el momento de inicializaci�n de ventas (opci�n
4): si no existe, se crear�; si existe, se a�adir�n las ventas al fichero actual.
 */
import java.util.*;
public class Viajante implements Comparable <Viajante>{
	private String dni;
	private String nombre;
	private int antiguedad;
	private int distancia;
	private int numVentas;
	
	public Viajante(String dni, String nombre, int antiguedad, int distancia) {
		this.dni = dni;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.distancia = distancia;
		numVentas = 0;
		//ventas = new ArrayList <Venta>();
	}
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	/*
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	*/
	public int getNumVentas() {
		return numVentas;
	}

	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}
	/*
	public ArrayList <Venta> a�adirVentas(String fecha, int importe, String cliente, boolean cobrada){
		ventas.add(new Venta(fecha, importe, cliente, cobrada));
		return ventas;
	}
	public String imprimeVentas () {
		String devuelve = "";
		for(Venta e: ventas) {
			devuelve += (dni + ":\t" + e.toString());
		}
		return devuelve;
	}
	*/
	public String toString() {
		return dni +"\t" + nombre + "\t" + antiguedad + " a�os\t" + distancia + " km\t" + numVentas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viajante other = (Viajante) obj;
		return Objects.equals(dni, other.dni);
	}
	public int compareTo(Viajante e) {
		
		return dni.compareTo(e.getDni());
	}
	
}
