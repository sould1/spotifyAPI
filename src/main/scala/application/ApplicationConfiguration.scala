package application

object ApplicationConfiguration {
  val base_url = "https://api.spotify.com" //api base url
//  val path = "./ressources" // package resources pour les json, les track

  val id_artiste_base = "246dkjvS1zLTtiykXe5h60"
  val artist_endpoint = base_url + "/v1/artists/"
  val tracks_endpoint = base_url+ "/v1/artists/"+id_artiste_base+"/top-tracks?market=fr"
  val token = "BQA_2oV91f0qA4pyO87Cgw4JKoM2CqQORQyow-Q7B2zzq3NXsriNMhP42PU7kRaC834yuX6qkmpNpfMYFlPBluOho9BQ9nwxt7BW3Q0rfQFfYrTdtsSghSR43qA6XSaG8W1EjhzERXoNvLraAuRa9d4tSHvuTOI3s2onsdj3qJMdugE8beLvNsI_dqS0jdIGFh18w8kTcxhcYWFQg09ZhFaphIWySVlDS-6bQgKdQr1-5ROjxQLqElwdhxd9G8iOChg6ORE6_tLS1KL5_4spbu_lPdPmWSj94gYWNbsW"
}
