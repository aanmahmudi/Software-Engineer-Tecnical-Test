package com.example.provinsi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinsiDTO {
	private Long id;
	private String name;
	private Long countryId;
	private String countryName;

}
