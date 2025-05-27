package Meeting3

import play.api.libs.json.{JsNull, JsValue, Json}

object LatihanJsonObj extends App {
  val json: JsValue = Json.obj(
    "name"     -> "Watership Down",
    "location" -> Json.obj("lat" -> 51.235685, "long" -> -1.309197),
    "residents" -> Json.arr(
      Json.obj(
        "name" -> "Fiver",
        "age"  -> 4,
        "role" -> JsNull
      ),
      Json.obj(
        "name" -> "Bigwig",
        "age"  -> 6,
        "role" -> "Owsla"
      )
    )
  )

  println(json.isInstanceOf[JsValue])
  println(Json.prettyPrint(json))
  println("=======================")
  println(s"Json nama : ${(json \ "name").as[String]}")
  println(s"Json age residen : ${((json \ "residents")(0) \ "name").as[String]}")

  println(s"Age resident pertama: ${((json \ "residents")(0) \ "age").as[Int]}")

}
