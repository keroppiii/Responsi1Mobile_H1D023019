### Nama : Fatimah Nurmawati
### NIM : H1D023019
### Shift Baru : C
### Shift Asal : C

---

## Responsi Mobile - Real Madrid (86)

*Aplikasi Android sederhana yang menampilkan profil klub sepak bola Real Madrid. Aplikasi ini mengambil data secara langsung dari [football-data.org API](https://www.football-data.org/) dan dibuat untuk memenuhi tugas Responsi 1 Praktikum Pemrograman Mobile.*

---

## Demo Aplikasi
| Tampilan                                | 
|-----------------------------------------|
| ![Video Demo Aplikasi](assets/demo.gif) | 

---

## Penjelasan Alur Data

Proses pengerjaan aplikasi ini dimulai dari tahap eksplorasi hingga penyajian data di layar pengguna.

1.  **Uji Coba API dengan Postman**  
    Langkah paling awal adalah melakukan uji coba ke **[football-data.org API](https://www.football-data.org/)** menggunakan **Postman**. Tujuannya adalah untuk memastikan URL *endpoint* valid, menguji penggunaan API Key di *header*, dan untuk memahami struktur data **JSON** yang dikirimkan oleh server.

2.  **Persiapan di Android Studio**  
    Setelah struktur JSON-nya dipahami, langkah selanjutnya adalah membuat **Data Class** di Kotlin. Data Class ini berfungsi sebagai "cetakan" yang bentuknya sama persis dengan struktur JSON. Setelah itu, library **Retrofit** disiapkan sebagai "kurir" yang akan bertugas mengambil data dari API, lengkap dengan **Gson** sebagai "penerjemah" dari JSON ke Data Class.

3.  **Eksekusi di Aplikasi**  
    Saat aplikasi dibuka, **`MainActivity`** akan langsung memanggil **`MainViewModel`**. ViewModel inilah yang menjadi "otak" yang menyuruh **Retrofit** untuk berangkat mengambil data.

4.  **Penyajian Data**  
    Ketika Retrofit kembali membawa data JSON, **Gson** langsung bekerja mengubah data tersebut menjadi objek Data Class. Data yang sudah rapi ini kemudian disimpan di dalam **`LiveData`**. `MainActivity` terus-menerus memantau `LiveData` tersebut. Begitu ada data baru, `MainActivity` langsung mengambilnya dan menampilkannya ke komponen di layar. Untuk gambar, **Glide** dipanggil untuk mengambil gambar dari URL dan menampilkannya di `ImageView`.

5.  **Mengirim Data ke Halaman Lain**  
    Untuk halaman skuad, daftar pemain dikirim dari `MainActivity` ke `SquadActivity` menggunakan **Intent** dengan mekanisme **`Parcelable`**.