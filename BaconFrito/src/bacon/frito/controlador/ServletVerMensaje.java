package bacon.frito.controlador;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bacon.frito.modelo.Mensaje;

/**
 * Servlet implementation class ServletVerMensaje
 */
@WebServlet("/ServletVerMensaje")
public class ServletVerMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerMensaje() {
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
		HttpSession sesion = request.getSession();
		if(sesion.getAttribute("user")!=null){
			Mensaje mensajeAux = new Mensaje(Integer.parseInt(request.getParameter("id")),
					request.getParameter("texto"),
					request.getParameter("destino"),
					request.getParameter("origen"),
					(Date)request.getAttribute("fechaMensaje"));
			
			request.setAttribute("mensaje", mensajeAux);
			request.getRequestDispatcher("PaginaVerMensaje.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("Bienvenida.jsp");
		}
	}

}
