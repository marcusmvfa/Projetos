package edu.udc.psw.desenho.formas;

import java.awt.Graphics;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorRetangulo;

public class Retangulo implements FormaGeometrica {
	private Ponto a = null;
	private Ponto b = null;
	private Ponto c = null;
	private Ponto d = null;
	
	public Retangulo(){
		a = new Ponto();
		b = new Ponto();
		c = new Ponto();
		d = new Ponto();
	}
	
	public Retangulo(Ponto a, Ponto b){
		this.a = a;
		this.b = b;
	}
	
	public Retangulo(Ponto a, Ponto b, Ponto c, Ponto d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public Retangulo(int ax, int ay, int bx, int by){
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
	}
	
	public Retangulo(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy){
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
		c = new Ponto(cx, cy);
		d = new Ponto(dx, dy);
	}
	
	public Ponto getA(){
		return a;
	}

	public Ponto getB(){
		return b;
	}

	public void setA(Ponto a){
		this.a = a;
	}

	public void setB(Ponto b){
		this.b = b;
	}
	
	public Ponto getC(){
		return c;
	}

	public Ponto getD(){
		return d;
	}

	public void setC(Ponto c){
		this.c = c;
	}

	public void setD(Ponto d){
		this.d = d;
	}
	
	public Ponto centro(){
		return new Ponto((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}
	
	public double base(){
		return Math.abs(a.getX() - b.getX());
	}
	
	public double altura(){
		return Math.abs(a.getY() - b.getY());
	}
	
	public double area(){
		return base() * altura();
	}

	
	public double perimetro() {
		return 2 * base() + 2 * altura();
	}

	
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorRetangulo(this);
	}


	public Retangulo clone() {
		return new Retangulo();
	}

	@Override
	public void desenhar(Graphics g) {
		int xa = 0;
		try {
			xa = (int) this.getA().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int xb = 0;
		try {
			xb = (int) this.getB().getX();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ya = 0;
		try {
			ya = (int) this.getA().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int yb = 0;
		try {
			yb = (int) this.getB().getY();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawRect(xa < xb ? xa : xb, ya < yb ? ya : yb, 
				(int) this.base(), (int) this.altura() );
	
		
	}


	public static FormaGeometrica fabricar(String retangulo) {
		
//		if(retangulo.startsWith(Linha.class.getSimpleName())) {
		if(!retangulo.isEmpty()){
			int i = retangulo.indexOf(' ');
			int x = Integer.parseInt(retangulo.substring(0, i));
			retangulo = retangulo.substring(i + 1);
			i = retangulo.indexOf(' ');
			int y = Integer.parseInt(retangulo.substring(0, i));
			Ponto a = new Ponto(x, y);
			
			retangulo = retangulo.substring(i+1);
			i = retangulo.indexOf(' ');
			x = Integer.parseInt(retangulo.substring(0, i));
			y = Integer.parseInt(retangulo.substring(i +1, retangulo.length()));
			Ponto b = new Ponto(x,y);
			
			return new Retangulo(a, b);
		}
		return null;
//		
//		int xa = 0;
//		try {
//			xa = (int) .getA().getX();
//			a.x = xa;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int xb = 0;
//		try {
//			xb = (int) this.getB().getX();
//			b.x = xb;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int ya = 0;
//		try {
//			ya = (int) this.getA().getY();
//			a.y = ya;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int yb = 0;
//		try {
//			yb = (int) this.getB().getY();
//			b.y = yb;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		g.drawRect(xa < xb ? xa : xb, ya < yb ? ya : yb, 
//				(int) retangulo.base(), (int) retangulo.altura() );
//		
//		return new Retangulo(a, b);
	}

	@Override
	public byte[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString(){
		return String.format("%s %s", a, b);
	}
}

