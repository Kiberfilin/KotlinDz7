package model

import dto.*
import dto.posttypes.PostType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostModel(
    private val id: Long = 0,
    private val author: String,
    private val content: String,
    private var likeCount: Long = 0L,
    private var commentCount: Long = 0L,
    private var shareCount: Long = 0L,
    private var likedByMe: Boolean = false,
    private var commentedByMe: Boolean = false,
    private var sharedByMe: Boolean = false,
    private val postType: PostType,
    private val source: Post? = null,
    private var url: String? = null,
    private var address: String? = null,
    private var coordinates: Coordinates? = Coordinates(),
    private val created: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
    //private val created: String = LocalDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME)
) {
    fun getProperPostObject(): Post = when (postType) {
        PostType.POST -> Post(
            id,
            author,
            content,
            created,
            likeCount,
            commentCount,
            shareCount,
            likedByMe,
            commentedByMe,
            sharedByMe,
            postType,
            source
        )
        PostType.EVENT -> Event(
            id,
            author,
            content,
            created,
            likeCount,
            commentCount,
            shareCount,
            likedByMe,
            commentedByMe,
            sharedByMe,
            postType,
            source,
            address,
            coordinates
        )
        PostType.VIDEO -> Video(
            id,
            author,
            content,
            created,
            likeCount,
            commentCount,
            shareCount,
            likedByMe,
            commentedByMe,
            sharedByMe,
            postType,
            source,
            url
        )
        PostType.ADD -> Add(
            id,
            author,
            content,
            created,
            postType,
            url
        )
        PostType.REPOST -> Repost(
            id,
            author,
            content,
            created,
            likeCount,
            commentCount,
            shareCount,
            likedByMe,
            commentedByMe,
            sharedByMe,
            postType,
            source
        )
        else -> throw IllegalArgumentException("Нет такого типа поста!!!")
    }
}