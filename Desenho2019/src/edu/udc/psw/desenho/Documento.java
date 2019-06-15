package edu.udc.psw.desenho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.gui.PainelOuvinteFormas;
import edu.udc.psw.desenho.persistencia.ArquivoFormas;
import edu.udc.psw.desenho.persistencia.ArquivoSerial;
import edu.udc.psw.desenho.persistencia.ArquivoTexto;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;

public class Documento {
	//ter uma instancia de File
	//se o arquivo que est� aberto j� foi salvo alguma vez, ent�o salva automaticamente
	//se n�o tiver salvo nenhuma
	private ArquivoFormas arq;
	private FileOutputStream arqSerial;
	private ArquivoSerial arqSerialInput;
	private LinkedList<FormaGeometrica> lista;
	private LinkedList<PainelOuvinteFormas> listaOuvintes;
	
	public Documento() {
		lista = new LinkedList<>();
		listaOuvintes = new LinkedList<>();
	}
	
	//public void adcionarOuvinte(PainelTexto textArea) {
	public void adcionarOuvinte(PainelOuvinteFormas painel) {
		listaOuvintes.addFirst(painel);
	}
	
	public void removerOuvinte(PainelOuvinteFormas painel) {
		//...
	}
	
	public void atualizarPaineis() {
		Iterator<PainelOuvinteFormas> i = listaOuvintes.getFirst();
		PainelOuvinteFormas painel;
		while((painel = i.next()) != null) {
			painel.formasAlteradas();
		}
	}
	
	public void limparLista() {
		lista.removeAll();
	
		atualizarPaineis();
	}
	
	public void inserir(FormaGeometrica p) {
		lista.addLast(p);
		atualizarPaineis();
	}
	public Iterator<FormaGeometrica> getIterator() {
		return lista.getFirst();
	}
	public int getListSize() {
		return lista.getSize();
	}
	
	public void arquivoExistente() {
		
	}
	
	public void salvarFormas(File file) {
		arq = new ArquivoTexto(file);
		//Diferenciar qual tipo de arquivo que vai ser salvo: Texto, bin�rio, serial ...

		arq.salvarFormas(lista.getFirst());
	}
	
	public void salvarFormasSerial(File file) {
		arqSerialInput = new ArquivoSerial(file);
		
		arqSerialInput.salvarFormas(lista.getFirst());
	}

	// Metodo ContextInterface da classe Context no padr�o Strategy
	public void lerFormas(File file) {
		arq = new ArquivoTexto(file);
		//Pela extens�o do arquivo o m�todo de ler aquivos deve saber diferenciar o tipo de arquivo a ser lido
		lista.limparLista();
		lista.removeAll();
	//	String name = file.getName();
//		String ext = name.substring(name.lastIndexOf('.') + 1);
		
		//listaFormas = arq.lerFormas();
//		arq.lerFormas(Aplicacao.getAplicacao().getDocumentAtivo());
		arq.lerFormas(this);

//		atualizaViews();
	}
	
	public void lerFormasSerial(File file) {
		arq = new ArquivoSerial(file);
		lista.limparLista();
		arq.lerFormas(this);
		
	}
}
