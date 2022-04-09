package com.olyumpus.parthenon.artemis.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.olyumpus.parthenon.artemis.beans.volume.Volumes;
import com.olyumpus.parthenon.artemis.configs.YAMLConfig;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private YAMLConfig config;
	
	@GetMapping("/serviceStatus")
	public String getServiceStatus() {
		return "Search is up and running";
	}

	@GetMapping("/volumes")
	public Volumes getResults (
		@RequestParam Optional<String> q,
		@RequestParam(required = false) Optional<String> langRestrict,
		@RequestParam(required = false) Optional<String> maxResults,
		@RequestParam(required = false) Optional<String> printType
	) {
		String searchEndPoint = config.getVolume();
		UriComponents uriComponents = UriComponentsBuilder
							.fromHttpUrl(searchEndPoint)
							.queryParamIfPresent("q", q)
							.queryParamIfPresent("langRestrict", langRestrict)
							.queryParamIfPresent("maxResults", maxResults)
							.queryParamIfPresent("printType", printType)
							.build();
		
		System.out.println(uriComponents.toUriString());
		
		WebClient webClient = WebClient.create();
		
		Volumes response = webClient
						.get()
						.uri(uriComponents.toUriString())
						.retrieve()
						.bodyToMono(Volumes.class)
						.block();

		return response;		
	}
}
