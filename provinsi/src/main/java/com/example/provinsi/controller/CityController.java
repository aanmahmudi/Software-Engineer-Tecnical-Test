package com.example.provinsi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.provinsi.dto.CityDTO;
import com.example.provinsi.entity.City;
import com.example.provinsi.service.CityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
	private final CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> getAllCity(){
		return ResponseEntity.ok(cityService.getAllCity());
	}
	

	@GetMapping("/{provinsiId}")
	public ResponseEntity<List<CityDTO>> getCitiesByProvince(@PathVariable Long provinsiId) {
		return ResponseEntity.ok(cityService.getCitiesByProvinsi(provinsiId));
	}

	@PostMapping
	public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
		CityDTO savedCity = cityService.saveCity(cityDTO);
		return ResponseEntity.ok(savedCity);
	}

}
