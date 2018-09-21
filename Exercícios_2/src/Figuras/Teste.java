package Figuras;

public class Teste {

	public static void main(String[] args) {
		Ponto2D a = new Ponto2D(1.0,1.0);
		Ponto2D b = new Ponto2D(3.0,4.0);
		Retangulo r = new Retangulo(a,b);
		Linha l = new Linha(a, b);
		
		System.out.println("Comprimento: " + l.base());
		/*double bse;
		bse = r.base();*/
		System.out.println("base: " + r.Area());
	}

}
