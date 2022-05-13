import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LibraryTest {
    @Test
    fun donateMovieAddedToCatalogueWithImdbInfo(){
        val imdbId="tt12345"
        val title = "The Abyss"
        val year=1989
        val movieInfo:MovieInfo = StubMovieInfo(title,year)
        val library= Library(movieInfo)
        library.donate(imdbId)
        val movie:Movie = library.findMovie(imdbId)
        assertEquals(title,movie.title)
        assertEquals(year,movie.year)
    }

 }

class StubMovieInfo( val title: String,val year: Int): MovieInfo {
    override fun fetch(imdbId: String): HashMap<String, String> {
        val info= hashMapOf<String,String>()
        info.put("title",title)
        info.put("year",year.toString())
        return info
    }

}