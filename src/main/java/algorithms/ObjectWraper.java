package algorithms;

import java.util.ArrayList;

import Kurier.Order;

public class ObjectWraper {

	 ArrayList<Order> orders;
	 ArrayList<Integer> ordersID;
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Integer> getOrdersID() {
		return ordersID;
	}
	public ObjectWraper(ArrayList<Order> orders, ArrayList<Integer> ordersID) {
		super();
		this.orders = orders;
		this.ordersID = ordersID;
	}
	public void setOrdersID(ArrayList<Integer> ordersID) {
		this.ordersID = ordersID;
	}
	
	
	 
	 
	
	
	
	
	
	
	
}
