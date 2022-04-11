package com.olympus.parthenon.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
	
	@Value("${google-books-api.volume}")
	private String volume;
	
	@Value("${books.genre}")
	private String genre;
	
	public String getVolume() {
		return this.volume;
	}
	
	public String getGenre() {
		return this.genre;
	}
}
