import io.mockk.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LibraryTest {
    val imdbId = "tt12345"
    val title = "The Abyss"
    val year = 1989
    val movieInfo: MovieInfo = mockk()
    val info = hashMapOf("title" to title, "year" to year.toString())

    @Test
    fun donateMovieAddedToCatalogueWithImdbInfo() {
        every { movieInfo.fetch(any()) } returns info

        val library = Library(movieInfo = movieInfo, emailServer = mockk(relaxed = true))
        library.donate(imdbId)
        val movie: Movie = library.findMovie(imdbId)

        assertEquals(title, movie.title)
        assertEquals(year, movie.year)
    }

    @Test
    fun membersEmailedAboutNewTitle() {
        val emailServer: EmailServer = mockk(relaxed = true)

        every { movieInfo.fetch(any()) } returns info

        val library = Library(movieInfo = movieInfo, emailServer = emailServer)
        library.donate(imdbId)

        verify {
            emailServer.send(subjet = "New Movie", recepient = "All Members", params = arrayOf(title, year.toString()))
        }
    }
}