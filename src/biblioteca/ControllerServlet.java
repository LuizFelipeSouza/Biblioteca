package biblioteca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controller responsável por receber os parâmetros da View e selecionar
 * a classe Model que executará determinada ação
 * 
 * @author Luiz Felipe Souza
 * 
 */
public class ControllerServlet extends HttpServlet {
	/* TODO: Adicionar classes:
	 * Recuperar lista
	 * Busca
	 * Alteração
	 * Remoção */
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
	 * Escolhi usar doPost() ao invés do método service() porque este último
	 * aceita todos os métodos HTTP, o que pode acarretar em falhas de segurança
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("id");
		String nomeClasse = "biblioteca." + parametro;

		try {
			/*
			 * Inicializa uma nova classe de acordo com o parâmtro do campo
			 * "acao" pertencente ao formulário web
			 */
			Class<?> classe = Class.forName(nomeClasse);
			/*
			 * Instancia um objeto da classe definida acima e dá um casting para
			 * a interface Logica
			 */
			Logica logica = (Logica) classe.newInstance();
			// Aqui o polimorfismo entra em ação, chamando o método executa()
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException("Ocorreu uma exceção no tipo de ação executada", e);
		}

	}

}
