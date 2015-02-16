package gft.luzti.java.controlador;

import gft.luzti.java.bd.DBHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s 	= request.getSession();	
		DBHelper 	dbh	= DBHelper.getInstance();			
		if(dbh.login(request.getParameter("user"), request.getParameter("pass"))){
			s.setAttribute("nombre", request.getParameter("user"));
			s.setAttribute("valida", true);
			response.sendRedirect("User");
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
