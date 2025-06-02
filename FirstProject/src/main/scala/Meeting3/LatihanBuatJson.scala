package Meeting3
import play.api.libs.json._

/*
   * {
    "name" : "Watership Down",
    "location" : {
      "lat" : 51.235685,
      "long" : -1.309197
    },
    "residents" : [ {
      "name" : "Fiver",
      "age" : 4,
      "role" : null
    }, {
      "name" : "Bigwig",
      "age" : 6,
      "role" : "Owsla"
    } ]
  }
 */

object LatihanBuatJson extends App {
  case class Location(lat: Double, long: Double)
  case class Resident(name: String, age: Int, role: Option[String])
  case class Place(name: String, location: Location, residents: Seq[Resident])

  import play.api.libs.json._

  implicit val locationWrites: Writes[Location] = new Writes[Location] {
    def writes(location: Location) = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
    )
  }

  implicit val residentWrites: Writes[Resident] = new Writes[Resident] {
    def writes(resident: Resident) = Json.obj(
      "name" -> resident.name,
      "age" -> resident.age,
      "role" -> resident.role
    )
  }

  implicit val placeWrites: Writes[Place] = new Writes[Place] {
    def writes(place: Place) = Json.obj(
      "name" -> place.name,
      "location" -> place.location,
      "residents" -> place.residents
    )
  }

  val place = Place(
    "Watership Down",
    Location(51.235685, -1.309197),
    Seq(
      Resident("Fiver", 4, None),
      Resident("Bigwig", 6, Some("Owsla"))
    )
  )

  val json = Json.toJson(place)

  println(Json.prettyPrint(json))
  println("=========================")
  val name = (json \ "name").as[String]
  val allNames = (json \\ "name").map(_.as[String])
  println(s"Nama : ${name}")
  println(s"Semua nama : ${allNames}")

  val residents = json("residents")
//  println(s"semua residents : ${residents}")
//  println(s"residen index 1 : ${residents(1)}")
//  println(s"umur residen index 1 : ${(residents(1) \ "age").as[Int]}")

  var index = 0
  residents.as[JsArray].value.foreach { resident =>
    val name = (resident \ "name").as[String]
    val age = (resident \ "age").as[Int]
    val role = (resident \ "role").asOpt[String].getOrElse("None") // null-safe

    println(s"data residen index ${index} : Name: $name, Age: $age, Role: $role")
    index += 1
  }

  val location = json("location")
  println(s"location lat  : ${(location \ "lat").as[Double]}")
  println(s"location long :${(location \ "long").as[Double]}")


}
