package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** ConnectionFactory � um Design Pattern; faz a conex�o com o banco de dados e retorna RuntimeException
 * @author Luiz Felipe Souza
 */
public class ConnectionFactory {
	public Connection getConnection() {
		try {
			// A classe DriverManager � respons�vel por se comunicar com todos os drivers dispon�veis
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "Kuchiki%2000");
		}
		
		/* Lan�amos RuntieException ao inv�s de SQLException para que n�o pecisemos 
		 nos preocupar com quest�es relacionadas ao banco de dados em outras partes do projeto */
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
