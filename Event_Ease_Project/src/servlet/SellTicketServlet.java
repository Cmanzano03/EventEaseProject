package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jabsorb.client.Session;

import com.google.gson.Gson;

import bean.*;
import exceptions.notFoundElementException;

import javax.servlet.http.Cookie;
public class SellTicketServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//Inicializar atributos de sesion 
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Leer parametros de request/Json y de sesión 
		int eventId;
		double ticketPrice;
		HttpSession session;
		User user;
		
		session = req.getSession();
		user = (User)session.getAttribute("user");
		eventId = Integer.parseInt(req.getParameter("eventId"));
		
		
		//Crear objeto SellTicketService y llamar a sus metodos 
		SellTicketService sellTicketService = new SellTicketService(eventId);
		
		if(!sellTicketService.isSoldedOut()) { //We verify that we can keep selling tickets
			ticketPrice = sellTicketService.getTicketPrice();
			//Tareas asociadas a la compra , decidir como hacer 
			
			// Ahora creamos el ticket que ha sido comprado y lo añadimos a la estructura de datos, asociandolo al usuario y al evento, 
			try {
				sellTicketService.createTicket(eventId, user.getId());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (notFoundElementException e) {
				e.printStackTrace();
			}
			
		}else {
			PrintWriter writer = resp.getWriter();
			//Devolver mensaje de que se ha producido un soldOut o redirigir a pagina html en la que lo ponga 
		}
		
	}
	
}
