package model.out

case class Artiste(
                       id: String = null,
                       name: String = null,
                       popularity: Int = 0,
                       genre: Option[List[String]] = None,
                       nb_followers: Option[Int] = None,
                       uri: Option[String] = None,
                       relatedArtists: Option[List[String]] = None
                     )
