package Meeting3

import play.api.libs.json.{JsValue, Json}


object LatihanJson extends App {
  val json : JsValue = Json.parse(
    """
      |{
      |  "name" : "Watership Down",
      |  "location" : {
      |    "lat" : 51.235685,
      |    "long" : -1.309197
      |  },
      |  "residents" : [ {
      |    "name" : "Fiver",
      |    "age" : 4,
      |    "role" : null
      |  }, {
      |    "name" : "Bigwig",
      |    "age" : 6,
      |    "role" :"Owsla"
      |   }]
      |}
      |""".stripMargin
  )

  println(json.isInstanceOf[JsValue])
  println(Json.prettyPrint(json))
  println("=======================")
  println(s"Json nama : ${ (json \ "name").as[String] }")
  println(s"Json age residen : ${ ((json \ "residents")(0) \ "name").as[String] }")

}

