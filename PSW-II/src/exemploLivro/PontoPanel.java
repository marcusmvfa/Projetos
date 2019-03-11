package exemploLivro;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class PontoPanel{
	private JTextField coordX;
	private JTextField coordY;
	public PontoPanel() {
		
		
		JLabel lblPonto = new JLabel("Ponto: ( x, y )");
		lblPonto.setBounds(10, 11, 76, 14);
		//add(lblPonto);
		
		coordX = new JTextField();
		coordX.setBounds(20, 30, 46, 20);
		//add(coordX);
		coordX.setColumns(10);
		
		coordY = new JTextField();
		coordY.setColumns(10);
		coordY.setBounds(76, 30, 46, 20);
		//add(coordY);
		
		
	}
	
	//public Ponto2D entrarPonto(Ponto2D ponto) {
	public Ponto2D entrarPonto() {
		Ponto2D ponto = new Ponto2D();
		double x = Double.parseDouble(coordX.getText());
		double y = Double.parseDouble(coordY.getText());
		String aux = null;
		ponto.setX(x);
		ponto.setY(y);
		
		return ponto;
	}
}
