package Meeting3

object Implicit extends App {
  implicit val nama : String = "Cihuyy"
  implicit val umur : Int = 9

//  ini adalah teknik currying
  def SayHello( name: String)(implicit cihuy: String): Unit = {
    println(s"halo ${name} -> ${cihuy}")
  }

  SayHello("gila")("tak masuk logika")
}
