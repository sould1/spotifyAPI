package application

import model.in.ArtisteIn
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsPath, Json, Reads}
import scalaj.http.Http
import utils.converters.ArstistConverter


object parseArtist {



  //    to beauty print json
  //    val readableString: String = Json.prettyPrint(json_data)
  implicit val artistReads : Reads[ArtisteIn] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "followers"\ "total").readNullable[Int] and
      (JsPath \ "popularity").read[Int] and
      (JsPath \ "genres").readNullable[List[String]] and
      (JsPath \ "external_urls" \ "spotify").readNullable[String]
    )(ArtisteIn.apply _)

  private def readJSFile (input: String) ={
    val endpoint =application.ApplicationConfiguration.artist_endpoint + input
    Json.parse(Http(endpoint).header("Authorization","Bearer "+application.ApplicationConfiguration.token).asString.body)

  }
  def readFile_transformArtist ( file : String) ={
    val json_data = readJSFile(file)
    val art = json_data.validate[ArtisteIn].get
    ArstistConverter.convert(art)
  }
  def convert(artisteIn: ArtisteIn) = {
    ArstistConverter.convert(artisteIn)
  }



}
