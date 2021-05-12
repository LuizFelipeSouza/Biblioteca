package biblioteca;

public class Periodico extends Livro {
	
	// TODO Pesquisar estruturas de dados para substituir a array de cole��o de mang�s. Salvar esta vers�o
	
	private int numero;
	private static Periodico[] colecao = new Periodico[1];
	
	// Construtores 
	public Periodico(String titulo, int numero, String autor) {
		super(titulo, autor);
		this.setNumero(numero);
		adicionar(this);
	}
	
	public Periodico(String titulo, int numero, String autor, String genero, String editora) {
		super(titulo, autor, genero, editora);
		this.setNumero(numero);
		adicionar(this);
	}
	
	public Periodico(String titulo, int numero, String autor, String genero, int ano, String editora) {
		super(titulo, autor, genero, ano, editora);
		this.numero = numero;
		adicionar(this);
	}
	
	// M�todos
	@Override
	public String toString() {
		super.toString();
		String info = this.getTitulo() + " " + this.getNumero();
		return info;
	}
	
	/** 
	 * Adiciona um novo volume do mang� � array de mang�s dessa cole��o
	 * 
	 * @param volume Volume de mang� a ser adicionado � cole��o
	 * @return void
	 */
	private void adicionar(Periodico volume) {
		// Chama o m�todo adicionar() da classe livro. Adiciona ao acervo geral
		super.adicionar(volume);
		
		if (colecao[0] == null) {
			colecao[0] = volume;
		}
	
		else {
			int tamanho = colecao.length + 1;
			Periodico[] aux = new Periodico[tamanho];
			aux[tamanho-1] = volume;
			for (int i = 0; i < tamanho-1; i++) {
				aux[i] = colecao[i];
			}
			Periodico.colecao = aux;
		}
	}
		
	public static void mostrarColecao() {
		for (Periodico periodico : colecao) {
			System.out.println(periodico);
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
