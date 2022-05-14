/*
6) Escribe un programa que utilice la clase Empleado, creando un vector de objetos de la clase
Empleado y luego lo llene con datos correspondientes a 50 empleados (utilizar una tabla de
nombres para rellenar con un random). Una vez rellenado, visualizar los datos de todos los
empleados
 */


public class Empleado {
	private String nombre;
	private int numero;
	
	public Empleado(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
	}
	// Getter y Setter de nombre
	public String getNombre() {
		return nombre;
	}
	// Getter y Setter de numero
	public int getNumero() {
		return numero;
	}

	public String toString() {
		return "Nombre del empleado: " + getNombre() + "\tNumero del empleado: " + getNumero();
	}
}
