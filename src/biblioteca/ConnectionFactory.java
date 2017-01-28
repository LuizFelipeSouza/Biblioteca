package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** ConnectionFactory é um Design Pattern; faz a conexão com o banco de dados e retorna RuntimeException
 * @author Luiz Felipe Souza
 */
public class ConnectionFactory {
	public Connection getConnection() {
		try {
			// A classe DriverManager é responsável por se comunicar com todos os drivers disponíveis
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "Kuchiki%2000");
		}
		
		/* Lançamos RuntieException ao invés de SQLException para que não pecisemos 
		 nos preocupar com questões relacionadas ao banco de dados em outras partes do projeto */
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
