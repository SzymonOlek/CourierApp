package data;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import Kurier.Order;

public class Server {

	
	public Server() {
		
	}
	
	
	public void useServer(String dataToTransfer) {
		
		String displayBytes;

			try (Socket clientSocket = new Socket("localhost", 5555);
					DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {
				System.out.println("wysylanie danych");
				outToServer.writeUTF("query");
				outToServer.writeUTF("2 "+dataToTransfer);
				outToServer.writeUTF("3 "+dataToTransfer);

				outToServer.writeUTF("#");

				outToServer.flush();

				while (!(displayBytes = inFromServer.readUTF()).equals("#")) {
					System.out.println(displayBytes);
				}
				System.out.println("zakonczono czytanie ");
			}

			catch (Exception ex) {
				ex.printStackTrace();

			} 

		
		
	}
	
	public void insertToDB(String dataToInsert) {
		

		String displayBytes;

			try (Socket clientSocket = new Socket("localhost", 5555);
					DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

				outToServer.writeUTF("INSERT DATA TO DB");
				outToServer.writeUTF(dataToInsert);
				outToServer.flush();

//				while (!(displayBytes = inFromServer.readUTF()).equals("#")) {
//					System.out.println(displayBytes);
//				}
				System.out.println("zakonczono zapisywanie danych ");
			}

			catch (Exception ex) {
				ex.printStackTrace();

			} 

		
		
	}
	
	
	public void addOrder(Order order) {

			try (Socket clientSocket = new Socket("localhost", 5555);
					DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

				outToServer.writeUTF("INSERT ORDER TO DB");
				
				/*	String name;
	String surname;
	int weight;
	int high;
	int width;
	int length;
	String adressTo;
	String adressFrom;
	String phoneNumber; */
				
				outToServer.writeUTF(order.getName());
				outToServer.writeUTF(order.getSurname());
				outToServer.writeInt(order.getWeight());
				outToServer.writeInt(order.getHigh());
				outToServer.writeInt(order.getWidth());
				outToServer.writeInt(order.getLength());
				outToServer.writeUTF(order.getAdressTo());
				outToServer.writeUTF(order.getAdressFrom());
				outToServer.writeUTF(order.getPhoneNumber());
				
				outToServer.flush();


				System.out.println("zakonczono zapisywanie danych ");
			}

			catch (Exception ex) {
				ex.printStackTrace();

			} 

		
		
	}
	
	
	public int getMaxOrderID() {
		
	int index=-1;
	Integer data;

		try (Socket clientSocket = new Socket("localhost", 5555);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

			outToServer.writeUTF("GET MAX ORDER ID");
			
			while (!(data = inFromServer.readInt()).equals(-1)) {
				if(!data.equals(-1)) {
					index=data;
				}
			}

			System.out.println("zakonczono zapisywanie danych ");
		}

		catch (Exception ex) {
			ex.printStackTrace();

		} 

	return index;
}
	public String getOrderByID(int id) {
		
	String o=null;
	String data;

		try (Socket clientSocket = new Socket("localhost", 5555);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

			outToServer.writeUTF("GET ORDER BY ID");
			outToServer.writeInt(id);
			
			while (!(data = inFromServer.readUTF()).equals("#")) {
					o=data;
			}

			System.out.println("zakonczono wczytywanie zamowienia");
		}

		catch (Exception ex) {
			ex.printStackTrace();

		} 

	return o;

}
	public String checkOrderStatus(int id) {
		
	String o=null;
	String data;

		try (Socket clientSocket = new Socket("localhost", 5555);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

			outToServer.writeUTF("CHECK ORDER STATUS");
			outToServer.writeInt(id);
			
			while (!(data = inFromServer.readUTF()).equals("#")) {
					o=data;
			}

			System.out.println("zakonczono wczytywanie zamowienia");
		}

		catch (Exception ex) {
			ex.printStackTrace();

		} 

	return o;

}
	
	public void changeStatus(int id,String status) {


		try (Socket clientSocket = new Socket("localhost", 5555);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {

			outToServer.writeUTF("CHANGE STATUS");
			outToServer.writeInt(id);
			outToServer.writeUTF(status);
			
		}

		catch (Exception ex) {
			ex.printStackTrace();

		} 

}
}
