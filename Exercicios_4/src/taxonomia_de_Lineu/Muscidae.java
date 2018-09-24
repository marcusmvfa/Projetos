package taxonomia_de_Lineu;

public class Muscidae extends Diptera{
	private String familia = "Muscidae";
	
	public String obterDescricao() {
		return String.format("%s\nFamilia: %s",super.obterDescricao(), familia);
	}
}
