package gft.luzti.java.controlador;

import gft.luzti.java.bd.DBHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddSaldo
 */
public class AddSaldo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSaldo() {
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
			
			response.sendRedirect("index.jsp");
		}else{
			dbh.addSaldo(dbh.getCliente((String) s.getAttribute("user")).getCuenta().getNumeroCuenta()
						, Double.parseDouble(request.getParameter("saldo")));
			response.sendRedirect("User");
		}
		
	}

}
