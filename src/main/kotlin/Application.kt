import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import dto.*
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.NotFoundException
import io.ktor.features.ParameterConversionException
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.server.cio.EngineMain
import io.ktor.util.KtorExperimentalAPI
import model.PostModel
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.kodein.di.ktor.KodeinFeature
import repository.PostRepository
import repository.PostRepositoryImpl
import route.v1

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@KtorExperimentalAPI
fun Application.module() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
                .addDeserializationExclusionStrategy(object : ExclusionStrategy {
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        return false
                    }

                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        return if (f != null) {
                            (f.declaringClass == PostModel::class.java && f.name == "id")
                        } else false
                    }
                })
        }
    }

    install(StatusPages) {
        exception<NotImplementedError> { e ->
            call.respond(HttpStatusCode.NotImplemented)
            throw e
        }
        exception<ParameterConversionException> { e ->
            call.respond(HttpStatusCode.BadRequest)
            throw e
        }
        exception<Throwable> { e ->
            call.respond(HttpStatusCode.InternalServerError)
            throw e
        }
        exception<NotFoundException> { e ->
            call.respond(HttpStatusCode.NotFound)
            throw e
        }
    }
    install(KodeinFeature) {

        bind<PostRepository>() with singleton { PostRepositoryImpl() }
    }

    install(Routing) {
        v1()
    }
}