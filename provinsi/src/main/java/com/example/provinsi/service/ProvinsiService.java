package com.example.provinsi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.provinsi.dto.ProvinsiDTO;
import com.example.provinsi.entity.Country;
import com.example.provinsi.entity.Provinsi;
import com.example.provinsi.repository.CountryRepository;
import com.example.provinsi.repository.ProvinsiRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvinsiService {
	private final ProvinsiRepository provinsiRepository;
	private final CountryRepository countryRepository;

	public List<ProvinsiDTO> getProvinsiByCountry(Long countryId) {
		return provinsiRepository.findByCountryId(countryId).stream()
				.map(provinsi -> new ProvinsiDTO(provinsi.getId(), provinsi.getName(), provinsi.getCountry().getId(), provinsi.getCountry().getName()))
				.collect(Collectors.toList());
	}

	@Transactional
	public ProvinsiDTO saveProvinsi(ProvinsiDTO provinsiDTO) {
		Country country = countryRepository.findById(provinsiDTO.getCountryId())
				.orElseThrow(() -> new RuntimeException("Country tidak ditemukan"));

		Provinsi provinsi = new Provinsi();
		provinsi.setName(provinsiDTO.getName());
		provinsi.setCountry(country); 

		return convertToDTO(provinsiRepository.save(provinsi));
	}
	
	private ProvinsiDTO convertToDTO(Provinsi provinsi) {
	    return new ProvinsiDTO(
	        provinsi.getId(),
	        provinsi.getName(),
	        provinsi.getCountry().getId(),  // Hanya mengambil ID dari Country, bukan seluruh objek
	        provinsi.getCountry().getName() // Opsional, jika ingin menampilkan nama negara juga
	    );
	}

}
