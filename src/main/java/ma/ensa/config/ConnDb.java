package ma.ensa.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDb {
    
    private Connection conn;
    private Statement st;
    
    public ConnDb(String url, String driver, String username, String password){
        try{
        	Class.forName(driver);
        	conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();	

        	String clientSt = "CREATE TABLE IF NOT EXISTS client (id SERIAL NOT NULL, role VARCHAR(10), email VARCHAR(70) UNIQUE, nom VARCHAR(100), prenom VARCHAR(100), tel VARCHAR(20), adresse VARCHAR(70), ville VARCHAR(20), codePostal INT, motDePasse VARCHAR(255), CONSTRAINT pk_client PRIMARY KEY(id));";
        	String commandeSt = "CREATE TABLE IF NOT EXISTS commande (commandeNum SERIAL NOT NULL, codeClient INT, codeArticle INT, dateCommande DATE, CONSTRAINT pk_commande PRIMARY KEY(commandeNum), CONSTRAINT fk_client FOREIGN KEY(codeClient) REFERENCES client(id), CONSTRAINT fk_article FOREIGN KEY(codeArticle) REFERENCES article(codeArticle));";
        	String categorieSt = "CREATE TABLE IF NOT EXISTS categorie (refCat SERIAL NOT NULL, nomCat VARCHAR(70), CONSTRAINT pk_categorie PRIMARY KEY(refCat));";
        	String articleSt = "CREATE TABLE IF NOT EXISTS article (codeArticle SERIAL NOT NULL, designation VARCHAR(255),titre VARCHAR(70), prix decimal, stock INT, refCat INT, CONSTRAINT pk_article PRIMARY KEY(codeArticle), CONSTRAINT fk_categorie FOREIGN KEY(refCat) REFERENCES categorie(refCat));";
        	String ligneCmdSt = "CREATE TABLE IF NOT EXISTS ligneCommande (codeArticle INT, commandeNum INT, quantite INT DEFAULT 1, CONSTRAINT pk_ligneCommande PRIMARY KEY(codeArticle, commandeNum));";

        	st.executeUpdate(clientSt);
        	st.executeUpdate(categorieSt);
        	st.executeUpdate(articleSt);
        	st.executeUpdate(commandeSt);
        	st.executeUpdate(ligneCmdSt);

            System.out.println("Tables are created...");
        } catch (SQLException | ClassNotFoundException e) {
        	System.out.println("connection failed...");
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Statement getSt(){
        return st;
    }
    
    public Connection getConn(){
        return conn;
    }
}
