/*
Esta clase crea un numero entero aleatorio entre 0 y 99 incluidos. (0 , 99)
 */


public class NumAleatorio {
	private int numAleatorio;
	
	public NumAleatorio() {
		numAleatorio = (int)(Math.random()*100) + 1;
	}
	
	public int getNum() {
		return numAleatorio;
	}
	public void setNum(int newNumAleatorio) {
		this.numAleatorio = newNumAleatorio;
	}
}
