package testes;

import biblioteca.Livro;
import biblioteca.Periodico;

public class TestaLivro {

	public static void main(String[] args) {
		Livro neuromancer = new Livro("Neuromancer", "William Gibson", "Fic��o Cient�fica", 1984, "Aleph");
		Livro count_zero = new Livro("Count Zero", "William Gibson", "Ficc��o Cient�fica", "Aleph");
		Livro mona_lisa_overdrive = new Livro("Mona Lisa Overdrive", "William Gibson", "Fic��o Cient�fica", "Aleph");

		Periodico clay20 = new Periodico("Claymore", 20, "Yogihiro Nagi", "A��o", "Panini");

		System.out.println(Livro.exibirAcervo());

	}

}
