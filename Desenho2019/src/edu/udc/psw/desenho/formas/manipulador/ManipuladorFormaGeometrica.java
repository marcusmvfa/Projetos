package edu.udc.psw.desenho.formas.manipulador;

import java.awt.Graphics;

public interface ManipuladorFormaGeometrica {
	void click(int x, int y);
	void press(int x, int y);
	void release(int x, int y);
	void drag(int x, int y);
	
	public String toString();
	public void paint(Graphics g);
}
