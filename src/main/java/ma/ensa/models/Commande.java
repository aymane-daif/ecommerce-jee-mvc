package ma.ensa.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensa.config.ConnDb;

public class Commande {
	private int commandeNum,codeClient,codeArticle;
	private Date dateCommande;
	private List<Article> articles = new ArrayList<>();

	public int createCommande(ConnDb connDb) {
		String sql = "INSERT INTO commande(codeClient, codeArticle, dateCommande) values(?,?,?);";
		int commandeNum = 0;
        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, getCodeClient());
            preparedStatement.setInt(2, getCodeArticle());
            preparedStatement.setDate(3, getDateCommande());

            preparedStatement.executeUpdate();
            
    		String req = "SELECT commandeNum FROM commande WHERE codeClient=? AND codeArticle=? AND dateCommande=?";
    		PreparedStatement ps = connDb.getConn().prepareStatement(req);
    		ps.setInt(1,  getCodeClient());
    		ps.setInt(2, getCodeArticle());
    		ps.setDate(3, getDateCommande());
	        ResultSet resultSet = ps.executeQuery();
	        while(resultSet.next()){
	        	commandeNum = resultSet.getInt("commandeNum");
	       }
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
        return commandeNum;
	}
	
	public static boolean isArticleInCommande(ConnDb connDb, int codeArticle) {
		boolean isExists = false;
		String req = "SELECT commandeNum FROM commande WHERE codeArticle=?";

	    try{
	    	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(req);
	        preparedStatement.setInt(1, codeArticle);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()){
	        	isExists = true;
	       }

	   }catch (SQLException e){
	      e.getMessage();
	   }
	   return isExists;
	}
	

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

	public int getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	} 
}
