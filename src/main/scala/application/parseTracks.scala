package application

import model.in.{TracksIn, trackArtist}
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsPath, JsValue, Json, Reads}
import scalaj.http.Http
import utils.converters.TracksConverter

object parseTracks {

//  val inputFileTracks = "src/main/scala/ressources/topTracks.json"



  implicit val trackReads : Reads[TracksIn] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "popularity").read[Int] and
      (JsPath \ "release_date").readNullable[String] and
      (JsPath \ "duration_ms").read[Long] and
      (JsPath \ "explicit").readNullable[Boolean] and
      (JsPath \ "external_urls" \ "spotify").read[String]

    )(TracksIn.apply _)

  implicit val trArt : Reads[trackArtist] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "external_urls" \ "spotify").readNullable[String]
    )(trackArtist.apply _)



  val json_data = readParseFile("246dkjvS1zLTtiykXe5h60")
//  val readableString: String = Json.prettyPrint(json_data)
  val albums = json_data \ "tracks"
  val tmp: List[JsValue] =  Json.parse(albums.get.toString).as[List[JsValue]]
  val updateAlbums =  tmp.map(x=>{
    x.validate[TracksIn].get
  })


  val artists = transformArtists(tmp)
  val updateArtists = artists.map(x =>
    {
      x.validate[trackArtist].get
    }
  )

  private def transformArtists(input : List[JsValue]) ={

    input.map( x => Json.parse( x("artists").toString()).as[List[JsValue]]).flatten

  }
  private def readParseFile (input:String) ={
    val endpoint =application.ApplicationConfiguration.base_url +"/v1/artists/" +input+"/top-tracks?market=fr"
    val request =Http(endpoint).header("Authorization","Bearer "+application.ApplicationConfiguration.token).asString
//    println(request)
    Json.parse(request.body)
  }

  def getArtists() ={
    updateArtists
  }
  def getTracks() ={
    updateAlbums
  }
  def gettupleTrackArtists(id:String) = {
    val json_data = readParseFile(id)
    //  val readableString: String = Json.prettyPrint(json_data)
    val albums = json_data \ "tracks"
    val tmp1: List[JsValue] =  Json.parse(albums.get.toString).as[List[JsValue]]
    val tupleTrackArtist =  tmp1.map(x=>{
      val track = x.validate[TracksIn].get
      val art = Json.parse( x("artists").toString()).as[List[JsValue]]
      val art2 = art.map( y => y.validate[trackArtist].get)
      (track, art2)
    })
    tupleTrackArtist
  }
  def convertTrack(input: TracksIn) ={
    TracksConverter.convert(input)
  }

  def readFile_transform(base:String, file: String) ={

    val json_content = scala.io.Source.fromFile(base + file).mkString
    Json.parse(json_content)

  }
}
