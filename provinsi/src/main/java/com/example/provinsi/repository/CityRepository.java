package com.example.provinsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.provinsi.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByProvinsiId(Long provinsiId);

}
