package Meeting3

//import scala.collection.mutable.ListBuffer

object Latihan1 extends App {
  val testData: List[String] = List("Gibran", "2", "1", "3", "Merah", "4", "Biru")

  // cara pertama
//  testData.map {
//    case x if x.toIntOption.isDefined => x.toInt * x.toInt
//    case _ => 0
//  }.filter(_ != 0).map(println)


//  cara kedua
  testData
    .map(x => x.toIntOption.map(n => n * n).getOrElse(0))
    .filter(_ != 0)
    .foreach(println)

  
}
