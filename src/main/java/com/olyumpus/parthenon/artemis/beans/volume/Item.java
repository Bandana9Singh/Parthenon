package com.olyumpus.parthenon.artemis.beans.volume;

public class Item {
	private String id;
	
	private Info volumeInfo;

	public String getId() {
		return id;
	}

	public Info getVolumeInfo() {
		return volumeInfo;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", volumeInfo=" + volumeInfo + "]";
	}
}
