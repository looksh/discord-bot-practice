package com.kimseung.discordbotpractice

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.env.Environment

@SpringBootApplication
class DiscordBotPracticeApplication

fun main(args: Array<String>) {
    val context: ConfigurableApplicationContext = SpringApplicationBuilder(DiscordBotPracticeApplication::class.java)
        .initializers()
        .run(*args)

    val environment: Environment = context.environment
    val discordToken = environment.getProperty("discord.token")
    println("Discord Token: $discordToken")

    val jdaBuilder = JDABuilder.createDefault(discordToken)
        .setActivity(Activity.playing("성훈이형패는중"))
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .build()
}
