package com.olympus.parthenon.artemis.beans.volume;

public class ImageData {
	private String smallThumbnail;
	
	private String thumbnail;
	
	public String getSmallThumbnail() {
		return this.smallThumbnail;
	}
	
	public String getThumbnail() {
		return this.thumbnail;
	}

	@Override
	public String toString() {
		return "ImageData [smallThumbnail=" + smallThumbnail + ", thumbnail=" + thumbnail + "]";
	}
	
	
}
