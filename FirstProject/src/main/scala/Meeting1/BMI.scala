package Meeting1

object BMI extends App {
  def countBMI(berat: Double, tinggi: Double): (Double, String) = {
    try {
      if (berat <= 0 || tinggi <= 0) {
        throw new Exception("Berat dan tinggi tidak boleh nol atau negatif.")
      }

      val bmi = berat / ((tinggi * 0.01) * (tinggi * 0.01))

      val kategori = bmi match {
        case x if x < 18.5              => "Underweight"
        case x if x >= 18.5 && x < 24.9 => "Normal"
        case x if x >= 25 && x < 29.9   => "Overweight"
        case x if x >= 30 && x < 34.9   => "Obese"
        case x if x >= 35               => "Extremely Obese"
      }

      (bmi, kategori)
    } catch {
      case e: Exception =>
        println(s"Terjadi kesalahan: ${e.getMessage}")
        (0.0d, "Value tidak valid")
    }
  }

  val (bmi, kategori) = countBMI(69, 166)
//  println(bmi)
//  println(kategori)
  println(s"nilai BMI adalah $bmi dan kategorinya adalah $kategori")
}
