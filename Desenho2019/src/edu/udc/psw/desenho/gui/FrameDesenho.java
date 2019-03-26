package edu.udc.psw.desenho.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.udc.psw.desenho.Aplicacao;
import edu.udc.psw.desenho.persistencia.ArquivoTexto;

public class FrameDesenho extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private PainelDesenho painel;
	private JLabel status;

	public FrameDesenho() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setMnemonic('S');
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = escolherArquivo(true);
				if(f == null)
					return;
				salvarFormas(f);
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmLer = new JMenuItem("Ler");
		mntmLer.setMnemonic('L');
		mntmLer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = escolherArquivo(false);
				if(f == null)
					return;
				lerFormas(f);
			}
		});
		mnArquivo.add(mntmLer);
		
		setLayout(new BorderLayout(5, 5)); // configura o layout de frame
		
		textArea = new JTextArea(15, 5);
		textArea.setText("Texto");
		add(textArea, BorderLayout.WEST);
	
		status = new JLabel("linha de mensagem");
		add(status, BorderLayout.SOUTH);

		painel = new PainelDesenho(status);
		add(painel, BorderLayout.CENTER);
		
	}
	
	private File escolherArquivo(boolean gravar) {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.home"))); //Retorna o diretrório raiz do usuário

		FileNameExtensionFilter textFilterT = new FileNameExtensionFilter("Text file", "txt");//Os tipos de arquivos(.docx .odt  ...)
		fc.addChoosableFileFilter(textFilterT);
		
		fc.setFileFilter(textFilterT);

		int result = gravar ? fc.showSaveDialog(null) : fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}
	
	public void salvarFormas(File file) {
		ArquivoTexto arq = new ArquivoTexto(file);

		//String name = file.getName();
		//String ext = name.substring(name.lastIndexOf('.') + 1);

		arq.salvarFormas(Aplicacao.getAplicacao().getIterator());
	}

	// Metodo ContextInterface da classe Context no padrão Strategy
	public void lerFormas(File file) {
		ArquivoTexto arq = new ArquivoTexto(file);

		String name = file.getName();
		String ext = name.substring(name.lastIndexOf('.') + 1);

		//listaFormas = arq.lerFormas();
		arq.lerFormas();

//		atualizaViews();
	}
}
