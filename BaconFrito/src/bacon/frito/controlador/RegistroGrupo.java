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
import bacon.frito.modelo.Grupo;
import bacon.frito.modelo.UsuarioBacon;

/**
 * Servlet implementation class RegistroGrupo
 */
@WebServlet("/RegistroGrupo")
public class RegistroGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroGrupo() {
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
		
		System.out.println("Hola");
		DbConstructor contructor = DbConstructor.getInstance();
		
		int idGrupo = -1;
		String nombreGrupo = request.getParameter("nombre");
		String descripcionGrupo = request.getParameter("descripcion");
		String imagenGrupo = request.getParameter("imagen");
		int maxIntGrupo = Integer.parseInt(request.getParameter("maximos integrantes"));
		String activoGrupo = "true";
		System.out.println("ey");
		
		Grupo grup = new Grupo(idGrupo, nombreGrupo, descripcionGrupo,
				imagenGrupo, maxIntGrupo, activoGrupo);
		System.out.println(grup);
		try {
			if(contructor.buscaGrupo(nombreGrupo)){
				System.out.println("ya existe");
				request.getRequestDispatcher("PaginaCrearGrupo.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("ey4");
		try {
			contructor.insertarGrupo(grup);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(grup);
		response.sendRedirect("PaginaGrupos.jsp");
		
	}
	

}
