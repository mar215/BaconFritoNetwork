package gft.luzti.java.controlador;

import gft.luzti.java.bd.DBHelper;
import gft.luzti.java.modelo.Cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Nuevo
 */
public class Nuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nuevo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s 	= request.getSession();	
		DBHelper 	dbh	= DBHelper.getInstance();
		
		if(s.isNew() == true 
				|| s.getAttribute("valida") == null 
				|| ((Boolean) s.getAttribute("valida")) != true){
			Cliente cliente = new Cliente(request.getParameter("user"), 
										  request.getParameter("pass"), 
										  request.getParameter("nombre"), 
										  request.getParameter("apellidos"), 
										  request.getParameter("dni"), 
										  dbh.addCuenta(Double.parseDouble(request.getParameter("saldo"))));
			dbh.addCliente(cliente);
			s.setAttribute("nombre", request.getParameter("user"));
			s.setAttribute("valida", true);
			response.sendRedirect("User");
			
		}else{
			response.sendRedirect("index.jsp");
		}
		
	}

}
