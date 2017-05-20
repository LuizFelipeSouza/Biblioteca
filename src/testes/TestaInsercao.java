package testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import biblioteca.Livro;
import biblioteca.LivroDAO;

public class TestaInsercao {

	public static void main(String[] args) {

		// Livro fundacao = new Livro("Prel�dio a Funda��o", "Isaac Asimov", "Fic��o Cient�fica", 1986, "Aleph");
		// Livro novaLaranja = new Livro("Laranja", "Burges", "Fic��o
		// Cient�fica", 1986, "Aleph");
		LivroDAO dao = new LivroDAO();
		// dao.adicionar(laranja);
		// System.out.println(dao.alterar(novaLaranja, laranja));
		// System.out.println(dao.buscar(fundacao));
		// System.out.println(dao.remover(fundacao));
		// System.out.println(dao.buscar(fundacao));
		// dao.adicionar(fundacao);
		// System.out.println(dao.buscar(fundacao));

		Collection<Livro> lista = dao.getLista();

		for (Livro livro : lista) {
			System.out.println("Lista: " + livro);
		}

		System.out.println("Opera��o conclu�da com �xito!");
	}

}
