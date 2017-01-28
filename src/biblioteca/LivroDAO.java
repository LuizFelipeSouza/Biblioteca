package biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe respons�vel pelo acesso ao banco de dados (Design Pattern de Data Access Object)
 * Adicionar m�todos para remover, alterar e pesquisar dados
 * @author Luiz Felipe Souza
 *
 */
// DAO (Data Access Object) � um design pattern para enviar comandos de inser��o ao database
public class LivroDAO {
	private Connection con;
	
	public LivroDAO() {
		// Cria uma conex�o com o banco de dados a partir da classe ConnectionFactory
		this.con = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Adiciona um livro ao banco de dados
	 * @param Objeto Livro
	 */
	public void adiciona (Livro livro) {
		/* Esta vari�vel cont�m o comando SQL que ser� executado. As ? em values s�o substituidas pelos valores das vari�veis entre
		 * par�nteses atrav�s do m�todo setString()
		 */
		String sql = "INSERT INTO acervo " +
					"(titulo, autor, genero, editora, ano, ISBN)" + 
					"values(?,?,?,?,?,?)";
		try {
			// PreparedStatement � uma interface que executa as queries SQL
			PreparedStatement stmt = con.prepareStatement(sql);
			
			/* O m�todo setString de PreparedStatement substitui as ? do statemnt recebendo
			como argumentos a posi��o e a informa��o a ser inserida */ 
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getGenero());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5,  livro.getAno());
			stmt.setLong(6, livro.getISBN());
			
			// A query SQL � executada de fato aqui
			stmt.execute();
			// Fecha a conex�o com o banco de dados
			stmt.close();
		}
		catch (SQLException e) {
			// Retornamos uma RuntimeException para n�o precisarmos nos proucupar com quest�es relacionadas ao banco de dados em outras partes do c�digo
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Retorna uma lista com os livros cadastrados no banco de dados
	 * @return ArrayList de objetos Livro
	 */
	public List<Livro> getLista(){
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "SELECT * FROM acervo";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// Retorna um conjunto de resultados (ResultSet)
			ResultSet rs = ps.executeQuery();
			
			// O while interage pelos itens do ResultSet
			while(rs.next()){
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String genero = rs.getString("genero");
				int ano = rs.getInt("ano");
				String editora = rs.getString("editora");
				long ISBN = rs.getLong("ISBN");
				
				Livro livro = new Livro(titulo, autor, genero, ano, editora, ISBN);
				
				// Adiciona � ArrayList
				livros.add(livro);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return livros;
	}
}
