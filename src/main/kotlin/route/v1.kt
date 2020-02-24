package route

import dto.Add
import dto.Coordinates
import dto.Event
import dto.Post
import dto.posttypes.PostType
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.*
import model.PostModel
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein
import repository.PostRepository
import repository.PostRepositoryImpl

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
        post("/{JSON}") {
            //TODO("Создание или обновление поста")
        }
        delete("/{id}") {
            //TODO("Удаление поста по id")
        }
        post("/{id}/likes") {
            //TODO("Добавление лайка")
        }
        delete("/{id}/likes") {
            //TODO("Удаление лайка")
        }
        post("/{id}/repost") {
            //TODO("Репост")
        }
        post("/{id}/share") {
            //TODO("Шаринг")
        }
    }
}