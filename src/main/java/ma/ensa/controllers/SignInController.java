package ma.ensa.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Client;

public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnDb connDb;   
    
    public SignInController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.getServletContext()
		.getRequestDispatcher("/vue/home.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = new Client();
		client.setEmail(request.getParameter("email"));
		client.setMotDePasse(request.getParameter("motDePasse"));

		boolean isValidClient = client.logIn(connDb);
		if(isValidClient){
			HttpSession session = request.getSession();
			Client currentClient = Client.getClientByEmail(connDb, request.getParameter("email"));
			session.setAttribute("currentClient", currentClient);
			doGet(request, response);
		}else {
			request.setAttribute("invalidUser", true);
			this.getServletContext()
			.getRequestDispatcher("/vue/signup.jsp")
			.forward(request, response);
		}

	}

	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}
}
