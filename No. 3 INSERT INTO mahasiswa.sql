INSERT INTO mahasiswa (id, name) VALUES 
(1, 'Robert'), 
(2, 'Desmon');

INSERT INTO kelas (id, name) VALUES 
(1, 'RF');

INSERT INTO kelas_mahasiswa (id_mahasiswa, id_kelas) VALUES 
(1, 1), 
(2, 1);

INSERT INTO mata_pelajaran (id, name) VALUES 
(1, 'Matematika');

INSERT INTO nilai_mahasiswa (id_mahasiswa, mata_pelajaran, tahun, nilai) VALUES 
(1, 1, 2022, 90),
(2, 1, 2022, 87);
