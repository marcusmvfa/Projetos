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
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.util.Iterator;

public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener   {
	private static final long serialVersionUID = 1L;
	private JLabel status;

	public PainelDesenho(JLabel status) {
		this.status = status;
		
		addMouseListener( this );                          
	    addMouseMotionListener( this );
	    
		// trata evento de movimento de mouse do frame
		addMouseMotionListener(

				new MouseMotionAdapter()// classe interna anônima
				{
					// armazena coordenadas de arrastar e repinta
					public void mouseDragged(MouseEvent event) {
							Aplicacao.getAplicacao().inserir(
									new Ponto(event.getPoint().x, 
											event.getPoint().y) ); // localiza o ponto
							repaint(); // repinta JFrame
					}
				});
	}

	// desenha oval em um quadro delimitador de 4x4 no local especificada na janela
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa a área de desenho

		Iterator<Ponto> it = Aplicacao.getAplicacao().getIterator();
		Ponto ponto;
		while((ponto = it.next()) != null) {
			g.fillOval(ponto.x, ponto.y, 4, 4);
		}
		
//		for(Ponto p : lista)
//			g.fillOval(p.x, p.y, 4, 4);
	}
	
	// Handlers de evento de MouseListener
    // trata evento quando o mouse é liberado logo depois de pressionado
    public void mouseClicked( MouseEvent event )
    {
       status.setText( String.format( "Clicked at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
    }

    // trata evento quando mouse é pressionado
    public void mousePressed( MouseEvent event )
    {
       status.setText( String.format( "Pressed at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
    }

    // trata evento quando mouse é liberado depois da operação de arrastar
    public void mouseReleased( MouseEvent event )
    {
       status.setText( String.format( "Released at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
    }

    // trata evento quando mouse entra na área
    public void mouseEntered( MouseEvent event )
    {
       status.setText( String.format( "Mouse entered at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
       setBackground( Color.GREEN );
    } 

    // trata evento quando mouse sai da área
    public void mouseExited( MouseEvent event )
    {
       status.setText( String.format( "Mouse outside JPanel - Total pontos %d", 
    		   Aplicacao.getAplicacao().getListSize() ) );
       setBackground( Color.WHITE );
    }

    // Handlers de evento de MouseMotionListener
    // trata evento quando usuário arrasta o mouse com o botão pressionado
    public void mouseDragged( MouseEvent event )
    {
       status.setText( String.format( "Dragged at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
    } 

    // trata evento quando usuário move o mouse
    public void mouseMoved( MouseEvent event )
    {
       status.setText( String.format( "Moved at [%d, %d] - Total pontos %d", 
          event.getX(),event.getY(), Aplicacao.getAplicacao().getListSize() ) );
    }
}
