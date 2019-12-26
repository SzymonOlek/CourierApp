
package Kurier;


public class Order {

	
	String name;
	String surname;
	int weight;
	int high;
	int width;
	int length;
	String adressTo;
	String adressFrom;
	String phoneNumber;

	
	public Order(String name, String surname, int weight, int high, int width, int length, String adressTo,
			String adressFrom, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.weight = weight;
		this.high = high;
		this.width = width;
		this.length = length;
		this.adressTo = adressTo;
		this.adressFrom = adressFrom;
		this.phoneNumber = phoneNumber;
	}
	
	public Order() {}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getAdressTo() {
		return adressTo;
	}
	public void setAdressTo(String adressTo) {
		this.adressTo = adressTo;
	}
	public String getAdressFrom() {
		return adressFrom;
	}
	public void setAdressFrom(String adressFrom) {
		this.adressFrom = adressFrom;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	
}
