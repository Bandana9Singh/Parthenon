package com.olympus.parthenon.artemis.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.olympus.parthenon.artemis.beans.volume.Volumes;
import com.olympus.parthenon.artemis.models.Editions;
import com.olympus.parthenon.artemis.repository.EditionsRepo;
import com.olympus.parthenon.configs.YAMLConfig;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private YAMLConfig config;

	@Autowired
	EditionsRepo editionsRepo;

	@GetMapping("/serviceStatus")
	public String getServiceStatus() {
		return "Search is up and running";
	}

	@GetMapping("/editions")
	public List<Editions> getEditions(
			@RequestParam String title
	) {
		return editionsRepo.findSomething(title);
	}

	@GetMapping("/editions-limit")
	public ResponseEntity<Map<String, Object>> getEditionsLimit(
			@RequestParam String title,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		Map<String, Object> response = new HashMap<>();

		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<Editions> editionPage = editionsRepo.findSomethingPaged(title, pageable);

			List<Editions> list = editionPage.getContent();
			response.put("data", list);
			response.put("totalResults", editionPage.getTotalElements());
			response.put("totalPages", editionPage.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.clear();
			response.put("message", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/volumes")
	public Volumes getResults (
		@RequestParam Optional<String> q,
		@RequestParam(required = false) Optional<String> langRestrict,
		@RequestParam(required = false, defaultValue = "10") Optional<Integer> maxResults,
		@RequestParam(required = false, defaultValue = "0") Optional<Integer> startIndex,
		@RequestParam(required = false) Optional<String> printType
	) {
		String searchEndPoint = config.getVolume();
		UriComponents uriComponents = UriComponentsBuilder
							.fromHttpUrl(searchEndPoint)
							.queryParamIfPresent("q", q)
							.queryParamIfPresent("langRestrict", langRestrict)
							.queryParamIfPresent("maxResults", maxResults)
							.queryParamIfPresent("startIndex", startIndex)
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

		maxResults.ifPresentOrElse((value) -> {response.setMaxResults(value);}, () -> {});
		startIndex.ifPresentOrElse((value) -> {response.setStartIndex(value);}, () -> {});

		return response;
	}
}
