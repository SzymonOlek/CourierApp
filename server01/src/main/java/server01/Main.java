package server01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String clientWord;
		System.out.println("server01 zaczyna");
		Database db = new Database();

		while (true) {
			try (ServerSocket welcomeSocket = new ServerSocket(5555);
					Socket connectionSocket = welcomeSocket.accept();
					DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());) {

				clientWord = inFromClient.readUTF();
				System.out.println(clientWord);

				System.out.println("Sprawdzanie poprawnosci danych");
				System.out.println("Podano \"" + clientWord + "\"");

				if (clientWord.equals("query")) {
					while (!clientWord.equals("#")) {
						clientWord = inFromClient.readUTF();
						System.out.println(clientWord);
					}
					outToClient.writeUTF("pozdrowienia z serwera");
					outToClient.writeUTF("#");

				}

				if (clientWord.equals("INSERT ORDER TO DB")) {

					Order order = new Order();
					;

					order.setName(inFromClient.readUTF());
					order.setSurname(inFromClient.readUTF());
					order.setWeight(inFromClient.readInt());

					order.setHigh(inFromClient.readInt());

					order.setWidth(inFromClient.readInt());

					order.setLength(inFromClient.readInt());
					order.setAdressTo(inFromClient.readUTF());
					order.setAdressFrom(inFromClient.readUTF());
					order.setPhoneNumber(inFromClient.readUTF());

					db.addOrder(order);

				}

				if (clientWord.equals("INSERT CITY TO DB")) {

					String cityName = inFromClient.readUTF();

					db.addCity(cityName);

				}

				if (clientWord.equals("GET MAX ORDER ID")) {

					outToClient.writeInt(db.getMaxID());
					outToClient.writeInt(-1);

				}
				if (clientWord.equals("CHECK ORDER STATUS")) {

					int idx = inFromClient.readInt();

					String o = db.getOrderStatus(idx);

					outToClient.writeUTF(o);
					outToClient.writeUTF("#");

				}

				if (clientWord.equals("GET ORDER BY ID")) {

					int idx = inFromClient.readInt();

					String o = db.getOrder(idx);

					outToClient.writeUTF(o);
					outToClient.writeUTF("#");

				}

				if (clientWord.equals("CHANGE STATUS")) {

					int idx = inFromClient.readInt();
					String s = inFromClient.readUTF();

					db.changeStatus(idx, s);

				}

				if (clientWord.equals("GET CITY NAMES")) {

					ArrayList<String> cities = db.getCities();

					for (String s : cities) {

						outToClient.writeUTF(s);

					}
					outToClient.writeUTF("#");
				}

				if (clientWord.equals("GET ORDERS TO CALCULATE")) {

					ResultSet resultSet = db.getOrder();

					int skipOrders = inFromClient.readInt();
					

					String status;
					
					int id;
					
					int count=0 - (7*skipOrders);
					
					try {
						while (resultSet.next()) {

							Object obj = resultSet.getObject(11);

							status = (String) obj;

							if (status.equals("przyjete") && count < 8 && count >=0) {
								count++;
								outToClient.writeUTF((String) resultSet.getObject(9));
								outToClient.writeUTF((String) resultSet.getObject(8));
								outToClient.writeUTF((String) resultSet.getObject(2));
								outToClient.writeUTF((String) resultSet.getObject(3));
								outToClient.writeUTF((String) resultSet.getObject(10));
								outToClient.writeInt((int) resultSet.getObject(5));
								outToClient.writeInt((int) resultSet.getObject(4));
								outToClient.writeInt((int) resultSet.getObject(6));
								outToClient.writeInt((int) resultSet.getObject(7));
								id=(int)resultSet.getObject(1);
								outToClient.writeInt(id);
								
							}

						}
					} catch (SQLException e) {
				
						e.printStackTrace();
					}

					outToClient.writeUTF("#");
				}
				
				if (clientWord.equals("GET ROUTES")) {
				
					ResultSet resultSet = db.getRoutes();
				
					try {
						while (resultSet.next()) {
//							outToClient.writeInt((int) resultSet.getObject(1)); // id 
							outToClient.writeUTF((String) resultSet.getObject(2));   // first place
							outToClient.writeUTF((String) resultSet.getObject(3));    // second place
							outToClient.writeInt((int) resultSet.getObject(4));  // distance 
						
							
					
						}
						} catch (SQLException e) {
					
							e.printStackTrace();
						}
					
					outToClient.writeUTF("#");
					
				}
				
				
				if (clientWord.equals("GET ORDERS TO CALCULATE SENDING")) {

					ResultSet resultSet = db.getOrder();
					
					int skipOrders = inFromClient.readInt();

					String status;
					
					int id;
					
					int count=0 - (7*skipOrders);
					
					try {
						while (resultSet.next()) {

							Object obj = resultSet.getObject(11);

							status = (String) obj;

							if (status.equals("w trakcie realizacji") && count < 8 && count>=0) {
								count++;
								outToClient.writeUTF((String) resultSet.getObject(9));
								outToClient.writeUTF((String) resultSet.getObject(8));
								outToClient.writeUTF((String) resultSet.getObject(2));
								outToClient.writeUTF((String) resultSet.getObject(3));
								outToClient.writeUTF((String) resultSet.getObject(10));
								outToClient.writeInt((int) resultSet.getObject(5));
								outToClient.writeInt((int) resultSet.getObject(4));
								outToClient.writeInt((int) resultSet.getObject(6));
								outToClient.writeInt((int) resultSet.getObject(7));
								id=(int)resultSet.getObject(1);
								outToClient.writeInt(id);
								
							}
						}
					} catch (SQLException e) {
				
						e.printStackTrace();
					}

					outToClient.writeUTF("#");
				}
				
				
				
				

			}

			catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
