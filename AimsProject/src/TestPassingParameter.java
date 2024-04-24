class DVDWrapper {
	DigitalVideoDisc dvd;

	public DVDWrapper(DigitalVideoDisc dvd) {
		super();
		this.dvd = dvd;
	}
	
}

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		DVDWrapper jungleDVDWrapper = new DVDWrapper(jungleDVD);
		DVDWrapper cinderellaDVDWrapper = new DVDWrapper(cinderellaDVD);
		
		swap(jungleDVDWrapper, cinderellaDVDWrapper);
		
		jungleDVD = jungleDVDWrapper.dvd;
		cinderellaDVD = cinderellaDVDWrapper.dvd;
		
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DVDWrapper dvdw1, DVDWrapper dvdw2) {
		DigitalVideoDisc tmp = dvdw1.dvd;
		dvdw1.dvd = dvdw2.dvd;
		dvdw2.dvd = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
