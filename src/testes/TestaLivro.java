package testes;

import biblioteca.Livro;
import biblioteca.Manga;

public class TestaLivro {

	public static void main(String[] args) {
		// Preciso passar os atributos na mesma ordem que foi definida no construtor?
		// Livros
		Livro neuromancer = new Livro("Neuromancer", "William Gibson", "Fic��o Cient�fica", 1984,  "Aleph");
		Livro count_zero = new Livro("Count Zero", "William Gibson", "Ficc��o Cient�fica", "Aleph");
		Livro mona_lisa_overdrive = new Livro("Mona Lisa Overdrive", "William Gibson", "Fic��o Cient�fica", "Aleph");
		
		Manga clay20 = new Manga("Claymore", 20, "Yogihiro Nagi", "A��o", "Panini");
		
		System.out.println(Livro.exibirAcervo());
		
	}

}
