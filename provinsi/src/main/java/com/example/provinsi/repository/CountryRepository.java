package com.example.provinsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.provinsi.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
