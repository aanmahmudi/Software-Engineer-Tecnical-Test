CREATE TABLE mahasiswa (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) NOT NULL,
    gender VARCHAR(10) NOT NULL
);

CREATE TABLE kelas (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) NOT NULL,
    jurusan VARCHAR(50) NOT NULL
);

CREATE TABLE kelas_mahasiswa (
    id SERIAL PRIMARY KEY,
    id_mahasiswa INT NOT NULL,
    id_kelas INT NOT NULL,
    FOREIGN KEY (id_mahasiswa) REFERENCES mahasiswa(id) ON DELETE CASCADE,
    FOREIGN KEY (id_kelas) REFERENCES kelas(id) ON DELETE CASCADE
);

CREATE TABLE mata_pelajaran (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) NOT NULL,
    sks INT NOT NULL
);

CREATE TABLE nilai_mahasiswa (
    id SERIAL PRIMARY KEY,
    id_mahasiswa INT NOT NULL,
    mata_pelajaran INT NOT NULL,
    nilai DECIMAL(5,2) NOT NULL,
    tahun INT NOT NULL,
    semester INT NOT NULL,
    FOREIGN KEY (id_mahasiswa) REFERENCES mahasiswa(id) ON DELETE CASCADE,
    FOREIGN KEY (mata_pelajaran) REFERENCES mata_pelajaran(id) ON DELETE CASCADE
);
