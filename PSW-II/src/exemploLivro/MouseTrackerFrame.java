package exemploLivro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import exemploLivro.MouseDetailsFrame.MouseClickHandler;

public class MouseTrackerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mousePanel; //Painel em que os eventos de mouse ocorrerão
	private JPanel pontoPanel;
	private JLabel statusBar;  //Rótulo que exibe informações de evento
	ListaEncadeada<Ponto2D> lista = new ListaEncadeada<Ponto2D>();
	private String details;
	
	
	//construtor MouseTrackerFrame configura GUI e 
	//registra handlers de evento de mouse
	public MouseTrackerFrame(){
		super("Demonstrating Mouse Events");
		
		mousePanel = new PaintPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside JPanel");
		add(statusBar, BorderLayout.SOUTH);
		
		pontoPanel = new PontoPanel();
		pontoPanel.setBackground(Color.WHITE);
		add(pontoPanel, BorderLayout.WEST);
		
		MouseHandler handler = new MouseHandler();
//		addMouseListener(handler);
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	private class MouseHandler extends MouseAdapter implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent event){
			statusBar.setText(String.format("Clicked at [%d, %d",event.getX(),event.getY()));
			
			int x = event.getX();
			int y = event.getY();
			
			details = String.format("Clicked %d time(s)", event.getClickCount());
			
			if(event.isMetaDown() ) //botao direito
//				details += "with right mouse button";
				details += "clicado: ";
			else if( event.isAltDown() ) // botao do meio
				details += "with center button";
			else
				details += "with left button";
			
			statusBar.setText(details);
		}
		public void mousePressed(MouseEvent event){
			statusBar.setText(String.format("Pressed at [%d, %d",event.getX(),event.getY()));
		}
		public void mouseReleased(MouseEvent event){
			statusBar.setText(String.format("Released at [%d, %d",event.getX(),event.getY()));
		}
		public void mouseEntered(MouseEvent event){
			statusBar.setText(String.format("Entered at [%d, %d",event.getX(),event.getY()));
			mousePanel.setBackground(Color.GREEN);
		}
		public void mouseExited(MouseEvent event){
			statusBar.setText("Mouse outside JPanel");
			mousePanel.setBackground(Color.WHITE);
		}
		public void mouseDragged(MouseEvent event, ListaEncadeada<Ponto2D> lista){
			statusBar.setText(String.format("Dragged at [%d , %d] | %d",event.getX(),event.getY(),event.getClickCount()));
			
			
			
//			lista.inserirFim(new Ponto2D(event.getX(),event.getY()));
//				pointCount = lista.getTamanho();
//				pointCount++;
				
			}
		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
		public void mouseMoved(MouseEvent event){
			statusBar.setText(String.format("Moved at [%d, %d",event.getX(),event.getY()));
		}
	}
	

