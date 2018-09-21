package Figuras;

public class Linha {
	private Ponto2D a;
	private Ponto2D b;
	
	public Linha(){
	a = new Ponto2D();
	b = new Ponto2D();
	}
	
	public Linha(Ponto2D a, Ponto2D b){
		this.a = a.clone();
		this.b = b.clone();
	}
	public double comprimento() {
		return a.distancia(b);
	}
	public Ponto2D centro() {
		Ponto2D m = new Ponto2D((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
		return m;
	}
	 public double base(){
		 if(a.getX() < b.getX())
		 return b.getX() - a.getX();
		 return a.getX() - b.getX();
		 }
		 
		 public double altura(){
		 if(a.getY() < b.getY())
		 return b.getY() - a.getY();
		 return a.getY() - b.getY();
		 }
}
