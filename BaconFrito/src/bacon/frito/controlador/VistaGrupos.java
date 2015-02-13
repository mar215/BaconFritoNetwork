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
import bacon.frito.modelo.Grupo;
import bacon.frito.modelo.Mensaje;


/**
 * Servlet implementation class VistaGrupos
 */
@WebServlet("/VistaGrupos")
public class VistaGrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaGrupos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConstructor mapa = DbConstructor.getInstance();
		
		HttpSession sesion = request.getSession();
		
		try {
			System.out.println("point 1");
			ArrayList<Grupo> listaGrupos = mapa.listarGrupos();
			System.out.println("point 2");
			for(Grupo g : listaGrupos){
				System.out.println("point 3");
				System.out.println(g.getNombre());
			}
			System.out.println("point 4");
			sesion.setAttribute("grupos",listaGrupos);
			System.out.println("point 5");
			response.sendRedirect("PaginaGrupos.jsp");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
