package com.example.provinsi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.provinsi.dto.CountryDTO;
import com.example.provinsi.entity.Country;
import com.example.provinsi.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
	private final CountryRepository countryRepository;

	public List<CountryDTO> getAllCountries() {
		return countryRepository.findAll().stream().map(country -> new CountryDTO(country.getId(), country.getName()))
				.collect(Collectors.toList());
	}

	public CountryDTO saveCountry(Country country) {
		Country saved = countryRepository.save(country);
		return new CountryDTO(saved.getId(), saved.getName());
	}

}
