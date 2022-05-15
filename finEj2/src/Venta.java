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
3. Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de
	las ventas cobradas
4. Inicializar ventas: la distancia recorrida de todos los viajantes pasará a ser cero y las ventas cobradas
de todos ellos se almacenarán en el histórico, eliminándolas (del programa)
5. Incrementar la distancia recorrida por un viajante (deberá pedir el número de kilómetros recorridos)
6. Añadir una venta de un viajante
7. Cobrar una venta de un viajante
8. Mostrar un listado de todas las ventas no cobradas de un viajante
8. Terminar el programa
Los datos de los viajantes deben ser leídos de un fichero al inicio de la ejecución del programa, si dicho
fichero existe. Análogamente, serán almacenados en dicho fichero antes de finalizar el programa que, si no
existía, será creado en ese momento. Existirán dos ficheros más: de histórico de ventas y de ventas; el
programa solo leerá, al inicio, el de ventas, si existe, y almacenará en el mismo los datos antes de finalizar.
El histórico de ventas almacenará las ventas cobradas hasta el momento de inicialización de ventas (opción
4): si no existe, se creará; si existe, se añadirán las ventas al fichero actual.
 */
public class Venta {
	private String fecha;
	private int importe;
	private String cliente;
	private boolean cobrada;
	public Venta(String fecha, int importe, String cliente, boolean cobrada) {
		this.fecha = fecha;
		this.importe = importe;
		this.cliente = cliente;
		this.cobrada = cobrada;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public boolean isCobrada() {
		return cobrada;
	}
	public void setCobrada(boolean cobrada) {
		this.cobrada = cobrada;
	}
	public String toString() {
		return fecha + "\t" + importe + "\t" + cliente + "\t" + cobrada;
	}
}
