package com.example.muxicapp

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

@Composable
fun SongLists(artistName: String, viewModel: SongLIstViewModel) {

    viewModel.getSongs(artistName)
    val state: SongListState = viewModel.state.value

    var currentPlayingSong by remember { mutableStateOf<ExoPlayer?>(null)}
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(WindowInsets.systemBars.asPaddingValues())) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            state.error != null -> {
                Text(text = state.error)
            }

            else -> {
                LazyColumn {
                    items(state.songs) { song ->
                        SongCard(
                            songTitle = song.title,
                            artistName = "eminem",
                            duration = song.duration,
                            url = song.preview,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun SongCard(
    songTitle: String,
    artistName: String,
    duration: String,
    url: String,
    viewModel: SongLIstViewModel,
){
    var isPlaying = viewModel.isPlaying.value

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Song title and artist name on the left
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = songTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = artistName,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Play button and duration on the right
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .clip(RoundedCornerShape(50)) // Apply rounded shape
                        .background(Color.Blue)  // Set background color to blue
                ) {
                    IconButton(
                        onClick = {
                            if (isPlaying && viewModel.currentPlayingUrl == url){
                                viewModel.pauseSong() // pause current player
                            } else{
                               viewModel.playSong(url)
                            }
                        }) {
                        Icon(
                            imageVector = if (isPlaying && url == viewModel.currentPlayingUrl) Icons.Default.Close else  Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = duration,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SongCardPreview() {
//    SongCard(
//        songTitle = "Lose Yourself",
//        artistName = "Eminem",
//        duration = "5:26",
//    )
//}