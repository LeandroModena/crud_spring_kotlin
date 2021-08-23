package dev.leandromodena.apicrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication
class ApicrudApplication

fun main(args: Array<String>) {
	runApplication<ApicrudApplication>(*args)
}
