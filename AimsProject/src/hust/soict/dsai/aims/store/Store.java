package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public int getNumber() {
		return itemsInStore.indexOf(itemsInStore.getLast()) + 1;
	}
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("This media is already in the order!");
		} else {
			itemsInStore.add(media);
			System.out.println("The media has been added!");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media has been removed from the order!");
		} else {
			System.out.println("The media is not in the order");
		}
	}
	
	public void checkStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		String str = "No disk found.";
		for (Media media: itemsInStore) {
			if (media.getId() == id) {
				str = media.toString();
			}
		}
		System.out.println(str);
	}
	
	public Media searchByTitle(String title) {
		for (Media media: itemsInStore) {
			if (media.getTitle().equals(title)) return media;
		}
		return null;
	}
	

}
