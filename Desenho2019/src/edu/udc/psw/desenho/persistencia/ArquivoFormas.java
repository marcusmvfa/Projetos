package edu.udc.psw.desenho.persistencia;

import edu.udc.psw.desenho.Documento;
import edu.udc.psw.desenho.formas.FormaGeometrica;
import edu.udc.psw.util.Iterator;

public interface ArquivoFormas {
	void lerFormas(Documento doc);
	void salvarFormas(Iterator<FormaGeometrica> it);
}
