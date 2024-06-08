package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Book(List<String> authors) {
		super();
		this.authors = authors;
	}

	public Book(String title, String category, float cost) {
		
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("The author is already in the book!");
		} else {
			authors.add(authorName);
			System.out.println("The author has been added!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author has been removed!");
		} else {
			System.out.println("The author is not in the book!");
		}
	}
	
	@Override
	public String toString() {
		String res = this.getId() + ". DVD - " + this.getTitle();
		res += (this.getCategory() == null) ? "" : (" - " + this.getCategory());
		res += (": " + this.getCost() + "$");
		return res;
	}

}
