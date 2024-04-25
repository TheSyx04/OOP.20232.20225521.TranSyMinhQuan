
public class Store {
	private final int MAX_STORE_DISK = 100000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_STORE_DISK];
	public int numDiskStore = 0;
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[numDiskStore] = dvd;
		numDiskStore++;
		System.out.println("The disc has been added.");
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		if (numDiskStore == 0) {
			System.out.println("There are no disks in the store.");
		} else {
			for (int i = 0; i < numDiskStore; i++) {
				if (itemsInStore[i].equals(dvd)) {
					System.out.println(itemsInStore[i].getTitle() + " has been removed.");
					for(int j = i; j < numDiskStore - 1; j++) {
						itemsInStore[j] = itemsInStore[j+1];
					}
					break;
				}
			}
		}
		numDiskStore--;
	}
	
	public void checkStore() {
		if (numDiskStore > 0) {
			System.out.println("Number of disks in the store: " + numDiskStore);
			System.out.println("The disks in the store: ");
			for (int i = 0; i < numDiskStore; i++) {
				System.out.println(itemsInStore[i].getTitle());
			}
			System.out.println();
		} else {
			System.out.println("The store has no disk.");
		}
	}
}
