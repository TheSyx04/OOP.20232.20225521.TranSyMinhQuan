package hust.soict.dsai.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		this(title, null, null, 0, 0.0f);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title, category, null, 0, 0.0f);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, director, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
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
		res += (director == null) ? "" : (" - " + director);
		res += (length == 0) ? "" : (" - " + length);
		res += (": " + this.getCost() + "$");
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getCategory(), this.getCost(), director, length, this.getTitle());
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
				&& Objects.equals(director, other.director) 
				&& length == other.length
				&& Objects.equals(this.getTitle(), other.getTitle());
	}
	
}
