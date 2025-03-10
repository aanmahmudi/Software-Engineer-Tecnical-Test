package com.example.Software.engineer.test.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Software.engineer.test.Entity.Mapel;
import com.example.Software.engineer.test.Repository.MapelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapelService {
	
	private final MapelRepository mapelRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MapelService.class);
	
	public List<Mapel> getAllMapel(){
		logger.info("Mengambil semua mata pelajaran");
		return mapelRepository.findAll();
		
	}
	
	public Mapel getMapelById(Long id) {
		logger.info("Mencari mata pelajaran berdasarkan ID: {}", id);
		return mapelRepository.findById(id)
				.orElseThrow(()-> new RuntimeException ("Mata pelajaran dengan ID" + id + "Tidak ditemukan"));
		
	}
	
	@Transactional
	public Mapel saveMapel(Mapel mapel) {
		logger.info("Menyimpan mata pelajaran baru: {}", mapel.getNama());
		return mapelRepository.save(mapel);
		
	}
	
	@Transactional
	public Mapel updateMapel(Long id, Mapel mapelDetails) {
		logger.info("Mengupdate mata pelajaran dengan ID: {}", id);
		Mapel mapel = mapelRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Mata Pelajaran dengan ID " +id+ "Tidak ditemukan"));
		
		mapel.setKode(mapelDetails.getKode());
		mapel.setNama(mapelDetails.getNama());
		return mapelRepository.save(mapel);
	}
	
	@Transactional
	public void deleteMapel(Long id) {
		logger.warn("Menghapus mata pelajaran dengan ID: {}", id);
		Mapel mapel = mapelRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Mata pelajaran dengan ID" + id+ "Tidak ditemukan"));
		
		mapelRepository.delete(mapel);
	}

}
