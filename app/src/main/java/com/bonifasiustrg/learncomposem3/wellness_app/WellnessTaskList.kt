package com.bonifasiustrg.learncomposem3.wellness_app

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier



@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> /*= remember { getWellnessTasks() }*/,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit
//    list: List<WellnessTask> = getWellnessTasks()
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list,
            key = { task -> task.id}
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = {checked ->
                    onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}