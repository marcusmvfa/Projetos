package edu.udc.psw.desenho.formas;

import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorLinha;

import java.awt.Graphics;
import java.nio.ByteBuffer;

import edu.udc.psw.desenho.formas.Ponto;

public class Linha implements FormaGeometrica {
	private Ponto a;
	private Ponto b;
	long serialVersionUID = 0;
	
	public Linha(){
		a = new Ponto();
		b = new Ponto();
	}

	public Linha(Ponto a, Ponto b) {
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Linha(int ax, int ay, int bx, int by){
		a = new Ponto(ax, ay);
		b = new Ponto(bx, by);
	}
	
	
	public Linha(byte bytes[]){
		if(ByteBuffer.wrap(bytes, 0, 8).getLong() != serialVersionUID){
			a.x = 0;
			a.y = 0;
			b.x = 0;
			b.y = 0;
			return;
		}
		a.x = ByteBuffer.wrap(bytes, 8, 12).getInt();
		a.y = ByteBuffer.wrap(bytes, 12, 16).getInt();
		b.x = ByteBuffer.wrap(bytes, 16, 20).getInt();
		b.y = ByteBuffer.wrap(bytes, 20, 24).getInt();
		
	}
	public byte[] toArray() {
		byte[] bytes = new byte[16];
		
		ByteBuffer.wrap(bytes, 0, 8).putLong(serialVersionUID);
		ByteBuffer.wrap(bytes, 8, 12).putInt(a.x);
		ByteBuffer.wrap(bytes, 12, 16).putInt(a.y);
		ByteBuffer.wrap(bytes, 16, 20).putInt(b.x);
		ByteBuffer.wrap(bytes, 20, 24).putInt(b.y);
		
		return bytes;
	}
	
	
	@Override
	public Linha clone() {
		return new Linha(a.clone(), b.clone());
	}

	public double comprimento(){
		return a.distancia(b);
	}
	
	public Ponto centro(){
		Ponto m = new Ponto((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
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
	
	public Ponto getA() {
		return a.clone();
	}

	public Ponto getB() {
		return b.clone();
	}

	public void setA(Ponto a) {
		this.a = a.clone();
	}

	public void setB(Ponto b)  {
		this.b = b.clone();
	}

	@Override
	public String toString(){
//		return a.toString() + b.toString();
		return String.format("%s %s", a, b);
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawLine(a.x, a.y, b.x, b.y);
		
	}
	
	public static Linha fabricarLinha(String linha) {
		if(linha.startsWith(Linha.class.getSimpleName())) {
			int i = linha.indexOf(' ');
			int x = Integer.parseInt(linha.substring(0, i));
			linha = linha.substring(i + 1);
			i = linha.indexOf(' ');
			int y = Integer.parseInt(linha.substring(0, i));
			Ponto a = new Ponto(x, y);
			
			linha = linha.substring(i+1);
			i = linha.indexOf(' ');
			x = Integer.parseInt(linha.substring(0, i));
			y = Integer.parseInt(linha.substring(i +1, linha.length() - 1));
			Ponto b = new Ponto(x,y);
			
			return new Linha(a, b);
		}
		return null;
		
	}

	public static FormaGeometrica fabricar(String linha) {
		if(!linha.isEmpty()){
			int i = linha.indexOf(' ');
			int x = Integer.parseInt(linha.substring(0, i));
			linha = linha.substring(i + 1);
			i = linha.indexOf(' ');
			int y = Integer.parseInt(linha.substring(0, i));
			Ponto a = new Ponto(x, y);
			
			linha = linha.substring(i+1);
			i = linha.indexOf(' ');
			x = Integer.parseInt(linha.substring(0, i));
			linha = linha.substring(i+1);
			i = linha.indexOf(' ');
			y = Integer.parseInt(linha.substring(0, linha.length()));
//			y = Integer.parseInt(linha.substring(i +1, linha.indexOf(' ')));
			Ponto b = new Ponto(x,y);
			
			return new Linha(a, b);
		}
			
//		if(linha.startsWith(Linha.class.getSimpleName())) {
//			int i = linha.indexOf(' ');
//			int x = Integer.parseInt(linha.substring(0, i));
//			linha = linha.substring(i + 1);
//			i = linha.indexOf(' ');
//			int y = Integer.parseInt(linha.substring(0, i));
//			Ponto a = new Ponto(x, y);
//			
//			linha = linha.substring(i+1);
//			i = linha.indexOf(' ');
//			x = Integer.parseInt(linha.substring(0, i));
//			y = Integer.parseInt(linha.substring(i +1, linha.length() - 1));
//			Ponto b = new Ponto(x,y);
//			
//			return new Linha(a, b);
//		}
		return null;
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		// TODO Auto-generated method stub
		return null;
	}

}
