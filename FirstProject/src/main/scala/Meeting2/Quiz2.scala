package Meeting2

import scala.collection.mutable.ListBuffer

object Quiz2 extends App {
  case class Product(id: Long, name: String, price: Double)

  case class Order(id: Long, products: List[Product], total: Double)

  val product1 = Product(1, "Kopi Americano", 15000)
  val product2 = Product(2, "Teh Hijau", 12000)
  val product3 = Product(3, "Roti Bakar", 18000)
  val product4 = Product(4, "Kopi Kintamani", 20000)

  // Membuat object order
  val order = Order(
    id = 1001,
    products = List(product1, product2, product3, product4),
    total = 0
  )

  // Meng-update total harga
  val updateOrder = order.copy(total = order.products.map(_.price).sum)

//  // Menampilkan updateOrder dengan for
//  println(s"Order ID: ${updateOrder.id}")
//  println("Daftar Produk:")
//  for (product <- updateOrder.products) {
//    println(s"- ${product.name} (Rp ${product.price.toInt})")
//  }
//  println(s"Total Harga: Rp ${updateOrder.total.toInt}")

  val productBiasa: ListBuffer[Product] = ListBuffer()
  val productMahal: ListBuffer[Product] = ListBuffer()
  val productPremium: ListBuffer[Product] = ListBuffer()

  private def menu (product: Product) = {
    product match {
     case Product(_, nama, harga) if harga > 12000 & nama.contains("Kopi") => productPremium.append(product)
     case Product(_, nama, harga) if harga > 12000 => productMahal.append(product)
     case Product(_, nama, harga) if harga <= 12000 => productBiasa.append(product)
    }
  }

  order.products.foreach(x => menu(x))

  println("======= Product Biasa =======")
  productBiasa.foreach(p => println(s"${p.name} - Rp ${p.price.toInt}"))

  println("\n======= Product Mahal =======")
  productMahal.foreach(p => println(s"${p.name} - Rp ${p.price.toInt}"))

  println("\n======= Product Premium =======")
  productPremium.foreach(p => println(s"${p.name} - Rp ${p.price.toInt}"))

}
