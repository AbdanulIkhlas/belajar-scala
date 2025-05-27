package Meeting3

import play.api.libs.json.{Json, Writes}

object LatihanParseJson extends App {
  case class Location(lat: Double, long: Double)

  val loc = Location(10.0, 15.0)

  implicit val locationWrites: Writes[Location] = new Writes[Location] {
    def writes(location: Location) = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
    )
  }

  val locToJson = Json.toJson[Location](loc)

  print(Json.prettyPrint(locToJson))

}
