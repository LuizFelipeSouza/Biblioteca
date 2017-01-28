package testes;

import biblioteca.Livro;
import biblioteca.LivroDAO;

public class TestaInsercao {

	public static void main(String[] args) {
		Livro neuromancer = new Livro("Monalisa", "William Gibson", "Ficção Científica", 1986,  "Aleph");
		LivroDAO dao = new LivroDAO();
		dao.adiciona(neuromancer);
		System.out.println("Operação concluída com êxito!");

	}

}
