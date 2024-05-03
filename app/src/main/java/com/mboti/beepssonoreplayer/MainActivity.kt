package com.mboti.beepssonoreplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mboti.beepssonoreplayer.ui.theme.BeepsSonorePlayerTheme
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeepsSonorePlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SoundPlayer()
                }
            }
        }
    }
}

@Composable
fun SoundPlayer() {
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Button(onClick = {
                mediaPlayer = MediaPlayer.create(context, R.raw.beep_horaire) // Remplacez R.raw.your_audio_file par le nom de votre fichier audio dans le dossier /res/raw/
                mediaPlayer?.start()
            }) {
                Text("Play")
            }

            Button(onClick = {
                mediaPlayer?.pause()
            }) {
                Text("Pause")
            }
        }
    }
}