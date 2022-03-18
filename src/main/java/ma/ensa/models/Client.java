package ma.ensa.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ma.ensa.config.ConnDb;

public class Client {
	private String email, nom, prenom, adresse, ville, tel, motDePasse, role;
	private int codePostal,id;
	
	public void createClient(ConnDb connDb) {
		String sql = "INSERT INTO client(email, nom, prenom, adresse, ville, tel, motDePasse, codePostal, role) values(?,?,?,?,?,?,?,?,?);";
        String isClientExistsSql = "SELECT * from client WHERE email=?;";

        try {
        	PreparedStatement stExists = connDb.getConn().prepareStatement(isClientExistsSql);
        	stExists.setString(1, getEmail());
        	stExists.executeQuery();
        	if(!stExists.getResultSet().next()) {
        		PreparedStatement preparedStatement = connDb.getConn().prepareStatement(sql);
                preparedStatement.setString(1, getEmail());
                preparedStatement.setString(2, getNom());
                preparedStatement.setString(3, getPrenom());
                preparedStatement.setString(4, getAdresse());
                preparedStatement.setString(5, getVille());
                preparedStatement.setString(6, getTel());
                preparedStatement.setString(7, getMotDePasse());
                preparedStatement.setInt(8, getCodePostal());
                preparedStatement.setString(9, getRole());

                preparedStatement.executeUpdate();
        	}
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	public boolean logIn(ConnDb connDb) {
        String isClientExistsSql = "SELECT * from client WHERE email=? AND motDePasse=?;";

        try {
        	PreparedStatement stExists = connDb.getConn().prepareStatement(isClientExistsSql);
        	stExists.setString(1, getEmail());
        	stExists.setString(2, getMotDePasse());
        	stExists.executeQuery();
        	if(stExists.getResultSet().next()) {
        		return true;
        	}
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
		return false;
	}
	
	public static Client getClientByEmail(ConnDb connDb, String email) {
        String sql = "SELECT id,email,nom,prenom,role from client WHERE email=?;";
        Client client = new Client();
        try {
        	PreparedStatement preparedSt = connDb.getConn().prepareStatement(sql);
        	preparedSt.setString(1, email);
        	ResultSet resultSet = preparedSt.executeQuery();
        	
	        while(resultSet.next()){
	        	client.setEmail(resultSet.getString("email"));
	        	client.setNom(resultSet.getString("nom"));
	        	client.setPrenom(resultSet.getString("prenom"));
	        	client.setId(resultSet.getInt("id"));
	        	client.setRole(resultSet.getString("role"));
	        }
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
		return client;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
