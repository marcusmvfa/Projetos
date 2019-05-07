package edu.udc.psw.desenho.formas;


import java.awt.Graphics;
import java.nio.ByteBuffer;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorPonto;

public class Ponto implements FormaGeometrica{
	public int x;
	public int y;
	public static final long serialVersionUID = 1L;
	
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Ponto(byte bytes[]){
		if(ByteBuffer.wrap(bytes, 0, 8).getLong() != serialVersionUID){
			x = 0;
			y = 0;
			return;
		}
		x = ByteBuffer.wrap(bytes, 8, 12).getInt();
		y = ByteBuffer.wrap(bytes, 12, 16).getInt();
		
	}
	
	public Ponto clone(){
		return new Ponto(x,y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public static Ponto fabricarPonto(String ponto) {

		if(ponto.startsWith(Ponto.class.getSimpleName())){
			int i = ponto.indexOf(' ');
			int x = Integer.parseInt(ponto.substring(0, i));
			int y = Integer.parseInt(ponto.substring(i + 1, ponto.length() - 1));
			Ponto p = new Ponto(x, y);	
			return p;
		}
		return null;
	}
	public double distancia(Ponto p){
		return Math.sqrt( (x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
	}
	@Override
	public String toString(){
		return String.format("%d %d", x, y);
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.fillOval(x, y, 4, 4);
		
	}
	public static Ponto fabricar(String ponto) {
		if(ponto.startsWith(Ponto.class.getSimpleName())) {
			int i = ponto.indexOf(' ');
			String[] espacos = ponto.split(" ");
			int x = Integer.parseInt(espacos[1]);
//			int x = Integer.parseInt(ponto.substring(0, i));
//			int y = Integer.parseInt(ponto.substring(i+1, ponto.length()-1));
			int y = Integer.parseInt(espacos[2]);
			Ponto p = new Ponto(x, y);
			return p;			
		}
		return null;
	}
//	@Override
//	public FormaGeometrica clone() {
//		return new Ponto(x, y);
//	}
	@Override
	public byte[] toArray() {
		byte[] bytes = new byte[16];
		ByteBuffer.wrap(bytes, 0, 8).putLong(serialVersionUID);
		ByteBuffer.wrap(bytes, 8, 12).putInt(x);
		ByteBuffer.wrap(bytes, 12, 16).putInt(y);
		return bytes;
	}
	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorPonto(this);
	}
	
}
