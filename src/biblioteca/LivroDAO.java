package biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe respons�vel pelo acesso ao banco de dados (Design Pattern de Data
 * Access Object)
 * 
 * @author Luiz Felipe Souza
 *
 */

// TODO: Verificar m�todo existeNoAcervo(). Est� retornando true para ambos os
// casos.

public class LivroDAO {

	private Connection con;

	public LivroDAO() {
		// Cria uma conex�o com o banco de dados a partir da classe
		// ConnectionFactory
		this.con = new ConnectionFactory().getConnection();
	}

	/**
	 * Adiciona um objeto Livro ao banco de dados
	 * 
	 * @param Livro
	 */
	public void adicionar(Livro livro) {
		/*
		 * Esta vari�vel cont�m o comando SQL que ser� executado. As ? em values
		 * s�o substituidas pelos valores das vari�veis entre par�nteses atrav�s
		 * do m�todo setString()
		 */
		String sql = "INSERT INTO acervo " + "(titulo, autor, genero, editora, ano, ISBN)" + "values(?,?,?,?,?,?)";
		try {
			// PreparedStatement � uma interface que executa as queries SQL
			PreparedStatement stmt = con.prepareStatement(sql);

			/*
			 * O m�todo setString de PreparedStatement substitui as ? do
			 * statemnt recebendo como argumentos a posi��o e a informa��o a ser
			 * inserida
			 */
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getGenero());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAno());
			stmt.setLong(6, livro.getISBN());

			// A query SQL � executada de fato aqui
			stmt.execute();
			// Fecha a conex�o com o banco de dados
			stmt.close();
		} catch (SQLException e) {
			// Retornamos uma RuntimeException para n�o precisarmos nos
			// proucupar com quest�es relacionadas ao banco de dados em outras
			// partes do c�digo
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retorna uma lista com os livros cadastrados no banco de dados
	 * 
	 * @return HashSet de objetos Livro
	 */
	public Collection<Livro> getLista() {
		
		Collection<Livro> livros = new HashSet<>();
		String sql = "SELECT * FROM acervo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// Retorna um conjunto de resultados (ResultSet)
			ResultSet rs = ps.executeQuery();

			// O while interage pelos itens do ResultSet
			while (rs.next()) {
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
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return livros;
	}

	/**
	 * Procura um livro no acervo
	 * 
	 * @param livro
	 *            Objeto livro a ser buscado
	 * @return livro Caso o objeto Livro exista no banco de dados
	 * @throws RuntimeException
	 *             Caso o objeto livro n�o exista no banco de dados
	 */
	public Livro buscar(Livro livro) {
		String sql = "SELECT * FROM acervo WHERE titulo=? AND autor=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String genero = rs.getString("genero");
				int ano = rs.getInt("ano");
				String editora = rs.getString("editora");
				long ISBN = rs.getLong("ISBN");

				livro = new Livro(titulo, autor, genero, ano, editora, ISBN);

				return livro;
			}
		} catch (SQLException e) {
			throw new RuntimeException("N�o encontrado" + e);
		}

		return null;
	}

	/**
	 * Altera as informa��es sobre um Objeto Livro no banco de dados
	 * 
	 * @param novoLivro
	 *            Objeto Livro que ir� sobrepor o antigo
	 * @param antigoLivro
	 *            Objeto Livro que ser� sobreposto
	 * @return boolean Indica se a a��o de substitui��o foi bem sucedida
	 */
	public boolean alterar(Livro novoLivro, Livro antigoLivro) {
		String sql = "UPDATE acervo set titulo=?, autor=?, genero=?, ano=?, editora=?, ISBN=? WHERE titulo=? AND autor=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, novoLivro.getTitulo());
			ps.setString(2, novoLivro.getAutor());
			ps.setString(3, novoLivro.getGenero());
			ps.setInt(4, novoLivro.getAno());
			ps.setString(5, novoLivro.getEditora());
			ps.setLong(6, novoLivro.getISBN());
			ps.setString(7, antigoLivro.getTitulo());
			ps.setString(8, antigoLivro.getAutor());

			ps.execute();
			ps.close();

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Remove um dado livro do banco de dados
	 * 
	 * @param livro
	 *            Livro a ser removido
	 * @return boolean Indica se a opera��o de remo��o foi bem sucedida
	 */
	public boolean remover(Livro livro) {
		String sql = "DELETE FROM acervo WHERE titulo=? AND autor=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.execute();
			ps.close();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
