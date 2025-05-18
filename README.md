# UTS Pemrograman Berorientasi Obyek 2

- **Mata Kuliah**: Pemrograman Berorientasi Obyek 2  
- **Dosen Pengampu**: [Muhammad Ikhwan Fathulloh](https://github.com/Muhammad-Ikhwan-Fathulloh)

---

## 📌 Profil

- **Nama**: Ichsan Pratama Putra  
- **NIM**: 23552011205  
- **Studi Kasus**: Deadline Tugas

---

## 📝 Judul Studi Kasus

**Aplikasi Manajemen Deadline Tugas Menggunakan Java Spring Boot**

---

## 📖 Penjelasan Studi Kasus

Aplikasi ini membantu pengguna (mahasiswa) untuk mencatat, memantau, dan mengatur deadline tugas mereka. Fitur yang disediakan meliputi:

- Registrasi dan login pengguna
- Menambahkan, mengedit, dan menghapus tugas
- Menampilkan daftar tugas yang harus diselesaikan
- Pengelompokan tugas berdasarkan pengguna

Teknologi yang digunakan:
- Java Spring Boot
- Spring Security
- Thymeleaf (template engine)
- HTML/CSS

---

## 🔍 Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. 🧬 Inheritance
`UserDetailsService` diimplementasikan oleh `UserServices` untuk mengatur autentikasi dan otorisasi pengguna, menunjukkan penggunaan pewarisan antarmuka dari Spring Security.

### 2. 🔒 Encapsulation
Class seperti `User` dan `Todo` menyimpan data dengan akses `private`, dan memanipulasi datanya menggunakan *getter* dan *setter*, menjaga keamanan data.

### 3. 🔁 Polymorphism
Metode `loadUserByUsername` diimplementasikan ulang di `UserServices` sebagai bentuk *method overriding* dari antarmuka `UserDetailsService`.

### 4. 🧩 Abstraction
Spring menggunakan banyak konsep abstraksi, seperti `JpaRepository` yang digunakan oleh `UserRepository` dan `TodoRepository`. Kita cukup mendeklarasikan interface-nya, dan Spring akan mengimplementasikan detailnya secara otomatis.

---

## 🎥 Demo Proyek

- **GitHub**: [Link Repository](#)
- **YouTube**: [Link Demo](#)

---

