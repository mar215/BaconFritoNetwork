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
		
		String foto = "";
		
		if(request.getParameter("sexo").equals("hombre")){
			foto = "http://1.bp.blogspot.com/-etWXGfUpppc/UhlR3uH7xvI/AAAAAAAAAH4/q0ZMU9BTkFU/s1600/Finn.jpg";
		}
		else if(request.getParameter("sexo").equals("mujer")){
			foto = "http://images1.wikia.nocookie.net/__cb20120827232753/horadeaventura/es/images/1/13/Minimal_Marceline.jpg";
		}
		
		UsuarioBacon usuario = new UsuarioBacon(request.getParameter("nick"), 
				request.getParameter("pass"), 
				request.getParameter("nombre"), 
				request.getParameter("apellidos"), 
				request.getParameter("telefono"), 
				request.getParameter("sexo"), 
				request.getParameter("bday"), 
				foto, 
				"usuariobacon", 
				"true");
		
		//Comprobamos que las dos contraseñas sean las mismas
		
		if(usuario.getPass()!=null && request.getParameter("pass1")!=null){
			if(!usuario.getPass().equals(request.getParameter("pass1"))){
				// No ha pasado el check de las contraseñas
				response.sendRedirect("ServletConfigPerfil");
				return;
			}
		}
		else if(usuario.getPass()==null || request.getParameter("pass1")==null){
			response.sendRedirect("ServletConfigPerfil");
			return;
		}
		
		//Si llegamos aqui las contraseñas coinciden
		// Miramos si el usuario existe en la base de datos y si existe le mandamos hacia atrás
		
		DbConstructor contructorDb = DbConstructor.getInstance();
		
		try {
			if(contructorDb.buscaUsuario(usuario.getNick())){
				// Hemos encontrado al usuario en la base de datos
				request.getRequestDispatcher("PaginaRegistro.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Solo queda llamar a la funcion que nos va a hacer el update de la fila correspondiente
		// a este usuario
		
		
		
	}

}
