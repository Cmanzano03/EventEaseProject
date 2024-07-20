package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import bean.RequestData;
import bean.SellTicketService;
import bean.User;
import exceptions.notFoundElementException;

//Devolver al usuario: Tickets(todos) o Eventos(todos o por búsqueda)
public class UserServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		gson = new Gson();
		//Inicializar atributos de sesion 
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Leer parametros de request/Json y de sesión 
		HttpSession session;
		String user;
		
		session = req.getSession();
		user = (String)session.getAttribute("user");
		
		
		 // Read the JSON data from the request body
        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }
        
        // Convert JSON data to a String
        String jsonString = jsonBuilder.toString();
        
        // Create a Gson instance
        Gson gson = new Gson();
        
        try {
            // Convert JSON String to RequestData object
            RequestData requestData = gson.fromJson(jsonString, RequestData.class);
            
            // Use requestData as needed
            if(requestData.getTipo().equals("evento")) {

            }
            else if(requestData.getTipo().equals("ticket")) {
            	
            }
            

            // Respond to the client
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(requestData));
        } catch (JsonSyntaxException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON format");
        }
	}

}
