package br.com.consultemed.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.consultemed.model.Medico;
import br.com.consultemed.service.MedicosBusiness;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/admin/medicos")
public class MedicoController extends HttpServlet {

	private static final String ID_MEDICO = "id";

	private static final String TELEFONE_MEDICO = "telefone";

	private static final String EMAIL_MEDICO = "email";

	private static final String NOME_MEDICO = "nome";

	@Inject
	private MedicosBusiness business;

	private static final long serialVersionUID = 1L;

	public MedicoController() {
		this.business = new MedicosBusiness();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getParameter(Constantes.ACTION);

		try {
			switch (action) {
			case Constantes.NOVO:
				novo(request, response);
				break;
			case Constantes.DELETE:
				delete(request, response);
				break;
			case Constantes.EDITAR:
				editar(request, response);
				break;
			case Constantes.LISTAR :
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.MEDICOS);
		Collection<Medico> medicos = this.business.listAll();
		request.setAttribute("medicos", medicos);
		rd.forward(request, response);
		
	}

	/**
	 * Prepara formulário para cadastro de um novo medico
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_MEDICOS);
		rd.forward(request, response);
	}

	/**
	 * Cadastro de um novo medico
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter(NOME_MEDICO);
		String email = request.getParameter(EMAIL_MEDICO);
		String telefone = request.getParameter(TELEFONE_MEDICO);
		String id = request.getParameter(ID_MEDICO);
		
			
		Medico medico = new Medico();
		medico.setEmail(email);
		medico.setNome(nome);
		medico.setTelefone(telefone);
		
		if(id != "") {
			medico.setId(Long.parseLong(id));
			request.setAttribute("editado", Constantes.MEDICO + " " + nome + Constantes.MEDICO_EDITADO);
		}else {
			request.setAttribute("cadastro", Constantes.MEDICO + " "+ nome + Constantes.MEDICO_SUCESSO);			
		}
		try {
			this.business.save(medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			list(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que remove um medico do banco de dados
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		
		this.business.deleteById(Long.parseLong(request.getParameter(ID_MEDICO)));
		request.setAttribute("remover", Constantes.MEDICO + Constantes.MEDICO_REMOVIDO);
		
		try {
			list(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que edita um medico
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void editar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {

		Medico medico = this.business.findById(Long.parseLong(request.getParameter(ID_MEDICO)));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_MEDICOS);
		request.setAttribute("medico", medico);
		rd.forward(request, response);
	}

}
