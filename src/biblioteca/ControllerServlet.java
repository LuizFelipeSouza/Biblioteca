package biblioteca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controller respons�vel por receber os par�metros da View e selecionar
 * a classe Model que executar� determinada a��o
 * 
 * @author Luiz Felipe Souza
 * 
 */
public class ControllerServlet extends HttpServlet {
	/* TODO: Adicionar classes:
	 * Recuperar lista
	 * Busca
	 * Altera��o
	 * Remo��o */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 
	 * Escolhi usar doPost() ao inv�s do m�todo service() porque este �ltimo
	 * aceita todos os m�todos HTTP, o que pode acarretar em falhas de seguran�a
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("id");
		String nomeClasse = "biblioteca." + parametro;

		try {
			/*
			 * Inicializa uma nova classe de acordo com o par�mtro do campo
			 * "acao" pertencente ao formul�rio web
			 */
			Class<?> classe = Class.forName(nomeClasse);
			/*
			 * Instancia um objeto da classe definida acima e d� um casting para
			 * a interface Logica
			 */
			Logica logica = (Logica) classe.newInstance();
			// Aqui o polimorfismo entra em a��o, chamando o m�todo executa()
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException("Ocorreu uma exce��o no tipo de a��o executada", e);
		}

	}

}
