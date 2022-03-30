package endpoints
  import scalaj.http.HttpRequest

 object Artistsendpoints extends SpotifyEndpoint {

   private val artist_endpoint = base_url + "/v1/artists/"

    def getArtist(artistId: String): HttpRequest = {
      createRequest(endpoint = artist_endpoint + artistId)
    }

    def getArtists(artistIds: Seq[String]): HttpRequest = {
      createRequest(endpoint = artist_endpoint, params = Seq(("ids", artistIds.mkString(","))))
    }

    def getRelatedArtists(artistId: String): HttpRequest = {
      createRequest(endpoint = artist_endpoint + artistId + "/related-artists")

    }
}


