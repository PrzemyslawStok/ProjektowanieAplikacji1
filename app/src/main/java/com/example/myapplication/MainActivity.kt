package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    fun ListMap(list: List<Int>, f: (Int) -> (Int)): List<Int> {
        val newList: MutableList<Int> = mutableListOf()

        for (element in list) {
            val a = f(element)
            newList.add(a)
        }

        return newList
    }

    @Composable
    fun Add(a: Double, b: Double) {
        val list = listOf(1, 2, 3, 4, 5)

        fun f0(a: Int) = a + 5
        val f1: (Int) -> Int = { m: Int -> m + 5 }
        val mul: (Int, Int) -> Int = { x, y -> x * y }

        Row {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Simple image"
            )
            Column {
                //Text(PrintText())
                Text(PrintList(list))
                Text(PrintList(ListMap(list, { i -> i + 10 })))

                Text(PrintList(ListMap(list) { i -> i + 10 }))


                //Text(PrintList(list.map { it * it }))
                //Text(PrintList(list.map { it * it * it }))
                //Text(PrintList(list.map { x -> x * x }))
                //Text(PrintList(list.map { f0(it) }))
                //Text(PrintList(list.map { mul(it, it) }))
                //Text(PrintText1(10))
                //Text(text = "a=$a")
                //Text(text = "b=$b")

                var number = 10

                var number1 by remember {
                    mutableStateOf(10)
                }

                Row {
                    val list1 = mutableListOf(1, 2, 3, 4, 5)
                    Text(PrintList(list1))
                    Text("$number")
                    Text("$number1")

                    Button(onClick = {
                        number += 1
                        number1 += 1
                    }) {
                        Text(text = "Dodaj element")
                        list1.add(1)
                    }
                }
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


