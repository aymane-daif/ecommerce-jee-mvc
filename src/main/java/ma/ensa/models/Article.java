package ma.ensa.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensa.config.ConnDb;

public class Article {
	private int codeArticle, stock;
	private String designation, titre;
	private double prix;
	private Categorie categorie = new Categorie();
	
	public void createArticle(ConnDb connDb) {
		String sql = "INSERT INTO article(titre, designation, prix, stock, refCat) values(?,?,?,?,?);";

        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setString(1, getTitre());
            preparedStatement.setString(2, getDesignation());
            preparedStatement.setDouble(3, getPrix());
            preparedStatement.setInt(4, getStock());
            preparedStatement.setInt(5, getCategorie().getRefCat());

            preparedStatement.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	public static List<Article> getArticles(ConnDb connDb) {
		List<Article> articles = new ArrayList<>();
		String req = "SELECT titre,prix,nomCat FROM article,categorie WHERE article.refCat=categorie.refCat";

	     try{
	           ResultSet resultSet = connDb.getSt().executeQuery(req);
	           while(resultSet.next()){
	        	   Article singleArticle = new Article();
	        	   singleArticle.setTitre(resultSet.getString("titre"));
	        	   singleArticle.setPrix(resultSet.getDouble("prix"));
	        	   singleArticle.getCategorie().setNomCat(resultSet.getString("nomCat"));

	        	   articles.add(singleArticle);
	            }

	     }catch (SQLException e){
	            e.getMessage();
	     }
	     return articles;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
