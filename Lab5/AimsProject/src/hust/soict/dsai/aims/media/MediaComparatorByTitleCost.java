package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	@Override
	public int compare(Media m1, Media m2) {
		Comparator<Media> comparatorByTitle = Comparator.comparing(Media::getTitle);
		Comparator<Media> comparatorByCost = Comparator.comparing(Media::getCost).reversed();
		
		Comparator<Media> comparatorByTitleCost = comparatorByTitle.thenComparing(comparatorByCost);
		
		return comparatorByTitleCost.compare(m1, m2);
	}
}
