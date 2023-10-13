package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Add(10.0, 5.0)
        }
    }

    @Composable
    fun Hello(name: String) {
        Text(text = "Witaj $name!")
    }

    @Composable
    fun Add(a: Double, b: Double) {
        Row {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Simple image"
            )
            Column {
                Text(text = "a=$a")
                Text(text = "b=$b")
            }
            Image(
                painter = painterResource(id = R.mipmap.ic_image),
                contentDescription = "Simple image",
                modifier = Modifier
                    .size(100.dp)
                    .alpha(0.1f)
                //.clip(CircleShape)
            )
        }
    }

    @Preview
    @Composable
    fun PreviewScreen() {
        Add(2.0, 1.0)
    }
}
