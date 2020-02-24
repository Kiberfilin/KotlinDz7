import dto.Post
import dto.posttypes.PostType
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.withCharset
import io.ktor.server.testing.contentType
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import model.PostModel
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testGetAll() {
        withTestApplication({ module() }) {
            with(handleRequest(HttpMethod.Get, "/api/v1/posts")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
            }
        }
    }
    @Test
    fun testPostModel() {
        val pModel = PostModel(
            3, "CATS", "Repost 1 All your base are belong to us",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        )
        assertEquals(pModel.getProperPostObject().postType, PostType.REPOST)
    }
}