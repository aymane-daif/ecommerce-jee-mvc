package ma.ensa.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ma.ensa.config.ConnDb;

public class LigneCommande {
	private int codeArticle, commandeNum, quantite;
	
	public void createLigneCommande(ConnDb connDb) {
		String sql = "INSERT INTO ligneCommande(codeArticle, commandeNum) values(?,?);";

        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, getCodeArticle());
            preparedStatement.setInt(2, getCommandeNum());

            preparedStatement.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	public static int getLigneCommandeQte(ConnDb connDb, int codeArticle,int commandeNum) {
		int qte = 0;
		String req = "SELECT * FROM ligneCommande WHERE codeArticle=? AND commandeNum=?";

	    try{
	    	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(req);
	        preparedStatement.setInt(1, codeArticle);
	        preparedStatement.setInt(2, commandeNum);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()){
	        	qte = resultSet.getInt("quantite");
	       }

	   }catch (SQLException e){
	      e.getMessage();
	   }
	   return qte;
	}
	
	public static void updateLigneCommandeQuantite(ConnDb connDb, int codeArticle, int commandeNum, int qte) {
		String sql = "UPDATE ligneCommande SET quantite=? WHERE codeArticle=? AND commandeNum=?;";

        try {
        	PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, qte);
            preparedStatement.setInt(2, codeArticle);
            preparedStatement.setInt(3, commandeNum);

            preparedStatement.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}

	public int getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(int codeArticle) {
		this.codeArticle = codeArticle;
	}

	public int getCommandeNum() {
		return commandeNum;
	}

	public void setCommandeNum(int commandeNum) {
		this.commandeNum = commandeNum;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
