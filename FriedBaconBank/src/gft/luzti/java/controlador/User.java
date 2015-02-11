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
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s 	= request.getSession();	
		DBHelper 	dbh	= DBHelper.getInstance();
		
		if(s.isNew() == true 
				|| s.getAttribute("valida") == null 
				|| ((Boolean) s.getAttribute("valida")) != true){
			
			response.sendRedirect("index.jsp");
		}else{
			Cliente cliente = dbh.getCliente((String) s.getAttribute("nombre"));
			if(cliente == null){
				System.out.println("no puede serrlrlrlr");
				return;
			}
			s.setAttribute("cliente", cliente);
			response.sendRedirect("user.jsp");
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
