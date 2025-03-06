package com.example.Software.engineer.test.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Software.engineer.test.Entity.Mapel;
import com.example.Software.engineer.test.Service.MapelService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mapel")
public class MapelController {
    private static final Logger logger = LoggerFactory.getLogger(MapelController.class);

    private final MapelService mapelService;

    @GetMapping
    public ResponseEntity<List<Mapel>> getAllMapel() {
        logger.info("Mengambil semua mata pelajaran");
        List<Mapel> mapelList = mapelService.getAllMapel();
        return ResponseEntity.ok(mapelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mapel> getMapelById(@PathVariable Long id) {
        logger.info("Mengambil mata pelajaran dengan ID: {}", id, id);
        Mapel mapel = mapelService.getMapelById(id);
        return ResponseEntity.ok(mapel);
    }

    @PostMapping
    public ResponseEntity<Mapel> createMapel(@RequestBody Mapel mapel) {
        logger.info("Menambahkan mata pelajaran baru: {}", mapel.getNama());
        Mapel savedMapel = mapelService.saveMapel(mapel);
        return ResponseEntity.ok(savedMapel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mapel> updateMapel(@PathVariable Long id, @RequestBody Mapel mapel) {
        logger.info("Mengupdate mata pelajaran dengan ID: {}", id, id);
        Mapel updatedMapel = mapelService.updateMapel(id, mapel);
        return ResponseEntity.ok(updatedMapel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMapel(@PathVariable Long id) {
        logger.warn("Menghapus mata pelajaran dengan ID: {}", id, id);
        mapelService.deleteMapel(id);
        return ResponseEntity.ok("Mata Pelajaran dengan ID " + id + " berhasil dihapus");
    }
}
