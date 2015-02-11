package bacon.frito.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Servlet implementation class Pago
 */
@WebServlet("/Pago")
public class Pago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String REST_URI = "http://localhost:8080/FriedBaconBank/rest/servicio/payday";
	//static final String PAGO	 = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pago() {
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
		// Recibe mediante POST los par�metros de pago: user, pass y cantidad
		
		if(request.getParameter("user") == null
		   || request.getParameter("pass") == null
		   || request.getParameter("amount") == null){
			System.out.println("(Servlet Pago) Error al recibir los par�metros en POST");
			return;
		}
		
		ClientConfig 	config  = new DefaultClientConfig();
		Client			client  = Client.create(config);
		WebResource		service	= client.resource(REST_URI);
		String respuesta;
		
		respuesta = service.queryParam("user", request.getParameter("user"))
						   .queryParam("pass", request.getParameter("pass"))
						   .queryParam("amount", request.getParameter("amount"))
						   .accept(MediaType.TEXT_PLAIN)
						   .get(String.class);
		
		System.out.println(respuesta);
		
	}

}
