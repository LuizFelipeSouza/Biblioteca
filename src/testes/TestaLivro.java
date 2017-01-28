package testes;

import biblioteca.Livro;
import biblioteca.Manga;

public class TestaLivro {

	public static void main(String[] args) {
		// Preciso passar os atributos na mesma ordem que foi definida no construtor?
		// Livros
		Livro neuromancer = new Livro("Neuromancer", "William Gibson", "Ficção Científica", 1984,  "Aleph");
		Livro count_zero = new Livro("Count Zero", "William Gibson", "Ficcção Científica", "Aleph");
		Livro mona_lisa_overdrive = new Livro("Mona Lisa Overdrive", "William Gibson", "Ficção Científica", "Aleph");
		
		Manga clay20 = new Manga("Claymore", 20, "Yogihiro Nagi", "Ação", "Panini");
		
		System.out.println(Livro.exibirAcervo());
		
	}

}
