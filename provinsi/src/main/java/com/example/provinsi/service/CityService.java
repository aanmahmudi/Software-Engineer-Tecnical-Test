package com.example.provinsi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.provinsi.dto.CityDTO;
import com.example.provinsi.entity.City;
import com.example.provinsi.entity.Provinsi;
import com.example.provinsi.repository.CityRepository;
import com.example.provinsi.repository.ProvinsiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
	private final CityRepository cityRepository;
	private final ProvinsiRepository provinsiRepository;

	public List<CityDTO> getAllCity() {
		return cityRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public List<CityDTO> getCitiesByProvinsi(Long provinsiId) {
		return cityRepository.findByProvinsiId(provinsiId).stream()
				.map(city -> new CityDTO(city.getId(), city.getName(), city.getProvinsi().getId()))
				.collect(Collectors.toList());
	}

	public CityDTO saveCity(CityDTO cityDTO) {
		Provinsi provinsi = provinsiRepository.findById(cityDTO.getProvinsiId())
				.orElseThrow(() -> new RuntimeException("Province not found"));

		City city = new City();
		city.setName(cityDTO.getName());
		city.setProvinsi(provinsi);

		City savedCity = cityRepository.save(city);
		return new CityDTO(savedCity.getId(), savedCity.getName(), savedCity.getProvinsi().getId());
	}

	private CityDTO convertToDTO(City city) {
		return new CityDTO(city.getId(), city.getName(), city.getProvinsi().getId() 
		);
	}

}
