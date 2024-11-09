package com.example.muxicapp

data class Song (
    val title: String,
    val preview: String,
    val image: String,
    val duration: String,
)

data class Data(
    val data: List<Song>
)