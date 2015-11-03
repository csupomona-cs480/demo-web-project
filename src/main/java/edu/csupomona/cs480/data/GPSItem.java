package edu.csupomona.cs480.data;

public class GPSItem {

	private String name;
	private String price;

	public GPSItem() {

	}

	public GPSItem(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
