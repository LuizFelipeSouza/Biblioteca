package biblioteca;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Definimos uma servlet para adicionar livros ao banco de dados a partir das
 * informa��es passadas pela p�gina web
 * 
 * @author Luiz Felipe Souza
 * @deprecated Essa classe n�o mais ser� utilizada no projeto
 *
 */
@WebServlet(name = "NovoLivroServlet", urlPatterns = { "/novoLivro", "/NovoLivroServlet", "/novolivro" })

public class NovoLivroServlet extends HttpServlet {
	// TODO: Ver FJ-21 9.9: Exerc�cios opcionais
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
		/*
		 * getWriter() retorna um objeto PrintWriter que pode retornar dados de
		 * caracteres para o cliente
		 */

		// Aqui s�o recebidas as informa��es digitadas na p�gina web
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String genero = request.getParameter("genero");
		String editora = request.getParameter("editora");
		String anoString = request.getParameter("ano");
		String ISBNString = request.getParameter("ISBN");

		// Estamos convertendo as Strings para int e long, respectivamente
		int ano = Integer.parseInt(anoString);
		long ISBN = Long.parseLong(ISBNString);

		Livro livro = new Livro(titulo, autor, genero, ano, editora, ISBN);
		LivroDAO dao = new LivroDAO();
		dao.adicionar(livro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/livro_adicionado.jsp"); 
		dispatcher.forward(request, response);
	}

}
