package animais;

public class TestarAniais {
	public static void main(String[] args) {
		Animal Camelo = new Mamifero("Camelo", 150, 4, "Amarelo", 
			"Terra", 2, "salada");
		Animal Tubarao = new Peixe("Tubarão", 300, 0, "Cinzento", 
			"Mar", 1.5f, "Barbatanas e cauda");
	
		Animal UrsoCanada = new Mamifero("Urso-do-Canada", 180, 4, "Vermelho",
			"Terra", 0.5f, "Mel");
		
		Camelo.dados();
		Tubarao.dados();
		UrsoCanada.dados();
	}
}
