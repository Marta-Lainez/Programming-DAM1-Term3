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
public class Multas {
	private String fecha;
	private String motivo;
	private int importe;
	public Multas(String fecha, String motivo, int importe) {
		
		this.fecha = fecha;
		this.motivo = motivo;
		this.importe = importe;
		
	}
	public String toString() {
		return fecha + "\t" + motivo + "\t" + importe;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	
}
