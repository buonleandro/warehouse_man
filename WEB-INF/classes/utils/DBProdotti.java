package utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBProdotti {
	private String protocol = "jdbc:derby:";   
	private String username = "user";
	private String password = "pass";
	private String dbName = "wcDatabase";
	private String tableName = "prodotti";
	private String table2Name = "utenti";
	private Properties userInfo;
	private int id;

	public DBProdotti() {
		userInfo = new Properties();
		userInfo.put("user", username);
		userInfo.put("pass", password);
	}

	protected Connection getConnection()
			throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		String dbUrl = protocol + dbName + ";create=true";
		Connection connection = DriverManager.getConnection(dbUrl, userInfo);
		return(connection);
	}

	public void createDatabase() {

		Utente[] utenti = {
				new Utente("admin", "admin"),
				new Utente("admin2", "admin2"),
		};

		try {
			Connection connection = getConnection();

			Statement statement = connection.createStatement();
			String format = "VARCHAR(80)";
			String lnkimg = "VARCHAR(256)";
			String format2 = "VARCHAR(750)";
			String table =
					String.format
					("CREATE TABLE %s" +
							"(id INT NOT NULL, nome %s NOT NULL, SN %s NOT NULL, prezzo DOUBLE NOT NULL, tipo %s NOT NULL, marca %s NOT NULL, db %s NOT NULL, dl %s NOT NULL, " +
							"lnkimg %s, lnk %s NOT NULL, num INT NOT NULL)",
							tableName, format, format, format, format, format, format2, lnkimg, format);
			statement.execute(table);
			
			Statement statementuser = connection.createStatement();
			String usr = "VARCHAR(25)";
			String pss = "VARCHAR(25)";
			String table2 =
					String.format
					("CREATE TABLE %s" +
							"(name %s, pass %s)",
							table2Name, usr, pss);
			statementuser.execute(table2);

			String template2 =
					String.format("INSERT INTO %s VALUES(?, ?)",
							table2Name);
			PreparedStatement inserter2 =
					connection.prepareStatement(template2);
			for(Utente e: utenti) {
				inserter2.setString(1, e.getUser());
				inserter2.setString(2, e.getPass());
				inserter2.executeUpdate();
				//System.out.println("Inserito "+e.getUser()+" "+e.getPass());
			}
			inserter2.close();

			connection.close();
			System.out.println("Database creato");
		} catch (SQLException sqlException) {
			if (sqlException.getErrorCode() == 1007) {
				System.out.println("Errore " + sqlException.getMessage());
			} else {
				sqlException.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public List<Prodotto> showAll() {

		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti ORDER BY id ASC";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
	}
	
	public Prodotto showSingle(int id) {

		Prodotto prod = null;
		
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE id="+id;
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}
	
	public List<Prodotto> ricercaSn(String seriale) {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE SN='"+seriale+"'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> ricerca(String name, String mc) {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE nome='"+name+"' AND marca='"+mc+"'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> tv() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='TV'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> PC() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='COMPUTER & TABLET'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> cell() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='TELEFONIA & SMARTPHONE'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> elettro() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='ELETTRODOMESTICI'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> foto() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='FOTOCAMERE'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}
	
	public List<Prodotto> console() {
		
		List<Prodotto> prods = new ArrayList<Prodotto>();

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM prodotti WHERE tipo='CONSOLE'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String sn = resultSet.getString("SN");
				Double prezzo = resultSet.getDouble("prezzo");
				String tipo = resultSet.getString("tipo");
				String marca = resultSet.getString("marca");
				String db = resultSet.getString("db");
				String dl = resultSet.getString("dl");
				String lnkimg = resultSet.getString("lnkimg");
				int num = resultSet.getInt("num");
				String lnk = resultSet.getString("lnk");
				if(num!=0){
					Prodotto prod = new Prodotto(id, nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
					prod.getNome();
					prods.add(prod);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
		
	}

	public void aggiungiProdotto(String sn, String nome, String tipo, String marca, double prezzo, String desb, String desl, int pezzi, String img) {

		try{
			Connection connection = getConnection();
			Statement statement2 = connection.createStatement();
			String query2 = "SELECT MAX(id) FROM prodotti";
			ResultSet idM = statement2.executeQuery(query2);
			String query = String.format("INSERT INTO %s VALUES(?,?,?,?,?,?,?,?,?,?,?)", tableName);
			PreparedStatement inserter =
					connection.prepareStatement(query);
			while(idM.next()){
				id=idM.getInt(1)+1;
				//System.out.println("id del prodotto="+id);
			}
			inserter.setInt(1, id);
			inserter.setString(2, nome);
			inserter.setString(3, sn);
			inserter.setDouble(4, prezzo);
			inserter.setString(5, tipo);
			inserter.setString(6, marca);
			inserter.setString(7, desb);
			inserter.setString(8, desl);
			inserter.setString(9, img);
			inserter.setString(10, "?"+sn);
			inserter.setInt(11, pezzi);
			inserter.executeUpdate();
			inserter.close();
			connection.close();
			System.out.println("Prodotto inserito");
		} catch (SQLException sqlException) {
			if (sqlException.getErrorCode() == 1007) {
				System.out.println("Errore! " + sqlException.getMessage());
			} else {
				sqlException.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public void aggiornaProdotto(int id, String nome, String SN, String tipo, String marca, String db, String dl, int num, double prezzo) throws Exception{
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		String query =
				String.format("SELECT * FROM %s WHERE id ="+id,
						tableName);
		ResultSet queryResult = statement.executeQuery(query);
		queryResult.next();
		String template =
				String.format("UPDATE %s SET nome ='"+(nome)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template);
		String template2 =
				String.format("UPDATE %s SET SN ='"+(SN)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template2);
		String template3 =
				String.format("UPDATE %s SET tipo ='"+(tipo)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template3);
		String template4 =
				String.format("UPDATE %s SET marca ='"+(marca)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template4);
		String template5 =
				String.format("UPDATE %s SET db ='"+(db)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template5);
		String template6 =
				String.format("UPDATE %s SET dl ='"+(dl)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template6);
		String template7 =
				String.format("UPDATE %s SET num ="+(num)+" WHERE id ="+id,
						tableName);
		statement.executeUpdate(template7);
		String template8 =
				String.format("UPDATE %s SET lnk = '?"+(SN)+"' WHERE id ="+id,
						tableName);
		statement.executeUpdate(template8);
		String template9 =
				String.format("UPDATE %s SET prezzo ="+(prezzo)+" WHERE id ="+id,
						tableName);
		statement.executeUpdate(template9);
		connection.close();
	}

	public void rimuoviDalDB(int id, String img) throws Exception{
		Connection connection = getConnection();
		Statement statement2 = connection.createStatement();
		String query =
				String.format("SELECT * FROM %s WHERE id ="+id,
						tableName);
		ResultSet queryResult = statement2.executeQuery(query);
		queryResult.next();
		String template =
				String.format("DELETE FROM %s WHERE id ="+id,
						tableName);
		statement2.executeUpdate(template);
		File f = new File(img);
		f.delete();
		connection.close();
	}
	
	public boolean cfrLogin(String user, String pass){
		
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM utenti";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				if(resultSet.getString("name").equals(user) && resultSet.getString("pass").equals(pass)){
					return true;
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
