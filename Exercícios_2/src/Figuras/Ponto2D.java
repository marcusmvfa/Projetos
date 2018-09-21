package Figuras;


public class Ponto2D {
	public double x;
	public double y;
	
	public Ponto2D() {
		this.x = 0.0;
		this.y = 0.0;
	}
	public Ponto2D(double a, double b) {
		this.x = a;
		this.y = b;
	}
	@Override
	public Ponto2D clone() {
		// TODO Auto-generated method stub
		return new Ponto2D(x,y);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double distancia(Ponto2D p){
		 return Math.sqrt( (x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
		 }
}
