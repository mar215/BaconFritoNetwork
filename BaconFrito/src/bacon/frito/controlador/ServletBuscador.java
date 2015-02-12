package bacon.frito.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bacon.frito.db.DbConstructor;
import bacon.frito.modelo.UsuarioBacon;

/**
 * Servlet implementation class ServletBuscador
 */
@WebServlet("/ServletBuscador")
public class ServletBuscador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cogemos el nick del usuario que nos pasan y lo buscamos en la base de datos
		DbConstructor constructorDb = DbConstructor.getInstance();
		String busqueda = request.getParameter("busqueda");
		
		try {
			
			if(constructorDb.buscaUsuario(busqueda)){
				UsuarioBacon usuarioBusqueda = constructorDb.dameUsuario(busqueda);
				request.setAttribute("usuarioBusqueda", usuarioBusqueda);
				request.getRequestDispatcher("PaginaResultadosBusqueda.jsp").forward(request, response);
			}else{
				response.sendRedirect("PaginaPrincipal.jsp");
			}
			
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
