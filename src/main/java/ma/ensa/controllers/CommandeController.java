package ma.ensa.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
import ma.ensa.models.LigneCommande;



public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConnDb connDb;   
    
    public CommandeController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("connDb", connDb);
		this.getServletContext()
		.getRequestDispatcher("/vue/commande.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client currentClient = (Client)session.getAttribute("currentClient");

		LigneCommande ligneCommande = new LigneCommande();
		
		int codeArticle = Integer.parseInt(request.getParameter("codeArticle"));
		Article article = Article.getArticleById(connDb, codeArticle);
		
		if(article.getStock() > 0) {
			Article.updateArticleStock(connDb, codeArticle, article.getStock() - 1);
			
			if(session.getAttribute("commandes") != null) {
				List<Commande> sessionCommandes = (List<Commande>)session.getAttribute("commandes");
				int commandeNum = -1;

				for(Commande cmd:sessionCommandes) {
					if(cmd.getCodeArticle() == codeArticle && cmd.getCodeClient() == currentClient.getId()) {
						commandeNum = cmd.getCommandeNum();
					}
				}
				
				
				if(commandeNum == -1){
					Commande newCommande = new Commande();
					newCommande.setCodeClient(currentClient.getId());
					newCommande.setCodeArticle(codeArticle);
					newCommande.setDateCommande(new Date(System.currentTimeMillis()));
					int cmdNum = newCommande.createCommande(connDb);
					newCommande.setCommandeNum(cmdNum);
					sessionCommandes.add(newCommande);
					
					ligneCommande.setCodeArticle(codeArticle);
					ligneCommande.setCommandeNum(cmdNum);
					ligneCommande.createLigneCommande(connDb);
				}else {
					int prevQte = LigneCommande.getLigneCommandeQte(connDb, codeArticle, commandeNum);
					LigneCommande.updateLigneCommandeQuantite(connDb, codeArticle, commandeNum, prevQte + 1);
				}
				
			}else {
				List<Commande> commandes = new ArrayList<>();
				Commande newCommande = new Commande();
				newCommande.setCodeClient(currentClient.getId());
				newCommande.setCodeArticle(codeArticle);
				newCommande.setDateCommande(new Date(System.currentTimeMillis()));
				int cmdNum = newCommande.createCommande(connDb);
				newCommande.setCommandeNum(cmdNum);
				commandes.add(newCommande);
				
				ligneCommande.setCodeArticle(codeArticle);
				ligneCommande.setCommandeNum(cmdNum);
				ligneCommande.createLigneCommande(connDb);
				
				session.setAttribute("commandes", commandes);
			}
			
		}else {
			// article out of stock
		}
		
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		connDb = (ConnDb)this.getServletContext().getAttribute("connDb");
	}

}
