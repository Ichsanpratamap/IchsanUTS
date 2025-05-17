# UTS Pemrograman Berorientasi Obyek 2

- **Mata Kuliah**: Pemrograman Berorientasi Obyek 2  
- **Dosen Pengampu**: [Muhammad Ikhwan Fathulloh](https://github.com/Muhammad-Ikhwan-Fathulloh)

---

##  Profil

- **Nama**: Ichsan Pratama Putra  
- **NIM**: 23552011205  
- **Studi Kasus**: Deadline Tugas

---

##  Judul Studi Kasus

**Manajemen Deadline Tugas Mahasiswa Berbasis OOP**

---

##  Penjelasan Studi Kasus

Studi kasus ini membahas tentang bagaimana mahasiswa dapat mengelola deadline tugas mereka dengan sistem berbasis OOP. Sistem ini memungkinkan mahasiswa menambahkan, menghapus, dan melihat daftar tugas beserta deadline-nya, serta mendapatkan notifikasi saat deadline mendekat.

---

##  Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1.  Inheritance
Dalam studi kasus ini, kelas `Tugas` diwarisi oleh kelas `TugasPrioritas`, yang menambahkan atribut tambahan seperti `prioritas`. Ini menunjukkan penggunaan pewarisan untuk memperluas fungsionalitas kelas dasar.

### 2.  Encapsulation
Setiap objek `Tugas` memiliki atribut seperti `judul`, `deadline`, dan `status`, yang hanya dapat diakses melalui getter dan setter untuk menjaga integritas data.

### 3.  Polymorphism
Metode `tampilkanInfo()` diturunkan ke kelas `TugasPrioritas` dengan implementasi berbeda untuk menampilkan tambahan info prioritas. Ini adalah bentuk dari *method overriding*.

### 4.  Abstraction
Kelas abstrak `TugasBase` digunakan sebagai blueprint untuk kelas-kelas tugas lainnya, mendefinisikan metode abstrak seperti `tampilkanInfo()` yang harus diimplementasikan oleh subclass.

---

##  Demo Proyek

- **GitHub**: [](#)
- **Google Drive**: [https://drive.google.com/drive/folders/1N0v0Dsv8ZgODxYxt8t4swcTtUCe5Hpfv?usp=sharing](#)
