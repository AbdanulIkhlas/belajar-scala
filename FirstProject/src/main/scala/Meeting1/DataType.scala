package Meeting1

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object DataType extends App {
  val text : String = "klaz"

  println("text Instance of string : "+ text.isInstanceOf[String])
  println("text Instance of string : "+ text.isInstanceOf[AnyRef])

  var list1: List[Int] = List(1,2,3,9)

  var list2: ListBuffer[Int] = ListBuffer(1,2,3,9)

  println("List : "+list1(1))
  println("ListBuffer : "+list2)

//  input nama
  val username = StdIn.readLine("Nama : ")

  if(username.length < 3){
    println("username : "+ username)
  }else{
    println("Cihuyyy")
  }
//  test ternary
  val testTernary = if (2 < 9)  true else false
  println("testTernary : " + testTernary)
  
  
//  perulangan
//  for{
//    i <- 1 to 10
//    if i
//  }{
//    
//  }
}
