package bacon.frito.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bacon.frito.db.DbConstructor;
import bacon.frito.modelo.UsuarioBacon;

/**
 * Servlet implementation class ServletConfigPerfil
 */
@WebServlet("/ServletConfigPerfil")
public class ServletConfigPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfigPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Las llamadas get a este servlet se harán desde el menu de navegación y nos
		// redirecciona a la página de modificación de los datos.
		
		HttpSession sesion = request.getSession();
		String user = (String) sesion.getAttribute("user");
		DbConstructor constructorDb = DbConstructor.getInstance();
		
		try {
			UsuarioBacon usuario = constructorDb.dameUsuario(user);
			sesion.setAttribute("usuarioCambioConfig", usuario);
			response.sendRedirect("PaginaConfigUsuario.jsp");
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
		// Recibimos por POST los datos nuevos que el usuario quiere actualizar y los mandamos
		// a la base de datos para que se actualicen en la base de datos.
		
		
		
	}

}
