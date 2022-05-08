/*
8) Dise�ar la clase Cuentas para crear un vector de 100 objetos (de la clase CuentaCorriente).
Escribir un programa que utilice la clase Cuentas que permita obtener el titular y c�digo de la
cuenta con mayor saldo. Para ello se sugiere crear un vector de saldos, ordenarlo en orden
creciente y, tomando el �ltimo valor que almacene, compararlo con el saldo de los diferentes
objetos mediante un metodo getSaldo y mostrar por pantalla los que sean iguales que el saldo
m�ximo.
 */
package colecciones;
import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		Set <CuentaCorriente> cuentas = rellenaCuentas(100);
		Set <Float> saldos = rellenaSaldos(cuentas);
	
		
		
		
	}
	
	static Set <CuentaCorriente> rellenaCuentas (int tama�o){
		Set <CuentaCorriente> cuentas = new TreeSet <CuentaCorriente>();
		while (cuentas.size() <= tama�o) {
			cuentas.add(new CuentaCorriente());
		}
		return cuentas;
	}
	
	static Set <Float> rellenaSaldos (Set <CuentaCorriente> cuentas){
		Set <Float> saldos = new TreeSet <Float>();
		Iterator <CuentaCorriente> iterador = cuentas.iterator();
		while (iterador.hasNext()) {
			float saldo = iterador. next().getSaldo();
			saldos.add(saldo);
		}
		return saldos;
	}
}
