package model.in

case class ArtisteIn(
                    id: String,
                    name: String,
                    followers: Option[Int],
                    popularity: Int,
                    genre: Option[List[String]],
                    uri: Option[String]
                    )