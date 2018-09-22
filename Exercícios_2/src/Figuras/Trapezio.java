package Figuras;

public class Trapezio extends Quadrilatero{
	Ponto2D a = new Ponto2D(1,1);
	Ponto2D b = new Ponto2D(6,1);
	Ponto2D c = new Ponto2D(4,5);
	Ponto2D d = new Ponto2D(2,5);
	
	Trapezio(Ponto2D a, Ponto2D b, Ponto2D c, Ponto2D d){
		this.a = a.clone();
		this.b = b.clone();
		this.c = c.clone();
		this.d = d.clone();
	}
	
	public double BaseMaior() {
		if(a.getX() < b.getX())
			return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()));
		return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()));
	}
	
	public double BaseMenor() {
		if(c.getX() < d.getX())
			return Math.sqrt((d.getX() - c.getX()) * (d.getX() - c.getX()));
		return Math.sqrt((c.getX() - d.getX()) * (c.getX() - d.getX()));
	}
	
	public double Altura() {
		if(a.getY() < b.getY())
			return Math.sqrt((b.getY() - a.getY()) * (b.getY() - a.getY()));
		return Math.sqrt((a.getY() - b.getY()) * (a.getY() - b.getY()));
	}
	
	public double Area() {
		return ((BaseMaior() + BaseMenor()) * Altura()) / 2;
	}
	
	public String toString() {
		return String.format("Area do Trapezio: %d", Area());
	}
}
