package com.olympus.parthenon.artemis.beans.volume;

import java.util.List;

public class Volumes {
	private int totalItems;
	
	private List<Item> items;
	
	private int startIndex;
	
	private int maxResults;
	
	public int getTotalItems() {
		return totalItems;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getMaxResults() {
		return maxResults;
	}

	
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	@Override
	public String toString() {
		return "Volumes [totalItems=" + totalItems + ", items=" + items + "]";
	}
}
