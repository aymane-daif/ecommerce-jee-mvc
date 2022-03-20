package ma.ensa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.config.ConnDb;
import ma.ensa.models.Article;
import ma.ensa.models.Client;
import ma.ensa.models.Commande;



public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConnDb connDb;   
    
    public CommandeController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int codeArticle = Integer.parseInt(request.getParameter("codeArticle"));
		Article article = Article.getArticleById(connDb, codeArticle);
		
		if(session.getAttribute("commande") != null) {
			Commande sessionCommande = (Commande)session.getAttribute("commande");
			sessionCommande.getArticles().add(article);
		}else {
			Commande newCommande = new Commande();
			Client currentClient = (Client)session.getAttribute("currentClient");

			newCommande.setCodeClient(currentClient.getId());
			newCommande.getArticles().add(article);
			session.setAttribute("commande", newCommande);
		}
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
