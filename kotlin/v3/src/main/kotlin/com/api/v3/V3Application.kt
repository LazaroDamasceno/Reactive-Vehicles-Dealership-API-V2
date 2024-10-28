package com.api.v3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class V3Application

fun main(args: Array<String>) {
	runApplication<V3Application>(*args)
}
