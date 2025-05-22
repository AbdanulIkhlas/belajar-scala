@main
def main(): Unit = {
  val a = 10.0
  val b = 5.0

  println(s"Penjumlahan: $a + $b = ${SimpleCalculator.add(a, b)}")
  println(s"Pengurangan: $a - $b = ${SimpleCalculator.subtract(a, b)}")
  println(s"Perkalian: $a * $b = ${SimpleCalculator.multiply(a, b)}")
  println(s"Pembagian: $a / $b = ${SimpleCalculator.divide(a, b)}")

//  println("\nPerulangan menggunakan map:")
//  (1 to 5).map { i =>
//    println(i)
//  }
//
//  println("\nPerulangan menggunakan for:")
//  for (i <- 1 to 5) {
//    println(s"i = $i")
//  }
}
