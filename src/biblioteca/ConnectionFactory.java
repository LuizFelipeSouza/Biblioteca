package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory � um Design Pattern; faz a conex�o com o banco de dados e
 * retorna RuntimeException
 * 
 * A classe lan�a uma RuntimeException caso a conex�o com o banco de dados n�o
 * seja bem sucedida. como consequ�ncia, n�o precisamos nos preocuar com
 * quest�es relacinadas ao banco de dados em outras partes do projeto.
 * 
 * @author Luiz Felipe Souza
 */
public class ConnectionFactory {
	public Connection getConnection() {
		try {
			/*
			 * Resolvido erro de no suitable driver found. Fonte:
			 * http://www.devmedia.com.br/forum/nao-consigo-gravar-no-banco-
			 * usando-jdbc-em-projeto-web/395387
			 */
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			/*
			 * A classe DriverManager � respons�vel por se comunicar com todos
			 * os drivers dispon�veis
			 */
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "Kuchiki%2000");
		}

		/*
		 * Lan�amos RuntimeException ao inv�s de SQLException para que n�o
		 * pecisemos nos preocupar com quest�es relacionadas ao banco de dados
		 * em outras partes do projeto
		 */
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
