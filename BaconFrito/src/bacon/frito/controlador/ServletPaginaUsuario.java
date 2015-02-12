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
import bacon.frito.modelo.Notificacion;
import bacon.frito.modelo.UsuarioBacon;

/**
 * Servlet implementation class ServletPaginaUsuario
 */
@WebServlet("/ServletPaginaUsuario")
public class ServletPaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hola estoy en el servlet");
		HttpSession sesion = request.getSession();
		String user = (String) sesion.getAttribute("user");
		DbConstructor constructorDb = DbConstructor.getInstance();
		try {
			
			UsuarioBacon usuario = constructorDb.dameUsuario(user);
			sesion.setAttribute("usuario", usuario);
			ArrayList<Notificacion> notif = constructorDb.damePerfilUsuario(user);
			sesion.setAttribute("notifications", notif);
			response.sendRedirect("PaginaUsuario.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
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
