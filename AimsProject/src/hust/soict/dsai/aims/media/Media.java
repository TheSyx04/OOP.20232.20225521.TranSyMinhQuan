package hust.soict.dsai.aims.media;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}


	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Media)) return false;
		Media m = (Media) o;
		return m.getTitle() == title;
	}

}
