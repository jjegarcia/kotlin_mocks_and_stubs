interface MovieInfo {
    fun fetch(imdbId: String): HashMap<String,String>
}
