package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
	
	public String play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
			
			String info = "Playing Track: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
			return info;
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
			}
		}
		
	
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Track)) return false;
		Track m = (Track) o;
		return m.getTitle() == title && m.getLength() == length;
	}
}
