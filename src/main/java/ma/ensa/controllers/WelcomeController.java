package ma.ensa.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.config.ConnDb;

public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnDb connDb;   
    
    public WelcomeController() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
		String url = this.getServletContext().getInitParameter("url");  
		String driver = this.getServletContext().getInitParameter("driver");  
		String username = this.getServletContext().getInitParameter("username");  
		String password = this.getServletContext().getInitParameter("password");  

		connDb = new ConnDb(url, driver, username, password);	
		getServletContext().setAttribute("connDb", connDb);
	}

	@Override
	public void destroy() {
		super.destroy();
		connDb.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath());
		this.getServletContext()
		.getRequestDispatcher("/vue/welcome.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
