package com.raellacerda.chapter1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class Chapter1Application

fun main(args: Array<String>) {
    runApplication<Chapter1Application>(*args)
}
