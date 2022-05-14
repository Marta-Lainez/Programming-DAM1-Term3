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
