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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// Comprobamos session por si el usuario ha accedido directamente
		/*boolean activo = (boolean) request.getSession().getAttribute("activo");
		if(activo == true && (String) request.getSession().getAttribute("user") != null){
			response.sendRedirect("PaginaPrincipal.jsp");
		}*/
		
		// Recibimos los par�metros del login en el POST	
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		//Buscamos si el usuario est� en la base de datos y si est� validamos su password
		DbConstructor constructorDb = DbConstructor.getInstance();
		try {
			if(constructorDb.buscaUsuario(user)){
				UsuarioBacon usuario = constructorDb.dameUsuario(user);
				if(usuario.login(pass)){
					//Si el usuario pasa el check guardamos su nombre en la sesion y le mandamos a
					//la p�gina de inicio de la red social
					HttpSession sesion = request.getSession();
					sesion.setAttribute("user", user);
					boolean activa = true;
					sesion.setAttribute("activo", activa);
					sesion.setAttribute("tipoUsuario", usuario.getTipo());
					response.sendRedirect("ServletPaginaPrincipal");
				}else{
					//Si falla le mandamos a bienvenida para que se logee
					response.sendRedirect("Bienvenida.jsp");
				}
			}else{
				//Si no hay usuario le mandamos a la pagina de bienvenida por si ha metido mal el user
				response.sendRedirect("Bienvenida.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
