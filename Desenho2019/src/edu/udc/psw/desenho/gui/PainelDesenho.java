package edu.udc.psw.desenho.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.udc.psw.desenho.Aplicacao;
import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.Circulo;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.formas.Linha;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.formas.Retangulo;
import edu.udc.psw.desenho.formas.Triangulo;
import edu.udc.psw.desenho.formas.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.util.Iterator;

public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener, PainelOuvinteFormas   {
	private static final long serialVersionUID = 1L;
	private JLabel status;

	private Documento doc;
	
	private FormaGeometrica novaForma;
	private ManipuladorFormaGeometrica manipulador;
	
	public PainelDesenho(JLabel status, Documento doc) {
		this.status = status;
		this.doc = doc;
		
		this.novaForma = null;
		
		addMouseListener( this );                          
	    addMouseMotionListener( this );
	    
		// trata evento de movimento de mouse do frame
//		addMouseMotionListener(
//
//				new MouseMotionAdapter()// classe interna anônima
//				{
//					// armazena coordenadas de arrastar e repinta
//					public void mouseDragged(MouseEvent event) {
//						if(novaForma == null)
//							return;
//						if(novaForma.getClass().equals(Ponto.class))
//							doc.inserir(new Ponto(event.getPoint().x, event.getPoint().y) ); // localiza o ponto
//							formasAlteradas(); // repinta JFrame
//					}
//				});
	}
	
	public void formasAlteradas() {
		repaint();
	}

	// desenha oval em um quadro delimitador de 4x4 no local especificada na janela
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa a área de desenho

		Iterator<FormaGeometrica> it = doc.getIterator();
		FormaGeometrica formas;
		//Ponto ponto;
		while((formas = it.next()) != null) {
			formas.desenhar(g);
			//g.fillOval(formas.x, formas.y, 4, 4);
		}
		if(novaForma != null){
			novaForma.desenhar(g);
		}
		formasAlteradas();
		
//		for(Ponto p : lista)
//			g.fillOval(p.x, p.y, 4, 4);
	}
	
	public void novaForma(FormaGeometrica forma) {
		this.novaForma = forma;
		this.manipulador = forma.getManipulador();
	}
	
	// Handlers de evento de MouseListener
    // trata evento quando o mouse é liberado logo depois de pressionado
    public void mouseClicked( MouseEvent event )
    {
    	if(novaForma != null){
    		if(novaForma.getClass().equals(Ponto.class)){
    			Ponto p = (Ponto) novaForma;
    			p.setX(event.getPoint().x);
    			p.setY(event.getPoint().y);
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Linha.class)){
    			Linha l = (Linha) novaForma;
    			l.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			l.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Retangulo.class)){
    			Retangulo r = (Retangulo) novaForma;
    			r.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Triangulo.class)){
//    			Triangulo t = (Triangulo) novaForma;
//    			t.setA(new Ponto(event.getPoint().x, event.getPoint().y));
//    			t.setB(new Ponto(event.getPoint().x, event.getPoint().y));
//    			doc.inserir(novaForma);
//    			
//    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Circulo.class)){
    			Circulo c = (Circulo) novaForma;
    			c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		
    	}
       status.setText( String.format( "Clicked at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
    }

    // trata evento quando mouse é pressionado
    public void mousePressed( MouseEvent event )
    {
    	if(novaForma != null){
    		if(novaForma.getClass().equals(Ponto.class)){
    			Ponto p = (Ponto) novaForma;
    			p.setX(event.getPoint().x);
    			p.setY(event.getPoint().y);
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Linha.class)){
    			Linha l = (Linha) novaForma;
    			l.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			l.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Retangulo.class)){
    			Retangulo r = (Retangulo) novaForma;
    			r.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Triangulo.class)){
//    			Triangulo t = (Triangulo) novaForma;
//    			t.setA(new Ponto(event.getPoint().x, event.getPoint().y));
//    			t.setB(new Ponto(event.getPoint().x, event.getPoint().y));
////    			t.setC(new Ponto(event.getPoint().x, event.getPoint().y));
//    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Circulo.class)){
    			Circulo c = (Circulo) novaForma;
    			c.setA(new Ponto(event.getPoint().x, event.getPoint().y));
    			c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		
    	}
       status.setText( String.format( "Pressed at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
    }

    // trata evento quando mouse é liberado depois da operação de arrastar
    public void mouseReleased( MouseEvent event )
    {
    	if(novaForma != null){
    		if(novaForma.getClass().equals(Ponto.class)){
    			Ponto p = (Ponto) novaForma;
    			p.setX(event.getPoint().x);
    			p.setY(event.getPoint().y);
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Linha.class)){
    			Linha l = (Linha) novaForma;
    			l.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Retangulo.class)){
    			Retangulo r = (Retangulo) novaForma;
    			r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Triangulo.class)){
//    			Triangulo t = (Triangulo) novaForma;
//    			t.setB(new Ponto(event.getPoint().x, event.getPoint().y));
//    			doc.inserir(novaForma);
//    			
//    			novaForma = null;
    		}
    		else if(novaForma.getClass().equals(Circulo.class)){
    			Circulo c = (Circulo) novaForma;
    			c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			doc.inserir(novaForma);
    			
    			novaForma = null;
    		}
    		
    	}
       status.setText( String.format( "Released at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
    }

    // trata evento quando mouse entra na área
    public void mouseEntered( MouseEvent event )
    {
       status.setText( String.format( "Mouse entered at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
       setBackground( Color.GREEN );
    } 

    // trata evento quando mouse sai da área
    public void mouseExited( MouseEvent event )
    {
       status.setText( String.format( "Mouse outside JPanel - Total pontos %d", 
    		   doc.getListSize() ) );
       setBackground( Color.WHITE );
    }

    // Handlers de evento de MouseMotionListener
    // trata evento quando usuário arrasta o mouse com o botão pressionado
    public void mouseDragged( MouseEvent event )
    {
    	if(novaForma != null){
    		if(novaForma.getClass().equals(Ponto.class)){
    			Ponto p = (Ponto) novaForma;
    			p.setX(event.getPoint().x);
    			p.setY(event.getPoint().y);
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Linha.class)){
    			Linha l = (Linha) novaForma;
    			l.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Retangulo.class)){
    			Retangulo r = (Retangulo) novaForma;
    			r.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		else if(novaForma.getClass().equals(Triangulo.class)){
    			
    		}
    		else if(novaForma.getClass().equals(Circulo.class)){
    			Circulo c = (Circulo) novaForma;
    			c.setB(new Ponto(event.getPoint().x, event.getPoint().y));
    			formasAlteradas();
    		}
    		
    	}
       status.setText( String.format( "Dragged at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
    } 

    // trata evento quando usuário move o mouse
    public void mouseMoved( MouseEvent event )
    {
       status.setText( String.format( "Moved at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), doc.getListSize() ) );
    }

	@Override
	public void novaFormaGeometrica(FormaGeometrica forma) {
		doc.inserir(forma);
		
	}
}
