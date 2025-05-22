package Meeting1

object QuizMatch extends App{
  def count(num1: Int, num2: Int, operation: String): (Int, String) = {
    val result = operation match {
      case "+" => (num1 + num2, "tambah")
      case "-" => (num1 - num2, "kurang")
      case "*" => (num1 * num2, "kali")
      case "/" => (num1 / num2, "bagi")
      case _ => (0, "invalid")
    }

    result
  }

  println(count(2, 4, "+"))
  println(count(2, 4, "-"))
  println(count(2, 4, "*"))
  println(count(2, 4, "/"))
}
