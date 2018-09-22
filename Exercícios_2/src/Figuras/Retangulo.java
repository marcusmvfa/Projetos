package Figuras;


public class Retangulo extends Paralelogramo{
	private Ponto2D a;
	private Ponto2D b;
	private float comprimento;
	private float largura;
	
	public Retangulo(Ponto2D a, Ponto2D b) {
		this.a = a.clone();
		this.b = b.clone();
		
	}
	public Retangulo() {
		comprimento = 1;
		largura = 1;
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
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		if(largura > 0.0 && largura < 20.0)
			this.largura = largura;
		else
			this.largura = 1;
	}
	public String toString() {
		return String.format("Area do Retangulo: %d", Area());
	}
	 
}
