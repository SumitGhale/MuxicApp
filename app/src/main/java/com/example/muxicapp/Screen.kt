package com.example.muxicapp

sealed class Screen(val route: String) {
    object ArtistScreen : Screen("artist_screen")
    object SongListScreen : Screen("song_list_screen")

}