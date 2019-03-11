package exercicio_10_1;

import Figuras.Ponto2D;

public class Retangulo {
	private Ponto2D a;
	private Ponto2D b;
	private float comprimento;
	private float altura;
	
	public Retangulo(Ponto2D a, Ponto2D b) {
		this.a = a.clone();
		this.b = b.clone();
		
	}
	public Retangulo() {
		comprimento = 1;
		altura = 1;
	}
	
	public double base() {
		if(a.getX() < b.getX())
		 	return b.getX() - a.getX();
		return a.getY() - b.getY();
	}
	
	 public double altura(){
		 if(a.getY() < b.getY())
			 return b.getY() - a.getY();
		 return a.getY() - b.getY();
		 }
	 public double Area() {
		 return base()*altura();
	 }
	public float getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		if(comprimento > 0.0 && comprimento < 20.0)
			this.comprimento = comprimento;
		else
			this.comprimento = 1;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		if(altura > 0.0 && altura < 20.0)
			this.altura = altura;
		else
			this.altura = 1;
	}
	public String toString() {
		return String.format("Area do Retangulo: %d", Area());
	}
	 
}
