package com.bonifasiustrg.learncomposem3.wellness_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)){
        var count by remember {
            mutableStateOf(0)
        }

        if (count>0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }
            Text(text = "You've had $count glasses.")
        }

        Row(modifier.padding(top = 8.dp)) {
            Button(modifier = modifier,
                onClick = { count++ },
                enabled = count < 10,
                colors = ButtonDefaults.buttonColors(disabledContainerColor = Color.Gray)
            ) {
                Text(text = "Add one")
            }

            Button(onClick = {
                count = 0
            }, modifier.padding(start = 8.dp)
            ) {
                Text(text = "Clear water count")
            }
        }

    }
}*/

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ },Modifier.padding(top = 8.dp),
            enabled = count < 10,
            colors = ButtonDefaults.buttonColors(disabledContainerColor = Color.Gray, disabledContentColor = Color.White)
        ) {
            Text("Add one")
        }
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableStateOf(0) }
//    var juiceCount by rememberSaveable { mutableStateOf(0) }

    Column() {
        StatelessCounter(waterCount, { waterCount++ }, modifier)
//        StatelessCounter(juiceCount, { juiceCount++ }, modifier)

    }
}

@Composable
fun WellnessTaskItem(taskName: String,
                     modifier: Modifier = Modifier,
                     onClose: () -> Unit
) {
    var checkedState by remember { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = {
                newValue -> checkedState = newValue
                          },
        onClose = { onClose()}, // we will implement this later!
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun WellnessAppPrev() {
    MaterialTheme() {
//    WaterCounter()
//        WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?", modifier = Modifier)
    }
}
