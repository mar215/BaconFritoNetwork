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
import bacon.frito.modelo.Mensaje;

/**
 * Servlet implementation class ServletPaginaConsultaMensajes
 */
@WebServlet("/ServletPaginaConsultaMensajes")
public class ServletPaginaConsultaMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaConsultaMensajes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		String user = (String) sesion.getAttribute("user");
		
		DbConstructor constructorDb = DbConstructor.getInstance();
		
		try {
			ArrayList<Mensaje> listaMensajes = constructorDb.dameLista(user);
			request.setAttribute("listaMensajes",listaMensajes);
			request.getRequestDispatcher("PaginaConsultaMensajes.jsp").forward(request,response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al lanzar la Query para obtener los mensajes");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
