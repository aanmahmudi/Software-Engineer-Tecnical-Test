package com.example.provinsi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.provinsi.dto.CountryDTO;
import com.example.provinsi.entity.Country;
import com.example.provinsi.service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {
	private final CountryService countryService;

	@GetMapping
	public ResponseEntity<List<CountryDTO>> getAllCountries() {
		return ResponseEntity.ok(countryService.getAllCountries());
	}

	@PostMapping
	public ResponseEntity<CountryDTO> createCountry(@RequestBody Country country) {
		return ResponseEntity.ok(countryService.saveCountry(country));
	}

}
