package com.example.Software.engineer.test.Service;

import com.example.Software.engineer.test.DTO.MapelDTO;
import com.example.Software.engineer.test.DTO.SiswaDTO;
import com.example.Software.engineer.test.Entity.Mapel;
import com.example.Software.engineer.test.Entity.Siswa;
import com.example.Software.engineer.test.Repository.MapelRepository;
import com.example.Software.engineer.test.Repository.SiswaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiswaService {

	private final SiswaRepository siswaRepository;
	private final MapelRepository mapelRepository;

	private static final Logger logger = LoggerFactory.getLogger(SiswaService.class);

	public List<SiswaDTO> getAllSiswa() {
		logger.info("Mengambil semua data siswa");
		return siswaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public SiswaDTO getSiswaById(Long id) {
		logger.info("Mencari siswa dengan ID: {}", id);
		Siswa siswa = siswaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Siswa dengan ID " + id + " tidak ditemukan"));
		return convertToDTO(siswa);
	}

	@Transactional
	public SiswaDTO saveSiswa(SiswaDTO siswaDTO) {
		logger.info("Menyimpan siswa baru: {}", siswaDTO.getNama());

		Siswa siswa = new Siswa();
		siswa.setNama(siswaDTO.getNama());
		siswa.setKelas(siswaDTO.getKelas());

		Siswa savedSiswa = siswaRepository.save(siswa);
		return convertToDTO(savedSiswa);
	}

	@Transactional
	public SiswaDTO updateSiswa(Long id, SiswaDTO siswaDTO) {
		logger.info("Mengupdate data siswa dengan ID: {}", id);
		Siswa siswa = siswaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Siswa dengan ID " + id + " tidak ditemukan"));

		siswa.setNama(siswaDTO.getNama());
		siswa.setKelas(siswaDTO.getKelas());

		return convertToDTO(siswaRepository.save(siswa));
	}

	@Transactional
	public void deleteSiswa(Long id) {
		logger.warn("Menghapus siswa dengan ID: {}", id);
		Siswa siswa = siswaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Siswa dengan ID " + id + " tidak ditemukan"));
		siswaRepository.delete(siswa);
	}

	@Transactional
	public SiswaDTO addMapelToSiswa(Long siswaId, Long mapelId) {
		logger.info("Menambahkan mata pelajaran ID {} ke siswa ID {}", mapelId, siswaId);

		Siswa siswa = siswaRepository.findById(siswaId)
				.orElseThrow(() -> new RuntimeException("Siswa dengan ID " + siswaId + " tidak ditemukan"));
		Mapel mapel = mapelRepository.findById(mapelId)
				.orElseThrow(() -> new RuntimeException("Mata Pelajaran dengan ID " + mapelId + " tidak ditemukan"));

		siswa.getMapelList().add(mapel);
		mapel.getSiswaList().add(siswa);

		return convertToDTO(siswaRepository.save(siswa));
	}

	private SiswaDTO convertToDTO(Siswa siswa) {
		Set<MapelDTO> mapelDTOList = siswa.getMapelList().stream()
				.map(mapel -> new MapelDTO(mapel.getId(), mapel.getKode(), mapel.getNama()))
				.collect(Collectors.toSet());

		return new SiswaDTO(siswa.getId(), siswa.getNama(), siswa.getKelas(), mapelDTOList);
	}
}
