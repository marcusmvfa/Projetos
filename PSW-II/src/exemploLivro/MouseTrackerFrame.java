package exemploLivro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
	private JMenuBar menuBar;
	private JMenuItem mntmSalvar;
	private JMenuItem menuEntrarPonto;
	
	
	//construtor MouseTrackerFrame configura GUI e 
	//registra handlers de evento de mouse
	public MouseTrackerFrame(){
		super("Demonstrating Mouse Events");
		
		mousePanel = new PaintPanel();
		mousePanel.setBackground(Color.WHITE);
		getContentPane().add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside JPanel");
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		/*pontoPanel = new PontoPanel();
		pontoPanel.setBackground(Color.WHITE);
		getContentPane().add(pontoPanel, BorderLayout.WEST);*/
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("Opcoes");
		setJMenuBar(menuBar);
		
		mntmSalvar = new JMenuItem("Salvar");
		menuBar.add(mntmSalvar);
		
		menuEntrarPonto = new JMenuItem("Entrar Ponto");
		menuBar.add(menuEntrarPonto);
		
		menuEntrarPonto.addActionListener(
				new ActionListener () 
				{
					public void actionPerformed(ActionEvent event) {
						//JOptionPane.showMessageDialog(MouseTrackerFrame.this, "Vuc vuc", "Cliquei", JOptionPane.PLAIN_MESSAGE);
						double x = Double.parseDouble(JOptionPane.showInputDialog("Entre com a coordenada X:"));
						double y = Double.parseDouble(JOptionPane.showInputDialog("Entre com a coordenada Y:"));
						Ponto2D ponto = new Ponto2D(x,y);
						
					}
			
		});
		
		
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
	

