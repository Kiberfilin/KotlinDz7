package route

import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.features.ParameterConversionException
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.util.KtorExperimentalAPI
import model.PostModel
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein
import repository.PostRepository

@KtorExperimentalAPI
fun Routing.v1() {
    route("/api/v1/posts") {
        val repository by kodein().instance<PostRepository>()
        get {
            //Скачать все посты
            val response = repository.getAll().map {
                //println("${it.getProperPostObject()}")
                it.getProperPostObject()
            }
            call.respond(response)
        }
        get("/{id}") {
            //Скачать пост с данным id
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            val response = repository.getById(id) ?: throw NotFoundException()
            call.respond(response.getProperPostObject())
        }
        post("/create") {
            //Создание нового поста
            val inputPostModel = call.receive<PostModel>()
            val response = repository.create(inputPostModel).getProperPostObject()
            call.respond(response)
        }
        patch("/{id}/update") {
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            val inputPostModel = call.receive<PostModel>()
            val response = repository.update(id, inputPostModel).getProperPostObject()
            call.respond(response)
        }
        delete("/{id}") {
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            repository.removeById(id)
        }
        post("/{id}/likes") {
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            val response = repository.likeById(id)?.getProperPostObject()
            response?.let { call.respond(it) }
        }
        delete("/{id}/likes") {
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            val response = repository.dislikeById(id)?.getProperPostObject()
            response?.let { call.respond(it) }
        }
        post("/repost") {
            val inputPostModel = call.receive<PostModel>()
            val response = repository.repost(inputPostModel)?.getProperPostObject()
            response?.let { call.respond(it) }
        }
        post("/{id}/share") {
            val id = call.parameters["id"]?.toLongOrNull() ?: throw ParameterConversionException("id", "Long")
            val response = repository.shareById(id)?.getProperPostObject()
            response?.let { call.respond(it) }
        }
    }
}