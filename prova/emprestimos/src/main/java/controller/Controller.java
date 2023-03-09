package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans emprestimo = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			emprestimos(request, response);

		} else if (action.equals("/insert")) {
			novoEmprestimo(request, response);
		} else if (action.equals("/update")) {
			editarEmprestimo(request, response);
		} else if (action.equals("/select")) {
			listarEmprestimo(request, response);
		} else if (action.equals("/delete")) {
			removerEmprestimo(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// LISTAR  (SERVLET / CONTROLLER)
	protected void emprestimos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// CRIANDO OBJETO QUE IRA RECEBER OS DADOS JAVABEANS (VETOR DINAMICO)
		ArrayList<JavaBeans> lista = dao.listarEmprestimos();

		// ENCAMINHAR A LISTA AO DOCUMENTO EMPRESTIMOS.JSP
		request.setAttribute("emprestimos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("emprestimos.jsp");
		rd.forward(request, response);
	}

	// NOVO EMPRESTIMO (SERVLET / CONTROLLER)
	protected void novoEmprestimo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis JavaBeans
		emprestimo.setData(request.getParameter("data"));
		emprestimo.setObservacao(request.getParameter("observacao"));
		emprestimo.setUsuario(request.getParameter("usuario"));
		emprestimo.setTipoUsuario(request.getParameter("tipousuario"));
		

		// INVOCAR O MÉTODO inserirEmprestimo passando o objeto emprestimo
		dao.inserirEmprestimo(emprestimo);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// EDITAR emprestimo (SERVLET / CONTROLLER)
	protected void listarEmprestimo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		emprestimo.setCodigo(codigo);
		
		// EXECUTAR O METODO SELECIONAR EMPRESTIMO
		dao.selecionarEmprestimo(emprestimo);
		// setar os atributos do formulario c/ o conteudo JavaBeans

		request.setAttribute("codigo", emprestimo.getCodigo());
		request.setAttribute("data", emprestimo.getData());
		request.setAttribute("observacao", emprestimo.getObservacao());
		request.setAttribute("usuario", emprestimo.getUsuario());
		request.setAttribute("tipousuario", emprestimo.getTipoUsuario());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarEmprestimo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		emprestimo.setCodigo(request.getParameter("codigo"));
		emprestimo.setData(request.getParameter("data"));
		emprestimo.setObservacao(request.getParameter("observacao"));
		emprestimo.setUsuario(request.getParameter("usuario"));
		emprestimo.setTipoUsuario(request.getParameter("tipousuario"));
		dao.alterarEmprestimo(emprestimo);

		// redirecionar para o documento agenda.jsp atualizando as alterações
		response.sendRedirect("main");
	}

	// EXCLUIR  (SERVLET / CONTROLLER)
	protected void removerEmprestimo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		emprestimo.setCodigo(codigo);
		//TESTE: System.out.println(codigo);
		dao.apagarEmprestimo(emprestimo);

		// redirecionar para o documento agenda.jsp atualizando as alterações
		response.sendRedirect("main");
	}
}