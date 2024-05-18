package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	@Override
	public int compare(Media m1, Media m2) {
		Comparator<Media> comparatorByCost = Comparator.comparing(Media::getCost).reversed();
		Comparator<Media> comparatorByTitle = Comparator.comparing(Media::getTitle);
		
		Comparator<Media> comparatorByCostTitle = comparatorByCost.thenComparing(comparatorByTitle);
		
		return comparatorByCostTitle.compare(m1, m2);
	}
}
