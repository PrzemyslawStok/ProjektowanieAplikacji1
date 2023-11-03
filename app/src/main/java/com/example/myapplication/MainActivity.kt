package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

    fun PrintList(list: List<Int>): String {
        var textToReturn = "["

        for (i in 0..list.size - 1) {
            if (i != list.size - 1)
                textToReturn += "${list[i]},"
            else
                textToReturn += "${list[i]}"
        }
        return textToReturn + "]"
    }

    fun PrintText1(a: Int) = "a=$a"

    fun Mul(a: Double, b: Double) = a * b

    @Composable
    fun Add(a: Double, b: Double) {
        val list = listOf(1, 2, 3, 4, 5)

        fun f0(a: Int) = a + 5
        val f1: (Int) -> Int = { m: Int -> m + 5 }

        Row {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Simple image"
            )
            Column {
                //Text(PrintText())
                Text(PrintList(list))
                Text(PrintList(list.map { it * it }))
                Text(PrintList(list.map { it * it * it }))
                Text(PrintList(list.map { x -> x * x }))
                Text(PrintList(list.map { f0(it) }))
                //Text(PrintText1(10))
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
