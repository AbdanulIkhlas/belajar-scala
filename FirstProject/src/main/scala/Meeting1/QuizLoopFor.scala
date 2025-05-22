package Meeting1

object QuizLoopFor extends App {
  val pelanggan = List(
    "yoyan hakiki",
    "dina putri",
    "rudi santoso",
    "nina dewi",
    "bambang hakiki",
    "tina satria",
    "rino santoso",
    "riko pratama"
  )

  val pelangganPrioritas = Set("hakiki", "santoso")

  for{
    i <- pelanggan  // memasukkan pelanggan ke i
    toUppercase = i.split(" ").map(_.capitalize) // split kalimat dan langsung di map setiap index(kata) dan langsung di capitalkan
    fullSentence = toUppercase.mkString(" ") // menggabung semua list/index di var dengan menambahkan pisah spasi
    splitSentence = fullSentence.split(" ") // split kata menjadi index list
    
    // mengecek index ke 2 (last name) pada value  <pelangganPrioritas> dan memasukkan nilai true/false ke variabel <isPriority>
    isPriority = if (pelangganPrioritas.contains(splitSentence(1).toLowerCase)) " - Pelanggan Prioritas" else ""
    result = fullSentence + isPriority
  }{
      println(result)
  }
}
