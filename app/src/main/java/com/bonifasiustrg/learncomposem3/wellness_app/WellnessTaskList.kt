package com.bonifasiustrg.learncomposem3.wellness_app

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i")
}

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() },
    onCloseTask: (Any?) -> Unit,

//    list: List<WellnessTask> = getWellnessTasks()
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
//            WellnessTaskItem(taskName = task.label)
            WellnessTaskItem(taskName = task.label, onClose = { onCloseTask(task) })
        }
    }
}