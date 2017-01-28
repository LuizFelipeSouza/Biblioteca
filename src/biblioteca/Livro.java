package biblioteca;

import java.util.Collection;
import java.util.HashSet;

/* Podemos sobrecrever o m�todo equals() para comparar informa��oes de mesmo t�tulo, mesmo autor, etc.
 * Podemos agrupar os livros por atributos em comum. Os livros de Dan Brown, os livros de Isaac Asimov, etc.
 * Tamb�m podemos sobrescrever o m�todo toString() ao inv�s de usar o m�todo mostrarInforma��es()
 */

public class Livro {
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private int ano;
	private long ISBN;

	// Considere substituir o HashSet por um mapa. Dessa forma poderemos buscar os livros por autor, editra, g�nero, etc.
	private static Collection<Livro> acervo = new HashSet<>();
	
	// Construtores
	public Livro(String titulo, String autor){
		setTitulo(titulo);
		setAutor(autor);
		acervo.add(this);
	}
	
	public Livro(String titulo, String autor, String genero, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		acervo.add(this);
	}
	
	public Livro(String titulo, String autor, String genero, int ano, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		setAno(ano);
		acervo.add(this);
	}
	
	public Livro(String titulo, String autor, String genero, int ano, String editora, long ISBN) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		setAno(ano);
		setISBN(ISBN);
		acervo.add(this);
	}
	
	// M�todos
	/**
	 * Adiciona um objeto livro ao acervo
	 * @param livro
	 */
	public static void adicionar(Livro livro) {
		acervo.add(livro);
	}
	/**
	 * @return acervo de livros (tipo Collection)
	 */
	public static Collection<Livro> exibirAcervo() {
		return acervo;
	}
	
	/**
	 * Verifica se determinado t�tulo pertence ao acervo
	 * @param titulo
	 * @return true se o objeto existe no acero ou false caso contr�rio
	 */
	public boolean buscar(Livro titulo) {
		if (acervo.contains(this.titulo)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/* O m�todo toString() define o que ser� impresso quando a refer�ncia ao objeto for chamada
	 * Sobrescrevendo esse m�todo podemos imprimir as informa��es do livro ao utilizar System.out.println(livro) */
	@Override
	public String toString() {
		String info = "T�tulo: " + this.getTitulo() + "\n" + 
				"Autor: " + this.getAutor() + "\n" +
				"G�nero: " + this.getGenero() + "\n" + 
				"Ano: " + this.ano + "\n" +
				"Editora: " + this.getEditora() +"\n" +
				"ISBN: " + this.getISBN() + "\n\n";
		
		return info;
	}
	
	// Faz a memsa coisa que o toString()
	public void mostrarInformacoes() {
		System.out.println("T�tulo: " + this.getTitulo());
		System.out.println("Autor: " + this.getAutor());
		System.out.println("G�nero: " + this.getGenero());
		System.out.println("Ano: " + this.getAno());
		System.out.println("Editora: " + this.getEditora());
		System.out.println("ISBN: " + this.getISBN());		
	}
	
	// Getters e Setters	
	public String getTitulo() {
		return this.titulo;
	}
	
	void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGenero(){
		return this.genero;
	}
	
	void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEditora(){
		return this.editora;
	}
	
	void setEditora(String editora){
		this.editora = editora;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
	void setAutor(String autor){
		this.autor = autor;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	void setAno(int ano){
		this.ano = ano;
	}
	
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
}
