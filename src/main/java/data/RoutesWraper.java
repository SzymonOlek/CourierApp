package data;

import java.util.ArrayList;

public class RoutesWraper {

	ArrayList<String> Cities= new ArrayList<String>();
	ArrayList<String> Cities2= new ArrayList<String>();
	ArrayList<Integer> distance= new ArrayList<Integer>();

	
	public ArrayList<String> getCities() {
		return Cities;
	}
	public void setCities(ArrayList<String> cities) {
		Cities = cities;
	}
	public RoutesWraper(ArrayList<String> cities, ArrayList<String> cities2, ArrayList<Integer> distance) {
		super();
		Cities = cities;
		Cities2 = cities2;
		this.distance = distance;
	}
	public ArrayList<String> getCities2() {
		return Cities2;
	}
	public void setCities2(ArrayList<String> cities2) {
		Cities2 = cities2;
	}
	public ArrayList<Integer> getDistance() {
		return distance;
	}
	public void setDistance(ArrayList<Integer> distance) {
		this.distance = distance;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
