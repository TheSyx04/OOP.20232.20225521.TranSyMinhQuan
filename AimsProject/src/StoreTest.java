
public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store storeA = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		storeA.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		storeA.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		storeA.addDVD(dvd3);
		storeA.checkStore();
		
		storeA.removeDVD(dvd3);
		storeA.checkStore();
		
		System.out.println();
		
		storeA.searchByID(1);
		
		System.out.println();
		
		storeA.searchByTitle("Aladin");
		
	}

}
