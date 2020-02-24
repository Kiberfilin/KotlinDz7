package repository

import dto.*
import dto.posttypes.PostType
import model.PostModel

interface PostRepository {
    suspend fun getAll(): List<PostModel>
    //suspend fun getById(id: Long): PostModel?
    //suspend fun save(item: PostModel): PostModel
    //suspend fun removeById(id: Long)
    //suspend fun likeById(id: Long): PostModel?
    //suspend fun dislikeById(id: Long): PostModel?
    //suspend fun repostById(id: Long): PostModel?
    //suspend fun shareById(id: Long): PostModel?
}

class PostRepositoryImpl : PostRepository {
    override suspend fun getAll(): List<PostModel> = testData()
}

fun testData() = listOf(
    PostModel(
        1, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        2, "CATS", "Event: All your base are belong to us",
        likeCount = 3,
        commentCount = 31,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.EVENT,
        address = "Shimizu, Suginami City, Tokyo, Japan",
        coordinates = Coordinates(35.7135292, 139.6134291)
    ),
    PostModel(
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
    ),
    PostModel(
        348032,
        "CATS",
        "Реклама: All your base are belong to us",
        postType = PostType.ADD,
        url = "https://duckduckgo.com/?q=herbalife&atb=v127-3bd&ia=web"

    ),
    PostModel(
        4, "CATS", "Repost 2 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Event(
            523,
            "CATS",
            "Source event post for repost. Event: All your base are belong to us",
            "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        )
    ), PostModel(
        5, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        6, "CATS", "Event: All your base are belong to us",
        likeCount = 3,
        commentCount = 31,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.EVENT,
        address = "Shimizu, Suginami City, Tokyo, Japan",
        coordinates = Coordinates(35.7135292, 139.6134291)
    ),
    PostModel(
        7, "CATS", "Repost 1 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Post(
            1234, "CATS", "Source post for repost. All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.POST
        )
    ),
    PostModel(
        8, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        9, "CATS", "Repost 2 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Event(
            1323,
            "CATS",
            "Source event post for repost. Event: All your base are belong to us",
            "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        )
    ), PostModel(
        10, "CATS", "All your base are belong to us",
        likeCount = 25,
        commentCount = 8,
        shareCount = 12,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.VIDEO,
        url = "https://www.youtube.com/watch?v=jQE66WA2s-A"
    ),
    PostModel(
        11, "CATS", "Event: All your base are belong to us",
        likeCount = 3,
        commentCount = 31,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.EVENT,
        address = "Shimizu, Suginami City, Tokyo, Japan",
        coordinates = Coordinates(35.7135292, 139.6134291)
    ),
    PostModel(
        12, "CATS", "Repost Video All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Video(
            33344, "CATS", "All your base are belong to us", "1992",
            likeCount = 25,
            commentCount = 8,
            shareCount = 12,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.VIDEO,
            url = "https://www.youtube.com/watch?v=jQE66WA2s-A"
        )
    ),
    PostModel(
        13, "CATS", "Repost 1 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Post(
            21034, "CATS", "Source post for repost. All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.POST
        )
    ),
    PostModel(
        14, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        15, "CATS", "Repost 2 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Event(
            32312,
            "CATS",
            "Source event post for repost. Event: All your base are belong to us",
            "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        )
    ), PostModel(
        16, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        17, "CATS", "Event: All your base are belong to us",
        likeCount = 3,
        commentCount = 31,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.EVENT,
        address = "Shimizu, Suginami City, Tokyo, Japan",
        coordinates = Coordinates(35.7135292, 139.6134291)
    ),
    PostModel(
        18, "CATS", "Repost 1 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Post(
            14234, "CATS", "Source post for repost. All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.POST
        )
    ),
    PostModel(
        19, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        20, "CATS", "Repost 2 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Event(
            33823,
            "CATS",
            "Source event post for repost. Event: All your base are belong to us",
            "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        )
    ), PostModel(
        21, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        22, "CATS", "Event: All your base are belong to us",
        likeCount = 3,
        commentCount = 31,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.EVENT,
        address = "Shimizu, Suginami City, Tokyo, Japan",
        coordinates = Coordinates(35.7135292, 139.6134291)
    ),
    PostModel(
        23, "CATS", "Repost 1 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Post(
            19234, "CATS", "Source post for repost. All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.POST
        )
    ),
    PostModel(
        24, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = true,
        sharedByMe = false,
        postType = PostType.POST
    ),
    PostModel(
        25, "CATS", "Repost 2 All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.REPOST,
        source = Event(
            29323,
            "CATS",
            "Source event post for repost. Event: All your base are belong to us",
            "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        )
    ),
    PostModel(
        26, "CATS", "All your base are belong to us",
        likeCount = 3,
        commentCount = 1,
        shareCount = 0,
        likedByMe = true,
        commentedByMe = false,
        sharedByMe = false,
        postType = PostType.POST
    )
)