package endpoints

import scalaj.http.HttpRequest

object TracksEndpoint extends SpotifyEndpoint  {

  private val tracks_endpoint = base_url + "/v1/tracks/"

  def getTrack(trackId: String): HttpRequest =
    createRequest(tracks_endpoint + trackId)

  def getTracks(trackIds: Seq[String]): HttpRequest =
    createRequest(tracks_endpoint, params = Seq(("ids", trackIds.mkString(","))))

}
