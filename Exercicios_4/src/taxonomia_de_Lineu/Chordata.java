package taxonomia_de_Lineu;

public class Chordata implements Reino{
	
	private String filo = "Chordata";
	
	public String obterDescricao() {
		return String.format("Reino: %s\nFilo: %s", nome, filo);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
