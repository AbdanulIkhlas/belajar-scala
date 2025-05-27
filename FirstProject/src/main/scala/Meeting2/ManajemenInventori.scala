package Meeting2

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer


// sperti struct di c++
case class Barang(nama: String, stok: Int, harga: Double)

class Inventori {

  val daftarBarang: ListBuffer[Barang] = ListBuffer(
    Barang("Gelas", 17, 15000),
    Barang("Piring", 6, 90000),
    Barang("Botol", 3, 14000)
  )

  // Menampilkan semua barang dalam inventori
  def tampilkanInventori(cek : Boolean): Unit = {
    println("\n============ Daftar Inventori ============")
    for (barang <- daftarBarang) {
      println(s"- ${barang.nama} | Stock: ${barang.stok} | Price: Rp ${barang.harga}")
    }

    if(cek){
      println("\n========================")
      print("Tekan ENTER untuk melanjutkan...")
      readLine()
    }
  }

  // Fungsi untuk menambahkan barang
  def tambahBarang(): Unit = {

    var ulangi: Boolean = true

    while (ulangi){
      print("\nMasukkan nama barang: ")
      // di hapus spasi berlebih di depan dan belakang kata, split to array, map dan capitalkan, trus gabungkan => CIHUY
      val nama = readLine().trim.toLowerCase().split("\\s+").map(_.capitalize).mkString(" ")

      try {
        print("Masukkan jumlah stok: ")
        val stok = readLine().toInt

        print("Masukkan harga barang: ")
        val harga = readLine().toDouble

        // Tambahkan barang ke daftar
        daftarBarang += Barang(nama, stok, harga)
        println(s"'$nama' berhasil ditambahkan ke inventori.")

        // print("Mau coba tambah kan ulang barang? (y/n): ")
        // val jawaban = readLine().trim.toLowerCase
        // ulangi = if (jawaban == "y") true else false => RAWR

      } catch {
        case _: NumberFormatException =>
          println("Input stok atau harga tidak valid. Harus berupa angka.")
      }

      print("Mau coba tambah kan ulang barang? (y/n): ")
      ulangi = readLine().trim.toLowerCase == "y" // RAWR
    }

    println("\n============================================")
//    print("Tekan ENTER untuk melanjutkan...")
//    readLine()
  }

  // Fungsi untuk mengeluarkan barang dari inventori
  def keluarkanBarang(): Unit = {
    tampilkanInventori(false)

    var ulangi : Boolean = true

    while (ulangi){
      print("\nMasukkan nama barang yang akan dikeluarkan: ")
      var nama = readLine().trim.split("\\s+").mkString(" ")

      // searching index barang berdasarkan nama
      val indexBarang = daftarBarang.indexWhere(_.nama.equalsIgnoreCase(nama))
      println(s"index barang = ${indexBarang}")


      //  !!sama saja kayak di bawah ini
      //  val indexBarang = daftarBarang.indexWhere(x => x.nama.equalsIgnoreCase(nama))
      //  val indexBarang = daftarBarang.indexWhere(barang => barang.nama.equalsIgnoreCase(nama))

      if (indexBarang != -1) {
        nama = nama.trim.toLowerCase().split("\\s+").map(_.capitalize).mkString(" ") // CIHUY
        try {
          println(s"Oke barang di temukan, nama barang ini kan -> ${nama}")
          print("Masukkan jumlah yang ingin dikeluarkan: ")
          val jumlah = readLine().toInt

          val barangLama = daftarBarang(indexBarang)

          if (jumlah < barangLama.stok) {
            val barangBaru = barangLama.copy(stok = barangLama.stok - jumlah)

            // update data berdasarkan indexBarang menjadi data barang baru
            daftarBarang.update(indexBarang, barangBaru)
            println(s"${jumlah} '${nama}' berhasil dikeluarkan dari inventori.")
          } else if (jumlah == barangLama.stok) {
            // hapus data berdasarkan index
            daftarBarang.remove(indexBarang)
            println(s"Semua '${nama}' telah di keluarkan, barang telah dihapus dari inventori.")
          } else {
            println(s"Stok '${nama}' tidak mencukupi.")
          }
        } catch {
          case _: NumberFormatException =>
            println("Jumlah harus berupa angka.")
        }
      } else {
        println(s"Barang dengan nama '${nama}' tidak ditemukan.")
      }
      print("Ulangi keluarkan barang? (y/n): ")
      ulangi = readLine().trim.toLowerCase == "y" // RAWR
    }

    println("\n============================================")
  }
}

object ManajemenInventori extends App {
  val inventori = new Inventori
  var lanjut = true

  while (lanjut) {
    println("\n=== Sistem Manajemen Inventori ===")
    println("1. Tambah Barang")
    println("2. Keluarkan Barang")
    println("3. Lihat Inventori")
    println("4. Keluar")
    print("Pilih menu: ")

    val input = readLine()

    // Pattern matching untuk menangani input menu
    input match {
      case "1" => inventori.tambahBarang()
      case "2" => inventori.keluarkanBarang()
      case "3" => inventori.tampilkanInventori(true)
      case "4" =>
        println("Program selesai")
        lanjut = false
      case _ =>
        println("Pilihan tidak valid. Silakan masukkan angka antara 1 sampai 4.")
    }
  }
}
