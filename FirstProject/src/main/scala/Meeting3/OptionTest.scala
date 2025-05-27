package Meeting3

object OptionTest extends App {

  def greet(name: Option[String]): String = {
    println(s"non empty : ${name.nonEmpty}")
    println(s"define : ${name.isDefined}")
//    println(name.isDefined)
    name match {
      case Some(n) => s"Hello, $n!"
      case None    => "Hello, stranger!"
    }
  }

  val someName = Some("Alice")
  val noName: Option[String] = None

  println(greet(someName)) // Output: Hello, Alice!
//  println(greet(noName))   // Output: Hello, stranger!
}
