package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author olena.viliuzhanina
 *
 */
public class HelloServlet extends HttpServlet {

	private String message;
	
	public void init() throws ServletException{
		message = "Hello Kitty";
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1>" + message + "</h1>");
	}
	
	public void destroy(){
		
	}
}
