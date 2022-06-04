package com.olympus.parthenon.hermes.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olympus.parthenon.configs.YAMLConfig;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private YAMLConfig config;
	
	@GetMapping("/serviceStatus")
	public String getMapping() {
		return "Book Services are up and running";
	}

	@GetMapping("/genre")
	public List<String> getGenre() {
		List<String> convertedGenreList = Arrays.asList(config.getGenre().split(","));
		return convertedGenreList;
	}
	
}
