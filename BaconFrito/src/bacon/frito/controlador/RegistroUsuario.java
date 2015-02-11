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
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
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
		// Crea un nuevo usuario en la base de datos con los datos que nos han llegado de la pagina
		// registro de usuarios
		
		String nickUser = request.getParameter("nick");
		String passUser = request.getParameter("pass");
		String pass1User = request.getParameter("pass1");
		String nombreUser = request.getParameter("nombre");
		String apellidosUser = request.getParameter("apellidos");
		String telefonoUser = request.getParameter("telefono");
		String bdayUser = request.getParameter("bday");
		String sexoUser = request.getParameter("sexo");
		String fotoUser = "";
		String activoUser = "true";
		
		if(!passUser.equals(pass1User)){
			// No ha pasado el check de las contraseñas
			System.out.println("validar contraseña");
			request.getRequestDispatcher("PaginaRegistro.jsp").forward(request, response);
			return;
		}
		
		// Miramos si el usuario existe en la base de datos y si existe le mandamos hacia atrás
		
		DbConstructor contructorDb = DbConstructor.getInstance();
		
		try {
			if(contructorDb.buscaUsuario(nickUser)){
				// Hemos encontrado al usuario en la base de datos
				System.out.println("encontrado");
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
		
		//Asignamos una imagen al usuario en funcion de su sexo
		
		if(sexoUser.equals("hombre")){
			fotoUser = "http://1.bp.blogspot.com/-etWXGfUpppc/UhlR3uH7xvI/AAAAAAAAAH4/q0ZMU9BTkFU/s1600/Finn.jpg";
		}
		else if(sexoUser.equals("mujer")){
			fotoUser = "http://images1.wikia.nocookie.net/__cb20120827232753/horadeaventura/es/images/1/13/Minimal_Marceline.jpg";
		}
		
		// Creamos un usuarioBacon para pasárselo a la función que nos insertará el usuario en la
		// base de datos
		
		//Este Id de usuario es provisional y no es válido!!!
		
		UsuarioBacon usuarioAux = new UsuarioBacon(nickUser, passUser, nombreUser,
				apellidosUser, telefonoUser, sexoUser, bdayUser, fotoUser, "usuariobacon",activoUser);
		
		try {
			contructorDb.insertarUsuario(usuarioAux);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Mandamos al usuario a Bienvenida para que inicie sesion
		
		response.sendRedirect("Bienvenida.jsp");
		
		
	}

}
