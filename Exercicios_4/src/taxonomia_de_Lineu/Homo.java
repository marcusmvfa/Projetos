package taxonomia_de_Lineu;

public class Homo extends Hominidae{
	private String genero = "Homo";
	
	public String obterDescricao() {
		return String.format("%s\nGenero: %s",super.obterDescricao(), genero);
	}
}
