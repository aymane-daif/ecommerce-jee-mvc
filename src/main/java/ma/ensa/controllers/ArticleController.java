package ma.ensa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Article;
import ma.ensa.models.Categorie;


public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnDb connDb;
       
    
    public ArticleController() {
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
		Article newArticle = new Article();
		newArticle.setTitre(request.getParameter("titre"));
		newArticle.setDesignation(request.getParameter("designation"));
		newArticle.setPrix(Double.parseDouble(request.getParameter("prix")));
		newArticle.setStock(Integer.parseInt(request.getParameter("stock")));
		newArticle.getCategorie().setRefCat(Integer.parseInt(request.getParameter("categorie")));
		
		newArticle.createArticle(connDb);
		
		List<Article> articles = Article.getArticles(connDb);
		request.setAttribute("articles", articles);
		this.getServletContext()
		.getRequestDispatcher("/vue/articles.jsp")
		.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}

}
