package biblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import biblioteca.LivroDAO;;

// Não testado
/**
 * Definimos uma servlet para adicionar livros ao banco de dados a partir das informações passadas pela página web
 * @author Luiz Felipe Souza
 *
 */
//@WebServlet(name="Novolivro", urlPatterns={"/novoLivro", "/adicionarLivro"})
@WebServlet("novoLivro")
public class NovoLivro extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getWriter() retorna um objeto PrintWriter que pode retornar dados de caracteres para o cliente
		PrintWriter out = response.getWriter();
		
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
		dao.adiciona(livro);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Livro " + livro.getTitulo() + " adicionado com sucesso");
		out.print("</body>");
		out.println("</html>");		
	}
	/* Podemos utilizar os métodos GET e POST para receber as informações da página web
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	*/
	
}
