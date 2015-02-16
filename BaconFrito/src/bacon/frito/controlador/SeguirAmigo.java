package bacon.frito.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bacon.frito.db.DbConstructor;
import bacon.frito.modelo.GrupoUsuario;

/**
 * Servlet implementation class SeguirAmigo
 */
@WebServlet("/SeguirAmigo")
public class SeguirAmigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguirAmigo() {
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
		// TODO Auto-generated method stub
		
		DbConstructor constructor = DbConstructor.getInstance();
		HttpSession sesion = request.getSession();
		String laSesion=(String)sesion.getAttribute("user");
		String destino = request.getParameter("id");
		
		try {
			constructor.seguir(laSesion, destino);
			response.sendRedirect("ServletPaginaPrincipal");
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
