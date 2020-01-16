package server01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
					while(!clientWord.equals("#")) {
					clientWord = inFromClient.readUTF();
					System.out.println(clientWord);
					}
					outToClient.writeUTF("pozdrowienia z serwera");
					outToClient.writeUTF("#");

				}
				
				
				if(clientWord.equals("INSERT ORDER TO DB")) {
					
					Order order = new Order();;
					
					
					
					
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
				
				if(clientWord.equals("INSERT CITY TO DB")) {
					
					String cityName = inFromClient.readUTF();
					
					db.addCity(cityName);
					
				}
				
				if(clientWord.equals("GET MAX ORDER ID")) {
					
					
					outToClient.writeInt(db.getMaxID());
					outToClient.writeInt(-1);
					
				}
				if(clientWord.equals("CHECK ORDER STATUS")) {
					
					int idx = inFromClient.readInt();
					
					String o = db.getOrderStatus(idx);
					
					outToClient.writeUTF(o);
					outToClient.writeUTF("#");
					
				}
				
				if(clientWord.equals("GET ORDER BY ID")) {
					
					int idx = inFromClient.readInt();
					
					String o = db.getOrder(idx);
					
					outToClient.writeUTF(o);
					outToClient.writeUTF("#");
					
					
				}
				
				if(clientWord.equals("CHANGE STATUS")) {
					
					int idx = inFromClient.readInt();
					String s = inFromClient.readUTF();

					db.changeStatus(idx, s);
			
					
					
				}

			}

			catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
