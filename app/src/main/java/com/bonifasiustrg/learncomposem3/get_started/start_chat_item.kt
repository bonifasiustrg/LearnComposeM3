package com.bonifasiustrg.learncomposem3.get_started

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.learncomposem3.R
import com.bonifasiustrg.learncomposem3.get_started.Message


@Composable
fun MessageCard() {
    LazyColumn() {
        items(msgList) {
            MessageCardItem(msg = it)
        }
    }

}

@Composable
fun MessageCardItem(msg: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    )

    Row(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.profile_photo), contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = Color.Magenta, CircleShape),

            )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
        ) {
            Text(text = msg.name, modifier = Modifier, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
                    .clickable {
                    isExpanded = /*true*/ !isExpanded
                }
            ) {
                Text(
                    text = msg.message,
                    fontWeight = FontWeight.Normal,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }


}

@Preview(name = "lightmode", showBackground = true)
/*@Preview(
    name = "darkmode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)*/
@Composable
fun MessageCardPrev() {
    /*MessageCardItem(msg = Message(
        "Bonifasius", "Whats going on there, bro?"
    ))*/
    LazyColumn() {
        items(msgList) {
            MessageCardItem(msg = it)
        }
    }
}

