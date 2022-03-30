package application

import model.in.trackArtist
import model.out.{Artiste, Tracks}
import play.api.libs.json.{JsObject, JsString, JsValue, Json}
//import scala.util.parsing.json.JSON

case class API(
                 artist : JsValue,
                 tracksArtist: List[JsValue],
                 relatedArtists: List[JsValue]
                 )

object ApplicationService {
  def processBaseArtist( artistID: String) ={
//    val baseArtist = application.parseArtist.conv()
    val baseArtist =  parseArtist.readFile_transformArtist(artistID)
    val artistsFromTrack = parseTracks.getArtists()
    val tupleTracks = parseTracks.gettupleTrackArtists(artistID)


    val convertedTupleTracks= tupleTracks.map(x =>{
      (parseTracks.convertTrack(x._1), x._2.map( y => {
        if (y.id != baseArtist.id)
        {
          parseArtist.readFile_transformArtist(y.id)

        }else{
          baseArtist

        }
      }))
    })
    (baseArtist, convertedTupleTracks, artistsFromTrack.distinct)

  }

  def process(): Unit = {

    val baseArtist: (Artiste, List[(Tracks, List[Artiste])], List[trackArtist]) = processBaseArtist("246dkjvS1zLTtiykXe5h60")

    baseArtist._3.map(x => {
            try {
                processBaseArtist(x.id)
            } catch {
              case e: Exception => println(e)
            }

          })

    implicit  val artisteWrite = Json.writes[Artiste]
    implicit val apiJSON = Json.writes[API]
    val artSer = Json.toJson(baseArtist._1)
    val relatedArtists = baseArtist._3.distinct
    val tracksSerialized= baseArtist._2.map(x =>{
      serliazeTracks(x._1)
    })

    val relatedArtistsSerialized = relatedArtists.map(x => serializeArtist(x))

    val apiSerialized = API(artSer,tracksSerialized, relatedArtistsSerialized)
    val apiJson: JsValue =  Json.toJson(apiSerialized)
//    implicit val tmp: Format[Result] = Jsonx.formatCaseClass[Result]
//    println(baseArtist)
    writeToHDFS(apiJson)

  }
  def serliazeTracks(tr : Tracks):JsValue ={

    val res = Seq(
      "idTrack" -> JsString(tr.id),
      "nameTrack" -> JsString(tr.name),
      "popularityTrack" -> JsString(tr.popularity.toString),
      "releaseDateTrack" -> JsString(tr.releaseDate.toString),
      "durationTrack" -> JsString(tr.durationMs.toString),
      "explicitTrack" -> JsString(tr.explicit.toString),
      "externalUrlTracks" -> JsString(tr.external_url)
    )
    JsObject(res)
  }

  def serializeArtist(ar: trackArtist): JsValue ={
    JsObject(
      Seq(
        "idArtist" -> JsString(ar.id),
        "nameArtist" -> JsString(ar.name),
        "hrefArtist" ->JsString(ar.href.toString)
      )
    )
  }
  def writeToHDFS(api: JsValue): Unit ={

  }

}
