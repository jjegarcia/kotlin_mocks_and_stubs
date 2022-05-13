import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LibraryTest {
    @Test
    fun donateMovieAddedToCatalogueWithImdbInfo(){
        val imdbId="tt12345"
        val title = "The Abyss"
        val year=1989
        val library= Library()
        library.donate(imdbId)
        val movie:Movie = library.findMovie(imdbId)
        assertEquals(title,movie.title)
        assertEquals(year,movie.year)
    }
}