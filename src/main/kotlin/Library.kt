class Library(val movieInfo: MovieInfo, val emailServer: EmailServer) {
    val catalogue = hashMapOf<String, Movie>()

    fun findMovie(imdbId: String): Movie {
        return catalogue.get(imdbId) ?: Movie("", 0)
    }

    fun donate(imdbId: String) {
        val info = movieInfo.fetch(imdbId)
        catalogue.put(imdbId, Movie(info.get("title") ?: "", (info.get("year") ?: "").toInt()))
        emailServer.send("New Movie", "All Members", arrayOf(info.get("title") ?: "", info.get("year") ?: ""))
    }
}
