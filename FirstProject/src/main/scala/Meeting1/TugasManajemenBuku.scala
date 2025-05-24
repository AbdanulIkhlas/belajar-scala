package Meeting1

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.{Try, Success, Failure}

object TugasManajemenBuku extends App {
  

  // Tipe data buku menggunakan Tuple (judul, penulis)
  type Buku = (String, String)

  // ArrayBuffer sebagai tempat penyimpanan buku
  val daftarBuku: ArrayBuffer[Buku] = ArrayBuffer()

  // Fungsi untuk menampilkan semua buku
  def tampilkanBuku(): Unit = {
    if (daftarBuku.isEmpty) {
      println("\n- Belum ada buku -\n")
    } else {
      println("\n=== Daftar Buku ===")
      for ((buku, index) <- daftarBuku.zipWithIndex) {
        val (judul, penulis) = buku
        println(s"${index + 1}. Judul buku '$judul' karya '$penulis''")
      }
      println()
    }

    println("Tekan ENTER untuk melanjutkan...")
    scala.io.StdIn.readLine()

  }

  // Fungsi untuk menambahkan buku
  def tambahBuku(): Unit = {
    try {
      print("Masukkan Judul Buku: ")
      val judul = readLine()
      require(judul.trim.nonEmpty, "Judul tidak boleh kosong euy!!!")

      print("Masukkan Nama Penulis: ")
      val penulis = readLine()
      require(penulis.trim.nonEmpty, "Nama penulis tidak boleh kosong euy!!!!!")

      // Menambahkan buku ke daftar
      daftarBuku += ((judul, penulis))
      println("Buku berhasil ditambahkan!\n")

    } catch {
      case e: IllegalArgumentException =>
        println(s" ${e.getMessage}\n")
      case _: Exception =>
        println("Terjadi kesalahan euyyy.\n")
    }

    println("Tekan ENTER untuk melanjutkan...")
    scala.io.StdIn.readLine()

  }

  // Fungsi untuk menghapus buku
  def hapusBuku(): Unit = {
    tampilkanBuku()
    if (daftarBuku.nonEmpty) {
      print("Masukkan nomor buku yang ingin dihapus: ")
      val input = readLine()

      Try(input.toInt) match {
        case Success(nomor) =>
          if (nomor >= 1 && nomor <= daftarBuku.length) {
            val bukuDihapus = daftarBuku.remove(nomor - 1)
            println(s"Buku '${bukuDihapus._1}' berhasil dihapus.\n")
          } else {
            println("Nomor tidak valid euy.\n")
          }
        case Failure(e) =>
          println(e.getMessage)
          println("Input harus berupa angka euy!\n")
      }
    }

    println("Tekan ENTER untuk melanjutkan...")
    scala.io.StdIn.readLine()
    
  }

  // Perulangan utama menggunakan while
  var ulangi = true
  while (ulangi) {
    println(
      """
        |=== Program Manajemen Buku ===
        |------------------------------
        |1. Tampil Buku
        |2. Tambah Buku
        |3. Hapus Buku
        |4. Keluar
        |""".stripMargin)

    print("Pilih : ")
    val pilihan = readLine()

    // Pattern matching untuk menu
    pilihan match {
      case "1" => tampilkanBuku()
      case "2" => tambahBuku()
      case "3" => hapusBuku()
      case "4" =>
        println("Program selesai.")
        ulangi = false
      case _ =>
        println("Pilihan tidak dikenal, coba lagi.\n")
    }
  }
}
