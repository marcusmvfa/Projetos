package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica {
	
	public Ponto centro();
	public double area();
	public double perimetro();
	public double base();
	public double altura();
	
	public ManipuladorFormaGeometrica getManipulador();
	
	public FormaGeometrica clone();

}
