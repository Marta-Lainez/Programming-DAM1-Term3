/**
8) Diseñar la clase Cuentas para crear un vector de 100 objetos (de la clase CuentaCorriente).
Escribir un programa que utilice la clase Cuentas que permita obtener el titular y código de la
cuenta con mayor saldo. Para ello se sugiere crear un vector de saldos, ordenarlo en orden
creciente y, tomando el último valor que almacene, compararlo con el saldo de los diferentes
objetos mediante un metodo getSaldo y mostrar por pantalla los que sean iguales que el saldo
máximo.
 */


import java.util.Objects;
import java.util.Scanner;

public class CuentaCorriente implements Comparable <CuentaCorriente>{
	Scanner teclado = new Scanner(System.in);
	private String titular;
	private float saldo;
	final private int codigo;

	
	public CuentaCorriente() {
		titular = "Titular";
		saldo = (int)(Math.random()*1000)+1;
		codigo = (int)(Math.random()*999999)+1;
		
	}
	// Setters y getters de todos los atributos
	public void setTitular(String newTitular) {
		this.titular = newTitular;
	}

	public String getTitular() {
		return titular;
	}

	public void setSaldo(float newSaldo) {
		this.saldo = newSaldo;
	}

	public float getSaldo() {
		return saldo;
	}

	public int getCodigo() {
		return codigo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CuentaCorriente))
			return false;
		CuentaCorriente other = (CuentaCorriente) obj;
		return codigo == other.codigo;
	}
	public int compareTo(CuentaCorriente e) {
		
		return codigo-e.codigo;
	}
	

}