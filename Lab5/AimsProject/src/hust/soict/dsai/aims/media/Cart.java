package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public int getNumber() {
		return itemsOrdered.indexOf(itemsOrdered.getLast()) + 1;
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
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
		} else if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is full, cannot add new media!");
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
	
	public Media searchByID(int id) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				return itemsOrdered.get(i);
			}
		}
		return null;
	}
	
	public Media searchByTitle(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				return itemsOrdered.get(i);
			}
		}
		return null;
	}
	
	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

}
