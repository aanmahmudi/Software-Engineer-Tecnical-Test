package com.example.provinsi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.provinsi.dto.ProvinsiDTO;
import com.example.provinsi.service.ProvinsiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/provinsi")
@RequiredArgsConstructor
public class ProvinsiController {
	private final ProvinsiService provinsiService;

	@GetMapping("/{countryId}")
	public ResponseEntity<List<ProvinsiDTO>> getProvinsiByCountry(@PathVariable Long countryId) {
		return ResponseEntity.ok(provinsiService.getProvinsiByCountry(countryId));
	}

	@PostMapping
	public ResponseEntity<ProvinsiDTO> createProvince(@RequestBody ProvinsiDTO provinsiDTO) {
		ProvinsiDTO savedProvinsi = provinsiService.saveProvinsi(provinsiDTO);
		return ResponseEntity.ok(savedProvinsi);
	}

}
