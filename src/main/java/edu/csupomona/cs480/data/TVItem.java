package edu.csupomona.cs480.data;

public class TVItem {

	private String title;
	private String price;
	private String imageUrl;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "TVItem [title=" + title + ", price=" + price + ", imageUrl=" + imageUrl + "]";
	}
	
}
