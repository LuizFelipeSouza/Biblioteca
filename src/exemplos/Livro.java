package exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Exemplo de uso do JFileChooser, JOptionPane e escrita de arquivo
 * A leitura de um arquivo serializado utilizando JFileChooser é análoga,
 * um exemplo pode ser encontrado no site da oracle:
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
 * 
 * 
 * 
 * @author Luiz Felipe Souza
 *
 */
public class Livro implements Serializable {
	
	/**
	 * A constante de versão de serialização deve ser incrementada caso a classe sofra
	 * qualquer alteração em seus métodos e/ou atributos.
	 * Isso irá "avisar" aos objetos serializados antes da alteração da possiblidade de
	 * nem todos os seus atributos serem restaurados na desserialização
	 */
	private static final long serialVersionUID = 1L;
	// HashSet é a estrutura de dados com a busca mais poderosa
	private static Collection<Livro> acervo = new HashSet<>();
	static ObjectOutputStream object;
	
	// Ignore essas variáveis
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private int ano;
	private long ISBN;
	
	public Livro(String titulo, String autor, String genero, int ano, String editora) {
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setEditora(editora);
		setAno(ano);
		acervo.add(this);
	}
	
	/**
	 * Janela de erro feita com JOptionPane
	 * @param exception 
	 */
	public static void mostrarErro(String exception) {
		String mensagem;
		switch (exception) {
		case "Escrita":
			mensagem = "Não foi possível salvar o arquivo";
			break;
		case "Leitura":
			mensagem = "Não foi possível encontrar o arquivo";
		default:
			mensagem = "Erro!";
		}
		// Exibe uma mensagem ao usuário caso haja algum erro de IOException
		// O último argumento é o ícone exibido na JOptionPane
		JOptionPane.showMessageDialog(new JFrame(), "Erro ao salvar arquivo", mensagem, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Exibe um JFileChooser e salva os objetos da Collection acervo em um arquivo .dat
	 */
	public static void salvarLivros() {
		// JFileChooser é a janela de seleção de arquivo
		JFileChooser fc = new JFileChooser();
		
		/* Descomente a linha abaixo para configurar o diretório incial
		 * fc.setCurrentDirectory(new File("C:\\Users\\user\\Desktop"));
		 */
		
		/* Exibe um JFileChooser para abertura de arquivo
		 * Retorna um inteiro que indica se o usuário
		 * selecionou um arquivo
		 */
		int returnVal = fc.showSaveDialog(new JFrame());
		
		/* A variável estática APPROVE_OPTION retorna um inteiro
		 * se uma opção de sim ou não for selecionada 
		 * (abrir ou cancelar, no caso)
		 */ 
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				// getSelectedFile() retorna o arquivo selecionado, no caso recebemos o nome do arquivo .dat
				PrintStream ps = new PrintStream(fc.getSelectedFile()+".dat");
				// Classe utilizada para a saída de objetos
				 object = new ObjectOutputStream(ps);
				
				// Percorre a Collection de livros e chama o writeObject() de cada um
				for (Livro livro : acervo) {
					object.writeObject(livro);
					// Força a escrita
					object.flush();
				}
				object.close();
			
			} catch (FileNotFoundException e) {
				// PrintStream lança essa exception se passarmos uma String para seu construtor
				mostrarErro("Escrita");
			} catch (IOException e) {
				// Exception lançada por ObjectOutputStream
				mostrarErro("Escrita");
			}
		}
	}
	
	public static Collection<Livro> ler() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(new JFrame());
		Collection<Livro> livros = new HashSet<>();
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			try {
				FileInputStream in = new FileInputStream(chooser.getSelectedFile());
				ObjectInputStream obj = new ObjectInputStream(in);
				Livro livro1 = (Livro) obj.readObject();
				Livro livro2 = (Livro) obj.readObject();
				Livro livro3 = (Livro) obj.readObject();
				
				livros.add(livro1);
				livros.add(livro2);
				livros.add(livro3);
				
				obj.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return livros;
		
	}
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
	
	// Demonstração
	public static void main(String[] args) {
		Livro neuromancer = new Livro("Neuromancer", "William Gibson", "Ficção Científica", 1984, "Aleph");
		Livro count_zero = new Livro("Count Zero", "William Gibson", "Ficção Científica", 1986, "Aleph");
		Livro mona_lisa_overdrive = new Livro("Mona Lisa Overdrive", "William Gibson", "Ficção Científica", 1988, "Aleph");
		
		Livro.salvarLivros();
		acervo = Livro.ler();
		
		for (Livro l : acervo) {
			System.out.println(l);
		}
	}
}

