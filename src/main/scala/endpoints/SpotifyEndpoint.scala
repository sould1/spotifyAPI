package endpoints
import scalaj.http.{Http, HttpRequest}

 abstract class SpotifyEndpoint  {
   protected val base_url = "https://api.spotify.com"

   protected def createRequest(endpoint: String): HttpRequest = Http(endpoint)

   protected def createRequest(endpoint: String, params: Seq[(String, String)]): HttpRequest = {
     Http(endpoint).params(params)


   }
 }

