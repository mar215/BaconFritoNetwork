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
 * Servlet implementation class entrarGrupo
 */
@WebServlet("/entrarGrupo")
public class entrarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entrarGrupo() {
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
		
		int idgrupo = Integer.parseInt(request.getParameter("id"));
		System.out.println(idgrupo);
		DbConstructor constructor = DbConstructor.getInstance();
		HttpSession sesion = request.getSession();
		String laSesion=(String)sesion.getAttribute("user");
		GrupoUsuario grupusu = new GrupoUsuario(laSesion, idgrupo);
		
		try {
			constructor.insertarGrupoUsuario(grupusu);
			ArrayList<GrupoUsuario> lista = constructor.entrarGrupo(laSesion, idgrupo);			
			
			sesion.setAttribute("id", lista);
			response.sendRedirect("VistaGrupos");
			
			System.out.println("Hola");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
