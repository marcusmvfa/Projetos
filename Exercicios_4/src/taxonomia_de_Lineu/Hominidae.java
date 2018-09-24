package taxonomia_de_Lineu;

public class Hominidae extends Primata{
	private String familia = "Hominidae";
	
	public String obterDescricao() {
		return String.format("%s\nFamília: %s",super.obterDescricao(), familia);
	}
}
