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
import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.Circulo;
import edu.udc.psw.desenho.formas.Linha;
import edu.udc.psw.desenho.formas.Ponto;
import edu.udc.psw.desenho.formas.Retangulo;
import edu.udc.psw.desenho.formas.Triangulo;
import edu.udc.psw.desenho.persistencia.ArquivoTexto;

public class FrameDesenho extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private PainelTexto textArea;
	//private PainelOuvinteFormas textArea;
	private PainelDesenho painel;
	private JLabel status;
	
	Documento doc;

	public FrameDesenho(Documento doc) {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		
		JMenu mnArquivoTxt = new JMenu("Arquivo Txt");
//		mnArquivo.setMnemonic('A');
		mnArquivo.add(mnArquivoTxt);
		
		JMenu mnArquivoSerial = new JMenu("Arquivo Serial");
		mnArquivo.add(mnArquivoSerial);
		
		JMenuItem mntmSalvarTxt = new JMenuItem("Salvar");
		JMenuItem mntmLerTxt = new JMenuItem("Ler");
		mnArquivoTxt.add(mntmSalvarTxt);
		mnArquivoTxt.add(mntmLerTxt);
		
		JMenuItem mntmSalvarSerial = new JMenuItem("Salvar");
		JMenuItem mntmLerSerial = new JMenuItem("Ler");
		mnArquivoSerial.add(mntmSalvarSerial);
		mnArquivoSerial.add(mntmLerSerial);
		
		mntmSalvarTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = escolherArquivo(true);
				if(f == null)
					return;
				Aplicacao.getAplicacao().getDocumentAtivo().salvarFormas(f);
			}
		});
		mntmSalvarSerial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = escolherArquivo(true);
				if(f == null)
					return;
				Aplicacao.getAplicacao().getDocumentAtivo().salvarFormasSerial(f);
			}
		});
		
		JMenuItem mntmLer = new JMenuItem("Ler");
		mntmLer.setMnemonic('L');
		mntmLerTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = escolherArquivo(false);
				if(f == null)
					return;
				Aplicacao.getAplicacao().getDocumentAtivo().lerFormas(f);
			}
		});
		
		mntmLerSerial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = escolherArquivo(false);
				if(f == null)
					return;
				Aplicacao.getAplicacao().getDocumentAtivo().lerFormasSerial(f);
			}
		});
		
		JMenu mnForma = new JMenu("Formas");
		mnForma.setMnemonic('F');
		menuBar.add(mnForma);
		
		JMenuItem mntmPonto = new JMenuItem("Ponto");
		mntmPonto.setMnemonic('P');
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.novaForma(new Ponto());
			}
		});
		mnForma.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem("Linha");
		mntmLinha.setMnemonic('L');
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.novaForma(new Linha());
			}
		});
		mnForma.add(mntmLinha);
		
		JMenuItem mntmCirculo = new JMenuItem("Circulo");
		mntmCirculo.setMnemonic('C');
		mntmCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.novaForma(new Circulo());
			}
		});
		mnForma.add(mntmCirculo);
		
		JMenuItem mntmRetangulo = new JMenuItem("Retangulo");
		mntmRetangulo.setMnemonic('R');
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.novaForma(new Retangulo());
			}
		});
		mnForma.add(mntmRetangulo);
		
		JMenuItem mntmTriangulo = new JMenuItem("Triângulo");
		mntmTriangulo.setMnemonic('T');
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.novaForma(new Triangulo());
			}
		});
		mnForma.add(mntmTriangulo);
		
		
		setLayout(new BorderLayout(5, 5)); // configura o layout de frame
		
		textArea = new PainelTexto(doc);
//		textArea.Atualizar();
		//		textArea.setText("Texto");
		add(textArea, BorderLayout.WEST);
	
		status = new JLabel("linha de mensagem");
		add(status, BorderLayout.SOUTH);

		painel = new PainelDesenho(status, doc);
		add(painel, BorderLayout.CENTER);
		
		doc.adcionarOuvinte(textArea);
		doc.adcionarOuvinte(painel);
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
	
	
}
