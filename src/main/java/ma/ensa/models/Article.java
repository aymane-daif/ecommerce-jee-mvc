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
		String req = "SELECT codeArticle,titre,prix,stock,nomCat FROM article,categorie WHERE article.refCat=categorie.refCat AND article.stock > 0;";

	     try{
	           ResultSet resultSet = connDb.getSt().executeQuery(req);
	           while(resultSet.next()){
	        	   Article singleArticle = new Article();
	        	   singleArticle.setCodeArticle(resultSet.getInt("codeArticle"));;
	        	   singleArticle.setTitre(resultSet.getString("titre"));
	        	   singleArticle.setPrix(resultSet.getDouble("prix"));
	        	   singleArticle.setStock(resultSet.getInt("stock"));
	        	   singleArticle.getCategorie().setNomCat(resultSet.getString("nomCat"));

	        	   articles.add(singleArticle);
	            }

	     }catch (SQLException e){
	            e.getMessage();
	     }
	     return articles;
	}
	
	public static Article getArticleById(ConnDb connDb, int id) {
		Article article = new Article();
		String req = "SELECT * FROM article WHERE codeArticle=?";

	    try{
	    	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(req);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()){
	        	article.setCodeArticle(resultSet.getInt("codeArticle"));
	        	article.setTitre(resultSet.getString("titre"));
	        	article.setDesignation(resultSet.getString("designation"));
	        	article.setStock(resultSet.getInt("stock"));
	        	article.setPrix(resultSet.getDouble("prix"));
	        	article.getCategorie().setNomCat(resultSet.getString("nomCat"));
	       }

	   }catch (SQLException e){
	      e.getMessage();
	   }
	   return article;
	}
	
	public static void updateArticleStock(ConnDb connDb, int codeArticle, int stock) {
		String sql = "UPDATE article SET stock=? WHERE codeArticle=?;";

        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, codeArticle);

            preparedStatement.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
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

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;

        if(!(obj instanceof Article)) return false;

        Article a = (Article) obj;

        return a.codeArticle == this.codeArticle;
	}
	
	
}
