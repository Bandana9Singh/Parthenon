package com.olyumpus.parthenon.artemis.beans.volume;

import java.util.List;

public class Info {
	private String title;
	
	private String subtitle;
	
	private List<String> authors;
	
	private String publisher;
	
	private String publishedDate;
	
	private String description;
	
	private long pageCount;
	
	private List<String> categories;
	
	private int averageRating;
	
	private int ratingCount;
	
	private boolean comicsContent;
	
	private ImageData imageLinks;

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public long getPageCount() {
		return pageCount;
	}

	public List<String> getCategories() {
		return categories;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public boolean isComicsContent() {
		return comicsContent;
	}

	public ImageData getImageLinks() {
		return imageLinks;
	}

	@Override
	public String toString() {
		return "Info [title=" + title + ", subtitle=" + subtitle + ", authors=" + authors + ", publisher=" + publisher
				+ ", publishedDate=" + publishedDate + ", description=" + description + ", pageCount=" + pageCount
				+ ", categories=" + categories + ", averageRating=" + averageRating + ", ratingCount=" + ratingCount
				+ ", comicsContent=" + comicsContent + ", imageLinks=" + imageLinks + "]";
	}
}
