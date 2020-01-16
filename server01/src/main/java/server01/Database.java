package server01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server01.Order;

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
	
	public String getOrder(int index) {
		
		
		Statement stmt=null;
		ResultSet result=null;
		String wynik="";
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `order` where id_order="+index);
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		try {
			
			while(result.next()) {
//				for(int i=1;i<11;i++) {
					
					Object obj  = result.getObject(2);
					wynik += "\nImie zamawiajacego: " +(String) obj;
					obj  = result.getObject(3);
					wynik += "\nNazwisko zamawiajacego: " +(String) obj;
					obj  = result.getObject(4);
					wynik += "\nWaga przesylki: " +(int) obj;
					
					obj  = result.getObject(5);
					int x,y,z;
					x=(int) obj;
					obj  = result.getObject(6);
					y=(int) obj;
					obj  = result.getObject(7);
					z=(int) obj;
					wynik += "\nwymiary przesylki " +x+"x"+y+"x"+z;
					obj  = result.getObject(8);
					wynik += "\nAdres dostawy: " +(String) obj;
					obj  = result.getObject(9);
					wynik += "\nAdres nadania: " +(String) obj;
					obj  = result.getObject(10);
					wynik += "\nNumer telefonu: " +(String) obj;
					obj  = result.getObject(11);
					wynik += "\nStan zamowienia: " +(String) obj;
					
				
			}
		
		
		} catch (SQLException e) {
			System.out.println("Blad podczas wypisywania danych z tabeli");

			e.printStackTrace();
		}
		
		return wynik;
				
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
	
	public Integer getMaxID() {
		
		
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
		
		
		
		
		return index;
	}
	

	public String getOrderStatus(int index) {
		
		
		Statement stmt=null;
		ResultSet result=null;
		String wynik="";
		
		try {
		stmt = con.createStatement();
		
		result = stmt.executeQuery("select * from `order` where id_order="+index);
		
		System.out.println(result.toString());
		
		} catch (SQLException e) {
			System.out.println("Problem z  zapytaniem sql");
			e.printStackTrace();
		}
		
		try {
			
			while(result.next()) {
//				for(int i=1;i<11;i++) {
					
					Object obj = result.getObject(11);
					wynik += "Stan zamowienia: " +(String) obj;
					
				
			}
		
		
		} catch (SQLException e) {
			System.out.println("Blad podczas wypisywania danych z tabeli");

			e.printStackTrace();
		}
		
		return wynik;
				
	}
	
	public void changeStatus(int id,String status) {
		if(status.equals("zrealizowane"))
		this.execSQLStatement("UPDATE `order` SET `stan` = 'zrealizowane' WHERE `order`.`id_order` = "+id);
		if(status.equals("w trakcie realizacji"))
		this.execSQLStatement("UPDATE `order` SET `stan` = 'w trakcie realizacji' WHERE `order`.`id_order` = "+id);
			
	}
	
	
	
}
