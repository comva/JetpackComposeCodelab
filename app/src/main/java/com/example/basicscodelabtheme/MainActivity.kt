package com.example.basicscodelabtheme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelabtheme.ui.theme.BasicsCodelabThemeTheme
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreenContent(listOf("Android","there"))
            }
        }
    }
}

@Composable
fun MyScreenContent(listOf: List<String>){
    val counterState = remember{mutableStateOf(0)}

    Column {
        for(elem in listOf){
            Greeting(elem)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
            count = counterState.value,
            updateCount = {newCount -> counterState.value = newCount}
        )
    }
}

@Composable
fun Counter(count: Int, updateCount:(Int) -> Unit) {
    Button(onClick = {updateCount(count+1)}) {
        Text(text = "I've been clicked $count times")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    BasicsCodelabThemeTheme() {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",modifier= Modifier.padding(24.dp))
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
//Cambio para diferenciar una rama de otra
    MyApp{
        //Greeting(name = "Android")
        MyScreenContent(listOf("Android","there"))
    }
}