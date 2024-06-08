package hust.soict.dsai.aims.media;

public class Disc extends Media{
	
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(int id, String title, String category, float cost) {
		this(id, title, category, null, 0, cost);
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
	}
	
	public Disc(String title) {
		
	}

}
