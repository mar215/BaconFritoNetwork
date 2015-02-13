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
import bacon.frito.modelo.Mensaje;

/**
 * Servlet implementation class EnvioMensajes
 */
@WebServlet("/EnvioMensajesGrupo")
public class EnvioMensajesGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvioMensajesGrupo() {
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
		// Este servlet recibe por método post el destino del mensaje y el texto y lo manda a la base
		// de datos para que se almacene.
		
		String destino = request.getParameter("destino");
		String origen = request.getParameter("origen");
		String mensaje = request.getParameter("mensaje");
		
		// creamos un objeto tipo mensaje que mandaremos a la funcion que lo introduce en la DB
		
		Mensaje mensajeAux = new Mensaje(-1, mensaje, destino, origen);
		
		DbConstructor constructorDb = DbConstructor.getInstance();
		
		try {
			constructorDb.mensajeGrupal(mensajeAux);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Mandamos al usuario de nuevo a la pagina de Mensajes por si quiere mandar otro.
		
		response.sendRedirect("PaginaMensajesGrupo.jsp");
		
	}

}
