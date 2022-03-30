package model.out

case class Tracks(
                   id: String = null,
                   name: String = null,
                   popularity: Int = 0,
                   releaseDate: Option[String] = null,
                   durationMs: Long = 0,
                   explicit: Option[Boolean] = null ,
                   external_url: String = null,
                   artists: List[Artiste] = null
                 )
