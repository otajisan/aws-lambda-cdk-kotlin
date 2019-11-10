package io.code.morning

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.apache.logging.log4j.LogManager

data class Response(val body: String)

class SimpleLambdaFunction : RequestHandler<Map<String, Any>, Response> {
    companion object {
        private val log = LogManager.getLogger()
    }

    fun hello(): String = "hello world"

    override fun handleRequest(input: Map<String, Any>, context: Context): Response {
        log.info("received : $input")
        return Response("hello otajisan")
//        return Response(input["param"]?.toString() ?: "empty")
    }
}