package ma.ensa.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensa.config.ConnDb;

public class Categorie {
	private int refCat;
	private String nomCat;
	
	public void createCategorie(ConnDb connDb) {
		String sql = "INSERT INTO categorie(nomCat) values(?);";

        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setString(1, getNomCat());

            preparedStatement.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	public static List<Categorie> getCategories(ConnDb connDb) {
		List<Categorie> categories = new ArrayList<>();
		String req = "SELECT * FROM categorie";

	     try{
	           ResultSet resultSet = connDb.getSt().executeQuery(req);
	           while(resultSet.next()){
	        	   Categorie singleCategorie = new Categorie();
	        	   singleCategorie.setRefCat(resultSet.getInt("refCat"));
	        	   singleCategorie.setNomCat(resultSet.getString("nomCat"));

	        	   categories.add(singleCategorie);
	            }

	     }catch (SQLException e){
	            e.getMessage();
	     }
	     return categories;
	}
	
	public int getRefCat() {
		return refCat;
	}
	public void setRefCat(int refCat) {
		this.refCat = refCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
}
