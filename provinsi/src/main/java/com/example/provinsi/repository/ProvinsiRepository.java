package com.example.provinsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.provinsi.entity.Provinsi;

public interface ProvinsiRepository extends JpaRepository<Provinsi, Long> {
    List<Provinsi> findByCountryId(Long countryId);

}
