package utils.converters

import model.in.TracksIn
import model.out.Tracks

object TracksConverter extends Converter[TracksIn, Tracks] {
  override def convert(input: TracksIn): Tracks = {
    Tracks(
      id = input.id,
      name = input.name,
      popularity = input.popularity,
      releaseDate = input.releaseDate,
      durationMs = input.durationMs,
      explicit = input.explicit,
      external_url = input.external_url,
//      artists = trackArtists
    )
  }
}

