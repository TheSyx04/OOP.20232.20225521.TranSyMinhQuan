package hust.soict.dsai.aims.media;

public class Track implements Playable{

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Track)) return false;
		Track m = (Track) o;
		return m.getTitle() == title && m.getLength() == length;
	}
}
