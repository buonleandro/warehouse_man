package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

		try {
			Connection connection = getConnection();					
			Statement statement = connection.createStatement();
			String format = "VARCHAR(80)";
			String lnkimg = "VARCHAR(256)";
			String format2 = "VARCHAR(750)";
			String table =
					String.format
					("CREATE TABLE %s" +
							"(id INT, nome %s, SN %s, prezzo DOUBLE, tipo %s, marca %s, db %s, dl %s, " +
							"lnkimg %s, lnk %s, num INT)",
							tableName, format, format, format, format, format, format2, lnkimg, format);
			statement.execute(table);
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
	
	public void aggiungiProdotto(String sn, String nome, String tipo, String marca, double prezzo, String desb, String desl, int pezzi, String img) {
		
		try{
			Connection connection = getConnection();
			System.out.println("Fatto");
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
