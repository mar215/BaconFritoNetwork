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

/**
 * Servlet implementation class NuevoEstado
 */
@WebServlet("/NuevoEstado")
public class NuevoEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoEstado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Bienvenida.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		if(sesion.getAttribute("user") == null){
			if (sesion.getAttribute("activo") ==  null){
				if((Boolean) sesion.getAttribute("activo") == false){
					response.sendRedirect("Bienvenida.jsp");
				}
			}
		}else{
			if(request.getParameter("usuario") == null || request.getParameter("texto") == null){
				response.sendRedirect("Bienvenida.jsp");
			}
			DbConstructor db = DbConstructor.getInstance();
			try {
				db.nuevaNotif(request.getParameter("usuario"), request.getParameter("texto"));
			} catch (SQLException | NamingException e) {
				System.err.println("Error al añadir nueva notificación (NuevoEstado)");
				e.printStackTrace();
			}
			response.sendRedirect("ServletPaginaPrincipal");
		}
	}

}
