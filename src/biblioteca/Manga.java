package biblioteca;

public class Manga extends Livro {
	
	// TODO Pesquisar estruturas de dados para substituir a array de coleção de mangás. Salvar esta versão
	
	private int numero;
	private static Manga[] colecao = new Manga[1]; 
	
	// Construtores 
	public Manga(String titulo, int numero, String autor) {
		super(titulo, autor);
		this.setNumero(numero);
		adicionar(this);
	}
	
	public Manga(String titulo, int numero, String autor, String genero, String editora) {
		super(titulo, autor, genero, editora);
		this.setNumero(numero);
		adicionar(this);
	}
	
	public Manga(String titulo, int numero, String autor, String genero, int ano, String editora) {
		super(titulo, autor, genero, ano, editora);
		this.numero = numero;
		adicionar(this);
	}
	
	// Métodos
	@Override
	public String toString() {
		super.toString();
		String info = this.getTitulo() + " " + this.getNumero();
		return info;
	}
	
	/** 
	 * Adiciona um novo volume do mangá à array de mangás dessa coleção
	 * 
	 * @param volume Volume de mangá a ser adicionado à coleção
	 * @return void
	 */
	private void adicionar(Manga volume) {
		// Chama o método adicionar() da classe livro. Adiciona ao acervo geral
		super.adicionar(volume);
		
		if (colecao[0] == null) {
			colecao[0] = volume;
		}
	
		else {
			int tamanho = colecao.length + 1;
			Manga[] aux = new Manga[tamanho];
			aux[tamanho-1] = volume;
			for (int i = 0; i < tamanho-1; i++) {
				aux[i] = colecao[i];
			}
			Manga.colecao = aux;
		}
	}
		
	public static void mostrarColecao() {
		for (Manga manga : colecao) {
			System.out.println(manga);
		}
	}

	// Getters e Setters
	public int getNumero(){
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
