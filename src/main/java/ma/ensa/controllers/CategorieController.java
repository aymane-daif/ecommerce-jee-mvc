package ma.ensa.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Categorie;


public class CategorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConnDb connDb;
   
    public CategorieController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
		.getRequestDispatcher("/vue/createCategorie.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categorie newCategorie = new Categorie();
		newCategorie.setNomCat(request.getParameter("nomCat"));

		newCategorie.createCategorie(connDb);
		
		this.getServletContext()
		.getRequestDispatcher("/vue/home.jsp")
		.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}

}
