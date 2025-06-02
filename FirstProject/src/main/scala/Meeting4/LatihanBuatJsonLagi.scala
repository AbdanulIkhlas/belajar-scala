package Meeting4
import play.api.libs.json._
import play.api.libs.functional.syntax._


object LatihanBuatJsonLagi extends App {
  case class Ukuran(panjang: Double, lebar: Double)
  case class Kamar(nama: String, ukuran: Ukuran, warna: Option[String])

//  --------------- WRITES JSON ------------------------
//  implicit val ukuranWrites: Writes[Ukuran] = new Writes[Ukuran] {
//    def writes(ukuran: Ukuran) = Json.obj(
//      "panjang" -> ukuran.panjang,
//      "lebar" -> ukuran.lebar
//    )
//  }
//
//  implicit val kamarWrites: Writes[Kamar] = new Writes[Kamar] {
//    def writes(kamar: Kamar) = Json.obj(
//      "nama" -> kamar.nama,
//      "ukuran" -> kamar.ukuran,
//      "warna" -> kamar.warna
//    )
//  }

//  ---------------- READ JSON -----------------------
//  implicit val ukuranReads: Reads[Ukuran] = (
//    (JsPath \ "panjang").read[Double] and
//      (JsPath \ "lebar")
//    .read[Double])((panjang,lebar) => Ukuran(panjang,lebar))
//
//  implicit val kamarReads: Reads[Kamar] = (
//    (JsPath \ "nama").read[String] and
//    (JsPath \ "ukuran").read[Ukuran] and
//    (JsPath \ "warna").readNullable[String]
//  )(Kamar.apply _)
//
  val kamarGaming = Kamar(
    "Klaz",
    Ukuran(99.9, 9),
    Some("DarkBlue")
  )


//  Konsep langsung buat read dan writes dengan key yang sama dengan key (fast code)
  implicit val ukuranFormat: OFormat[Ukuran] = Json.format[Ukuran]
  implicit val kamarFormat: OFormat[Kamar] = Json.format[Kamar]

//-----------
//  val json = Json.toJson(kamarGaming)(kamarWrites)
  val json = Json.toJson(kamarGaming)(kamarFormat)
  println(Json.prettyPrint(json))
//-----------

  val namaYangPunyaKamar = (json \ "nama").as[String]
  println(s"Nama yang punya kamar : $namaYangPunyaKamar")

//  val ukuranKamar : Ukuran = (json \ "ukuran").as[Ukuran](ukuranReads)
  val ukuranKamar : Ukuran = (json \ "ukuran").as[Ukuran](ukuranFormat)

  println(s"ukuran kamar test : $ukuranKamar")
  println(s"lebar kamar : ${(ukuranKamar.lebar)} ")
  println(s"panjang kamar : ${(ukuranKamar.panjang)} ")

  val warnaKamar = (json \ "warna").asOpt[String].orNull
  println(s"Warna kamar : $warnaKamar")

  println("\n----- Testing ye ------\n")
  println(s"test isi js value ukuran kamar : $ukuranKamar")


//  lebih mudah gini
//  val readKamarGaming : Kamar = (json).as[Kamar](kamarReads)
  val readKamarGaming : Kamar = (json).as[Kamar](kamarFormat)
  println(s"Read Kamar Gaming : ${readKamarGaming}")
  println(s"Nama : ${readKamarGaming.nama}")
  println(s"Ukuran lebar : ${readKamarGaming.ukuran.lebar}")
  println(s"Ukuran panjang : ${readKamarGaming.ukuran.panjang}")
  println(s"Warna : ${readKamarGaming.warna.orNull}")



//  -------------------- Percobaan banyak kamar --------------------------
//  println("\n\n\n-------------------------------------------------------\n\n\n")
  val banyakKamar = Seq(
    Kamar("Kamar Mandi", Ukuran(3.0, 3.0), None),
    Kamar("Kamar Tidur", Ukuran(9.0, 9.0), Some("Putih")),
    Kamar("Kamar Hantu", Ukuran(99.0, 99.0), Some("Merah menyala"))
  )

  val jsonBanyakKamar = Json.toJson(banyakKamar)
//  println(Json.prettyPrint(jsonBanyakKamar))
//  print(banyakKamar)

  var index = 0
  println("\n")
  jsonBanyakKamar.as[JsArray].value.foreach { banyakKamar =>
//    val dataKamar : Kamar = (banyakKamar).as[Kamar](kamarReads)
    val dataKamar : Kamar = (banyakKamar).as[Kamar](kamarFormat)

    println(s"-------- Data kamar ${index + 1} ------")
    println(s"Nama Kamar : ${dataKamar.nama}")
    println(s"Lebar Kamar : ${dataKamar.ukuran.lebar}")
    println(s"Panjang Kamar : ${dataKamar.ukuran.panjang}")
    println(s"Warna Kamar : ${dataKamar.warna.orNull}")
    println("\n")
    index+=1
  }

}
