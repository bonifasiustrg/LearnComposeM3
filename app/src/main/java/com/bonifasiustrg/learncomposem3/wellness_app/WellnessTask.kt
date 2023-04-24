package com.bonifasiustrg.learncomposem3.wellness_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(val id: Int, val label: String)

//data class WellnessTask(val id: Int, val label: String, var checked: /*Boolean*/MutableState<Boolean> = mutableStateOf(false))

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}