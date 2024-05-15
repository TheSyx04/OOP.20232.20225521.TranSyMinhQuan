package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
		System.out.println("The disc has been added.");
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		if (itemsInStore.contains(dvd)) {
			itemsInStore.remove(dvd);
			System.out.println("The disc has been removed");
		} else {
			System.out.println("The disc is not in the store to be removed");
		}
	}
	
	public void checkStore() {
		for(DigitalVideoDisc dvd: itemsInStore) {
			System.out.println(dvd.toString());
		}
	}
	
	public void searchByID(int id) {
		String str = "No disk found.";
		for (DigitalVideoDisc dvd: itemsInStore) {
			if (dvd.getId() == id) {
				str = dvd.toString();
			}
		}
		System.out.println(str);
	}
	
	public void searchByTitle(String title) {
		String str = "No disk found.";
		for (DigitalVideoDisc dvd: itemsInStore) {
			if (dvd.isMatch(title)) {
				str = dvd.toString();
			}
		}
		System.out.println(str);
	}
}
