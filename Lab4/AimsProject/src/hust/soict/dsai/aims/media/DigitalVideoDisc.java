package hust.soict.dsai.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(int id, String title) {
		this(id, title, null, null, 0, 0.0f);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		this(id, title, category, null, 0, cost);
	}
	public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
		this(id, title, category, director, 0, cost);
	}
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs++, title, category, director, length, cost);
	}
	
	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public String toString() {
		String res = this.getId() + ". DVD - " + this.getTitle();
		res += (this.getCategory() == null) ? "" : (" - " + this.getCategory());
		res += (this.getDirector() == null) ? "" : (" - " + this.getDirector());
		res += (this.getLength() == 0) ? "" : (" - " + this.getLength());
		res += (": " + this.getCost() + "$");
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getCategory(), this.getCost(), this.getDirector(), this.getLength(), this.getTitle());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigitalVideoDisc other = (DigitalVideoDisc) obj;
		return Objects.equals(this.getCategory(), other.getCategory())
				&& Float.floatToIntBits(this.getCost()) == Float.floatToIntBits(other.getCost())
				&& Objects.equals(this.getDirector(), other.getDirector()) 
				&& this.getLength() == other.getLength()
				&& Objects.equals(this.getTitle(), other.getTitle());
	}
	
}
