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
public class Coches {
	private String matricula;
	private String marca;
	private String modelo;
	private String propietario;
	private String annoMatricula;
	public Coches(String matricula, String marca, String modelo, String propietario, String annoMatricula) {
		
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = propietario;
		this.annoMatricula = annoMatricula;
		
	}
	public String toString() {
		return matricula + "\t" + marca + "\t" + modelo + "\t" + propietario + "\t" + annoMatricula;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public String getAnnoMatricula() {
		return annoMatricula;
	}
	public void setAnnoMatricula(String annoMatricula) {
		this.annoMatricula = annoMatricula;
	}
	
}
