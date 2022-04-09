package com.olyumpus.parthenon.artemis.beans.volume;

import java.util.List;

public class Volumes {
	private int totalItems;
	
	private List<Item> items;

	public int getTotalItems() {
		return totalItems;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Volumes [totalItems=" + totalItems + ", items=" + items + "]";
	}
}
