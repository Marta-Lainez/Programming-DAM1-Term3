package listas;

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
