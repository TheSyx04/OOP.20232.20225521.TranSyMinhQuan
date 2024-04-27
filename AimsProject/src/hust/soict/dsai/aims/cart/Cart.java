package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered + 1 == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc disc: dvdList) {
			addDigitalVideoDisc(disc);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("There are no disks in the cart.");
		} else {
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i].equals(disc)) {
					System.out.println(itemsOrdered[i].getTitle() + " has been removed.");
					for(int j = i; j < qtyOrdered - 1; j++) {
						itemsOrdered[j] = itemsOrdered[j+1];
					}
					break;
				}
			}
		}
		qtyOrdered--;
	}
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}

	// The method checkCart is implemented to test question 11 only.
	public void checkCart() {
		if (qtyOrdered > 0) {
			System.out.println("Number of disks in the cart: " + qtyOrdered);
			System.out.println("The disks in the cart: ");
			for (int i = 0; i < qtyOrdered; i++) {
				System.out.println(itemsOrdered[i].getTitle());
			}
			System.out.println();
		} else {
			System.out.println("Your cart has no disk.");
		}	
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		String str = "No disk found.";
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getID() == id) {
				str = itemsOrdered[i].toString();
			}
		}
		System.out.println(str);
	}
	
	public void searchByTitle(String title) {
		String str = "No disk found.";
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				str = itemsOrdered[i].toString();
			}
		}
		System.out.println(str);
	}
}
