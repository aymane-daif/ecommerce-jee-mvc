package ma.ensa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Categorie;


public class AddArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnDb connDb;
       
    public AddArticleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = Categorie.getCategories(connDb);
		request.setAttribute("categories", categories);
				
		this.getServletContext()
		.getRequestDispatcher("/vue/createArticle.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}

}
