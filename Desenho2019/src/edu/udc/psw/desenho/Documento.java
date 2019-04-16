package edu.udc.psw.desenho;

import java.io.File;

import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.desenho.gui.PainelOuvinteFormas;
import edu.udc.psw.desenho.persistencia.ArquivoFormas;
import edu.udc.psw.desenho.persistencia.ArquivoTexto;
import edu.udc.psw.util.Iterator;
import edu.udc.psw.util.LinkedList;

public class Documento {
	//ter uma instancia de File
	//se o arquivo que está aberto já foi salvo alguma vez, então salva automaticamente
	//se não tiver salvo nenhuma
	private ArquivoFormas arq;
	private LinkedList<FormaGeometrica> lista;
	private LinkedList<PainelOuvinteFormas> listaOuvintes;
	
	public Documento() {
		lista = new LinkedList<>();
		listaOuvintes = new LinkedList<>();
	}
	
	
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
//		while(first != null && last != null) {
//			first = null;
//			last = null;
//		}		
	
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
		//Diferenciar qual tipo de arquivo que vai ser salvo: Texto, binário, serial ...

		arq.salvarFormas(lista.getFirst());
	}

	// Metodo ContextInterface da classe Context no padrão Strategy
	public void lerFormas(File file) {
		arq = new ArquivoTexto(file);
		//Pela extensão do arquivo o método de ler aquivos deve saber diferenciar o tipo de arquivo a ser lido
		lista.removerTudo();
	//	String name = file.getName();
//		String ext = name.substring(name.lastIndexOf('.') + 1);
		
		//listaFormas = arq.lerFormas();
		arq.lerFormas(Aplicacao.getAplicacao().getDocumentAtivo());

//		atualizaViews();
	}
}
