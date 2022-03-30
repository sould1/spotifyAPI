package utils.converters

import model.in.ArtisteIn
import model.out.Artiste

object ArstistConverter extends Converter[ArtisteIn, Artiste] {
  override def convert(input: ArtisteIn): Artiste =
    Artiste(
      id = input.id,
      name = input.name,
      popularity = input.popularity,
      genre = input.genre,
      nb_followers = input.followers,
      uri = input.uri
    )

}
