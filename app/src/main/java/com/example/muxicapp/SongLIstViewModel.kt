package com.example.muxicapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import kotlinx.coroutines.launch

class SongLIstViewModel(private val context: Context): ViewModel() {
    private val _state = mutableStateOf(SongListState())
    val state: State<SongListState> = _state
    private val exoPlayer = ExoPlayer.Builder(context).build()
    var currentPlayingUrl by mutableStateOf<String?>(null)

    val isPlaying = mutableStateOf(false)

    fun playSong(url: String){
        //  set the media item only if it is different song
        if (currentPlayingUrl != url){
            val mediaItem = MediaItem.fromUri(url)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            currentPlayingUrl = url
        }
        exoPlayer.playWhenReady = true
        isPlaying.value = true
    }

    fun pauseSong() {
        exoPlayer.playWhenReady = false
        isPlaying.value = false
    }

    override fun onCleared() {
        super.onCleared()
        exoPlayer.release()
    }

    fun getSongs(artistName: String) {
        viewModelScope.launch {
            try {
                val response = artistSongs.getSongs(artistName)
                _state.value = _state.value.copy(
                    isLoading = false,
                    songs = response.data
                )
            }catch (e: Exception){
                Log.d("Error", "getSongs: " + e.printStackTrace())
            }
        }
    }
}

data class SongListState(
    val isLoading: Boolean = true,
    val songs: List<Song> = emptyList(),
    val error: String? = null
)