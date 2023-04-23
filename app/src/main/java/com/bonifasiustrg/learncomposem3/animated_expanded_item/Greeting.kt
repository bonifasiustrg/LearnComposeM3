package com.bonifasiustrg.learncomposem3.animated_expanded_item

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.learncomposem3.ui.theme.LearnComposeM3Theme

@Composable
fun GreetingCard(modifier: Modifier = Modifier, names:List<String> = List(1000){"$it"}/*listOf("Bonifasius", "John", "Dimas")*/) {
    /*Column() {
        for (name in names) {
           GreetingCardItem(modifier, name = name)
        }
    }*/

    LazyColumn() {
        items(names) {
            GreetingCardItem(modifier = modifier, name = it)
        }
    }
}

@Composable
private fun GreetingCardItem(modifier: Modifier, name: String) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState (
        if (isExpanded) 48.dp else 0.dp,
        // optional parameter to customize animation
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
                         //to animate while expanded
    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(24.dp)
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
//                .padding(bottom = extraPadding)
        ) {
            Column(modifier = Modifier
                .weight(1f)
                // to prevent negative padding error after add spring animation extra padding
//                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello, ")
                Text(text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (isExpanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            ElevatedButton(
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                onClick = {
                    isExpanded = !isExpanded
            }) {
                Text(
                    text = if (isExpanded) "Show less" else "Show more",
                    color = MaterialTheme.colorScheme.primary)
                Icon(imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = "")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPrev() {
    LearnComposeM3Theme(){ GreetingCard(Modifier, listOf("Bonifasius", "John", "Dimas")) }
}