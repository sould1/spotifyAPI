package model.in

case class TracksIn(
                   id: String,
                   name: String,
                   popularity: Int,
                   releaseDate: Option[String],
                   durationMs: Long,
                   explicit: Option[Boolean],
                   external_url: String
//                   artists: List[ArtisteIn]
                 )
