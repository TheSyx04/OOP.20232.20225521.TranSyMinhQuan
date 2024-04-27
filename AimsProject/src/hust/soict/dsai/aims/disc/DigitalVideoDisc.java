package hust.soict.dsai.aims.disc;

import java.util.Objects;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private int id;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public int getID() {
		return id;
	}
	public float getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public boolean isMatch(String title) {
		return this.title.equals(title);
	}
	
	@Override
	public String toString() {
		String res = id + ". DVD - " + title;
		res += (category == null) ? "" : (" - " + category);
		res += (director == null) ? "" : (" - " + director);
		res += (length == 0) ? "" : (" - " + length);
		res += (": " + cost + "$");
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(category, cost, director, length, title);
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
		return Objects.equals(category, other.category)
				&& Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
				&& Objects.equals(director, other.director) && length == other.length
				&& Objects.equals(title, other.title);
	}
	
}
