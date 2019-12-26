package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Kurier.Order;

public class Database {

	
//	final String driver = "com.mysql.jdbc.Driver";
	final String driver = "com.mysql.cj.jdbc.Driver";
	
	final String url = "jdbc:mysql://localhost:3306/kurier?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	Connection con;
	
	
// TODO przerobic baze danych na serwer
	
	public Database(){
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpasswd");
			System.out.println("Connected to DATABASE");
		} catch (SQLException e) {

			System.out.println("Problem z  polaczeniem z baza danych");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Problem z  connectorem");
			e.printStackTrace();
		}
		

	}
	
	
	public ResultSet sqlStatement(String statement) {
		
		Statement stmt=null;
		ResultSet result=null;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery(statement);
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}
	
	public int execSQLStatement(String statement) {
		
		Statement stmt=null;
		
		try {
		stmt = con.createStatement();
		
		return stmt.executeUpdate(statement);
		
		} catch (SQLException e) {
			System.out.println("Problem z wyslanym zapytaniem do bazy sql");
			e.printStackTrace();
		}
		
		return -1;
		
		
	}
	
	public void addCity(String name) {
		
		this.execSQLStatement("INSERT INTO `city` (`name`) VALUES ('"+name+"');");
		
	}
	
	public ResultSet getOrder(int index) {
		
		
		Statement stmt=null;
		ResultSet result=null;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `order` where id_order="+index);
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public void addOrder(Order o) {
		
		this.execSQLStatement("INSERT INTO `order` (`name`, `surname`, `weight`, `high`, `width`, `length`, `adressTo`, `adressFrom`, `phoneNumber`) "
				+ "VALUES ('"+o.getName() +"', '"+o.getSurname()+"', '"+o.getWeight()+"', '"+o.getHigh()+"', '"+o.getWidth()+"', '"+o.getLength()+
				"', '"+o.getAdressTo()+"', '"+o.getAdressTo()+"', '"+o.getPhoneNumber()+"');");
	}
	
	public void showData(ResultSet wynik) {
		
		try {
			
			while(wynik.next()) {
				for(int i=1;i<11;i++) {
					
					Object obj  = wynik.getObject(i);
					
					System.out.println(obj.toString());
					
				}
			}
		
		
		} catch (SQLException e) {
			System.out.println("Blad podczas wypisywania danych z tabeli");

			e.printStackTrace();
		}
		
		
	}
	
	public ResultSet getCity(int index) {
		
		
		Statement stmt=null;
		ResultSet result=null;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `city` where id_city="+index);
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		return result;
				
	}

	
	public ResultSet getCity() {
		
		
		Statement stmt=null;
		ResultSet result=null;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `city`");
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public ResultSet getOrder() {
		
		
		Statement stmt=null;
		ResultSet result=null;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `order`");
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public String getMaxID() {
		
		
		Statement stmt=null;
		ResultSet result=null;
		
		Integer index=0;
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select max(id_order) from `order`");
		
				while(result.next()) {
					
					Object obj  = result.getObject(1);
					
					index=(Integer)obj;
			}
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z pobraniem ID zamownia");
//			e.printStackTrace();
		}
		
		
		
		
		return index.toString();
	}
	
	
}
