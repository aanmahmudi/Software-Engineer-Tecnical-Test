package com.example.Software.engineer.test.DTO;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaDTO {
	
	private Long id;
	private String nama;
	private String kelas;
	private Set<MapelDTO> mapelList;

}
