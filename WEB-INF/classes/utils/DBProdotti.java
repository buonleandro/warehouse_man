package utils;

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
	private String username = "userwc";
	private String password = "passwc";
	private String dbName = "wcDatabase";
	private String tableName = "prodotti";
	private Properties userInfo;
	private int i = 0;


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
		
		Prodotto[] prodotti = {
				new Prodotto("a", "a", "images/trasparentone.png", 1.0, "a", "a","a","a", "?a", 1)
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
			
			String query = String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", tableName);
			PreparedStatement inserter =
					connection.prepareStatement(query);
			for(Prodotto p:prodotti){
				inserter.setInt(1, i++);
				inserter.setString(2, p.getNome());
				inserter.setString(3, p.getSN());
				inserter.setDouble(4, p.getPrezzo());
				inserter.setString(5, p.getTipo());
				inserter.setString(6, p.getMarca());
				inserter.setString(7, p.getDb());
				inserter.setString(8, p.getDl());
				inserter.setString(9, p.getImglnk());
				inserter.setString(10, p.getLnk());
				inserter.setInt(11, p.getNum());
				inserter.executeUpdate();
			}
			inserter.close();
			
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
			String query = "SELECT * FROM prodotti";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
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
				Prodotto prod = new Prodotto(nome, sn, lnkimg, prezzo, tipo, marca, db, dl, lnk, num);
				prods.add(prod);
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
			String query = String.format("INSERT INTO %s VALUES(?,?,?,?,?,?,?,?,?,?,?)", tableName);
			PreparedStatement inserter =
					connection.prepareStatement(query);
				inserter.setInt(1, i++);
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
				inserter.toString();
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
	
}
