package ma.ensa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
	private int commandeNum,codeClient;
	private Date dateCommande;
	private List<Article> articles = new ArrayList<>();

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getCommandeNum() {
		return commandeNum;
	}

	public void setCommandeNum(int commandeNum) {
		this.commandeNum = commandeNum;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	} 
}
