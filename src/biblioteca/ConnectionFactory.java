package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory é um Design Pattern; faz a conexão com o banco de dados e
 * retorna RuntimeException
 * 
 * A classe lança uma RuntimeException caso a conexão com o banco de dados não
 * seja bem sucedida. como consequência, não precisamos nos preocuar com
 * questões relacinadas ao banco de dados em outras partes do projeto.
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
			 * A classe DriverManager é responsável por se comunicar com todos
			 * os drivers disponíveis
			 */
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "Kuchiki%2000");
		}

		/*
		 * Lançamos RuntimeException ao invés de SQLException para que não
		 * pecisemos nos preocupar com questões relacionadas ao banco de dados
		 * em outras partes do projeto
		 */
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
