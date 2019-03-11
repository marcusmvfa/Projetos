package exercicio_10_1;

import Figuras.Ponto2D;

public class Triangulo {
	Ponto2D a = new Ponto2D();
	Ponto2D b = new Ponto2D();
	Ponto2D c = new Ponto2D();
	private float base;
	private float altura;
	
	public double meio;
	public double distB_C;
	
	public double baseTriangulo() {
		return (a.getX() - b.getX());
	}
	public double alturaTriangulo() {

		meio = (baseTriangulo() / 2);
		distB_C = b.distancia(c);
		
		return Math.sqrt((meio * meio) + (distB_C * distB_C));
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
}
