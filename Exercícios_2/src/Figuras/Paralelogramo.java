package Figuras;

public class Paralelogramo extends Quadrilatero{
	Ponto2D a = new Ponto2D(1,1);
	Ponto2D b = new Ponto2D(6,1);
	
	private double comprimento;
	private double largura;
	private double lado1;
	private double lado2;
	private double lado3;
	private double lado4;
	
	Paralelogramo(Ponto2D a, Ponto2D b){
		this.a = a.clone();
		this.b = b.clone();

	}
	Paralelogramo(){
		comprimento = 1;
		largura = 1;
	}
	public double getLado1() {
		return lado1;
	}
	public void setLado1(double lado1) {
		if(a.getX() < b.getX())
			lado1 = b.getX() - a.getX();
		else
			lado1= a.getX() - b.getX();
		
		this.lado1 = lado1;
	}
	public double getLado2() {
		return lado2;
	}
	public void setLado2(double lado2) {
		if(a.getY() < b.getY())
			lado2 = b.getY() - a.getY();
		else
			lado2= a.getY() - b.getY();
		this.lado2 = lado2;
	}
	public double getLado3() {
		return lado3;
	}
	public void setLado3(double lado1) {
		this.lado3 = lado1;
	}
	public double getLado4() {
		return lado4;
	}
	public void setLado4(double lado2) {
		this.lado4 = lado2;
	}
	
	public double Area() {
		return Base()*Altura();
	}
	public double Base() {
		return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()));
	}
	public double Altura() {
		return Math.sqrt((a.getY() - b.getY()) * (a.getY() - b.getY()));
	}
	public String toString() {
		return String.format("Area do Paralelogramo: %d", Area());
	}
}
