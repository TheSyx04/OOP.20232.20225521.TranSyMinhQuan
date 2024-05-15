package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println("This media is already in the order!");
		} else {
			itemsOrdered.add(media);
			System.out.println("The media has been added!");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed from the order!");
		} else {
			System.out.println("The media is not in the order");
		}
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		String str = "No disk found.";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				str = itemsOrdered.get(i).toString();
			}
		}
		System.out.println(str);
	}
	
	public void searchByTitle(String title) {
		String str = "No disk found.";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				str = itemsOrdered.get(i).toString();
			}
		}
		System.out.println(str);
	}
}
