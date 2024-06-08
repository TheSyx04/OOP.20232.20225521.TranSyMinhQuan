package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public CompactDisc(int id, String title, String category, String director, int length, float cost,
			String artist, List<Track> tracks) {
		super(id, title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track is already in the list!");
		} else {
			tracks.add(track);
			System.out.println("The track has been added!");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track has been removed!");
		} else {
			System.out.println("The track is not in the list!");
		}
	}
	
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());

            String info = "Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength() + "\n";

            for (Track t : tracks) {
                try {
                    String trackInfo = t.play();
                    info = info + trackInfo + "\n";
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return info;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

    }
	
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
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

}
