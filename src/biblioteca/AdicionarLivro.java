package biblioteca;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarLivro implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Aqui são recebidas as informações digitadas na página web
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
