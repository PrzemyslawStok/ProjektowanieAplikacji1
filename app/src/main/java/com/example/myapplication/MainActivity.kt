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
            MyApplicationTheme {
                Surface {
                    Add(10.0, 5.0)
                }
            }
        }
    }

    @Composable
    fun Hello(name: String) {
        Text(text = "Witaj $name!")
    }

    fun PrintText(): String {
        var textToReturn = "["

        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        /*for (number in 1..10 step 2) {
            if (number < 10) {
                textToReturn += "$number"
            }
        }
         */

        for (i in 0..list.size - 1) {
            textToReturn += "${list[i]},"
        }

        return textToReturn + "]"
    }

    fun PrintText1(a: Int) = "a=$a"

    @Composable
    fun Add(a: Double, b: Double) {
        Row {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Simple image"
            )
            Column {
                Text(PrintText())
                Text(PrintText1(10))
                //Text(text = "a=$a")
                //Text(text = "b=$b")
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
        MyApplicationTheme {
            Surface {
                Add(2.0, 1.0)

            }
        }
    }
}
