package biblioteca;

/**
 * Estamos utilizando padr�es de projeto a fim de encapsular a comunica��o com o banco de dados
 * 
 * @author Luiz Felipe Souza
 */
public class DAOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DAOException(String mensagem) {
		super(mensagem);
	}

}
