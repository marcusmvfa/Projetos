package edu.udc.psw.desenho.formas;

public class Ponto {
	public int x;
	public int y;
	
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public static Ponto fabricarPonto(String ponto) {
		int i = ponto.indexOf(';');
		int x = Integer.parseInt(ponto.substring(1, i));
		int y = Integer.parseInt(ponto.substring(i+1, ponto.length()-1));
		Ponto p = new Ponto(x, y);
		return p;
	}
	@Override
	public String toString(){
		return String.format("%d %d", x, y);
	}
}
