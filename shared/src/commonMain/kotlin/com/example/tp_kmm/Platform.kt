package com.example.tp_kmm

expect class Platform() {
    val platform: String
}

expect fun initLogger()

expect fun testeoQueSumeBien(): Int
expect fun testeoQueResteBien(): Int
