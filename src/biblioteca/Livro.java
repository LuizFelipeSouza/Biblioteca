package biblioteca;

import java.util.Collection;
import java.util.HashSet;

/* Podemos sobrecrever o método equals() para comparar informaçãoes de mesmo título, mesmo autor, etc.
 * Podemos agrupar os livros por atributos em comum. Os livros de Dan Brown, os livros de Isaac Asimov, etc.
 */
/**
 * Define a modelagem de um livro no projeto de biblioteca
 * 
 * @author Luiz Felipe Souza
 *
 */
public class Livro {
	
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private int ano;
	private long ISBN;

	/*
	 * Considere substituir o HashSet por um mapa. Dessa forma poderemos buscar
	 * os livros por autor, editra, gênero, etc.
	 * 
	 * A preerência pelo uso do HashSet se dá por sua velocidade de busca O(1),
	 * estamos priorizando a velocidade de busca ao acervo em detrimento à
	 * velocidade de inserção.
	 */
	private static Collection<Livro> acervo = new HashSet<>();

	/**
	 * Define um objeto Livro com o título e seu respectivo autor e adiciona o
	 * objeto à Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 */
	public Livro(String titulo, String autor) {
		setTitulo(titulo);
		setAutor(autor);
		acervo.add(this);
	}

	/**
	 * Define um objeto Livro com o título, seu respectivo autor, gênero
	 * literário, a editora pela qual foi publicado e adiciona o objeto à
	 * Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            Gênero literário da obra
	 * @param editora
	 *            Editora de publicação da obra
	 */
	public Livro(String titulo, String autor, String genero, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		acervo.add(this);
	}

	/**
	 * Define um objeto Livro com o título, seu respectivo autor, gênero
	 * literário, o ano e a editora pela qual foi publicado e adiciona o objeto
	 * à Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            Gênero literário da obra
	 * @param ano
	 *            Ano de publicação da obra
	 * @param editora
	 *            Editora
	 */
	public Livro(String titulo, String autor, String genero, int ano, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		setAno(ano);
		acervo.add(this);
	}

	/**
	 * Define um objeto Livro com o título, seu respectivo autor, gênero
	 * literário, o ano, a editora pela qual foi publicado e seu ISBN. Adiciona
	 * o objeto à Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            Gênero literário da obra
	 * @param ano
	 *            Ano de publicação da obra
	 * @param editora
	 *            Editora
	 * @param ISBN
	 *            O número de série internacional da obra (ISBN)
	 */
	public Livro(String titulo, String autor, String genero, int ano, String editora, long ISBN) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		setAno(ano);
		setISBN(ISBN);
		acervo.add(this);
	}

	/**
	 * Adiciona um objeto livro à Collection acervo
	 * 
	 * @param livro
	 *            Objeto livro a ser adicionado
	 */
	public static void adicionar(Livro livro) {
		acervo.add(livro);
	}

	/**
	 * Mostra os objetos que estão contidos na Collection acervo
	 * 
	 * @return acervo Collection de objetos Livro
	 */
	public static Collection<Livro> exibirAcervo() {
		return acervo;
	}

	/**
	 * Verifica se determinado título pertence à Collection acervo
	 * 
	 * @param titulo
	 *            Titulo do objeto Livro a ser buscado
	 * @return boolean Indica se o Livro existe na Collection acervo
	 */
	public boolean buscar(Livro titulo) {
		if (acervo.contains(this.titulo)) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * O método toString() define o que será impresso quando a referência ao
	 * objeto for chamada Sobrescrevendo esse método podemos imprimir as
	 * informações do livro ao utilizar System.out.println(livro)
	 */
	@Override
	public String toString() {
		String info = "Título: " + this.getTitulo() + '\n' + "Autor: " + this.getAutor() + '\n' + "Gênero: "
				+ this.getGenero() + '\n' + "Ano: " + this.ano + '\n' + "Editora: " + this.getEditora() + '\n'
				+ "ISBN: " + this.getISBN() + "\n\n";

		return info;
	}

	// Getters e Setters
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return this.editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
}
