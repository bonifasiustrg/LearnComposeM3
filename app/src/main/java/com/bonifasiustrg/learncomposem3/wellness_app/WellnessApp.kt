package com.bonifasiustrg.learncomposem3.wellness_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

import com.bonifasiustrg.learncomposem3.wellness_app.ui.theme.LearnComposeM3Theme

class WellnessAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeM3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

/*
    APP DESCRIPTION:
    The app has two main functionalities:
        A water counter to track your water intake.
        A list of wellness tasks to do throughout the day.
* */
//private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
@Composable
fun WellnessApp(modifier: Modifier = Modifier,
                wellnessViewModel: WellnessViewModel = viewModel()
) {
//    WaterCounter(modifier)
    Column(modifier) {
        StatefulCounter()

//        val list  = remember { getWellnessTasks().toMutableStateList() } //changed with viewmodel
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            },
            onCheckedTask = {task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            }
        )
    } /*{ task ->
            list.remove(task)
        }*/


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LearnComposeM3Theme {
        WellnessApp()
    }
}