package exemploLivro;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private Point[] points = new Point[ 1000 ];
	
	ListaEncadeada<Ponto2D> lista = new ListaEncadeada<Ponto2D>();
	CriarArqTexto arquivo = new CriarArqTexto();
	
	
	
	public PaintPanel(){
		addMouseMotionListener( new MouseMotionAdapter(){
			public void mouseDragged( MouseEvent event) {
				//if(pointCount < points.length){
				//lista.inserirFim(event.getPoint());
				lista.inserirFim(new Ponto2D(event.getX(), event.getY()));
				
					repaint();
				
			}
		}); 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		arquivo.openFile();
		
		Iterador<Ponto2D> it = lista.getInicio();
		Ponto2D ponto;
		while((ponto = it.proximo()) != null){
			arquivo.listaArquivo(lista);
			g.fillOval((int)ponto.getX(), (int)ponto.getY(), 4, 4);
		}
		
		arquivo.closeFile();
		
//		for(int i=0; i< pointCount; i++){
//			g.fillOval((int)lista.getInicio().getObject().getX(), (int)lista.getInicio().getObject().getY(), 4, 4);
//		}
	}
}
