package biblioteca;

import java.util.Collection;
import java.util.HashSet;

/* Podemos sobrecrever o m�todo equals() para comparar informa��oes de mesmo t�tulo, mesmo autor, etc.
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
	 * os livros por autor, editra, g�nero, etc.
	 * 
	 * A preer�ncia pelo uso do HashSet se d� por sua velocidade de busca O(1),
	 * estamos priorizando a velocidade de busca ao acervo em detrimento �
	 * velocidade de inser��o.
	 */
	private static Collection<Livro> acervo = new HashSet<>();

	/**
	 * Define um objeto Livro com o t�tulo e seu respectivo autor e adiciona o
	 * objeto � Collection acervo
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
	 * Define um objeto Livro com o t�tulo, seu respectivo autor, g�nero
	 * liter�rio, a editora pela qual foi publicado e adiciona o objeto �
	 * Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            G�nero liter�rio da obra
	 * @param editora
	 *            Editora de publica��o da obra
	 */
	public Livro(String titulo, String autor, String genero, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		acervo.add(this);
	}

	/**
	 * Define um objeto Livro com o t�tulo, seu respectivo autor, g�nero
	 * liter�rio, o ano e a editora pela qual foi publicado e adiciona o objeto
	 * � Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            G�nero liter�rio da obra
	 * @param ano
	 *            Ano de publica��o da obra
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
	 * Define um objeto Livro com o t�tulo, seu respectivo autor, g�nero
	 * liter�rio, o ano, a editora pela qual foi publicado e seu ISBN. Adiciona
	 * o objeto � Collection acervo
	 * 
	 * @param titulo
	 *            Titulo da obra
	 * @param autor
	 *            Autor da obra
	 * @param genero
	 *            G�nero liter�rio da obra
	 * @param ano
	 *            Ano de publica��o da obra
	 * @param editora
	 *            Editora
	 * @param ISBN
	 *            O n�mero de s�rie internacional da obra (ISBN)
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
	 * Adiciona um objeto livro � Collection acervo
	 * 
	 * @param livro
	 *            Objeto livro a ser adicionado
	 */
	public static void adicionar(Livro livro) {
		acervo.add(livro);
	}

	/**
	 * Mostra os objetos que est�o contidos na Collection acervo
	 * 
	 * @return acervo Collection de objetos Livro
	 */
	public static Collection<Livro> exibirAcervo() {
		return acervo;
	}

	/**
	 * Verifica se determinado t�tulo pertence � Collection acervo
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
	 * O m�todo toString() define o que ser� impresso quando a refer�ncia ao
	 * objeto for chamada Sobrescrevendo esse m�todo podemos imprimir as
	 * informa��es do livro ao utilizar System.out.println(livro)
	 */
	@Override
	public String toString() {
		String info = "T�tulo: " + this.getTitulo() + '\n' + "Autor: " + this.getAutor() + '\n' + "G�nero: "
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
