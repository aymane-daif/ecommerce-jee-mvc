package ma.ensa.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Client;


public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnDb connDb;   
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
		.getRequestDispatcher("/vue/signin.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client newClient = new Client();
		newClient.setNom(request.getParameter("nom"));
		newClient.setPrenom(request.getParameter("prenom"));
		newClient.setEmail(request.getParameter("email"));
		newClient.setTel(request.getParameter("tel"));
		newClient.setAdresse(request.getParameter("adresse"));
		newClient.setVille(request.getParameter("ville"));
		newClient.setMotDePasse(request.getParameter("motDePasse"));
		newClient.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));

		newClient.createClient(connDb);
		
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}

}
