package com.composeunstyled.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeunstyled.Text
import com.composeunstyled.Thumb
import com.composeunstyled.ToggleSwitch

@Composable
fun ToggleSwitchDemo() {
    var toggled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Brush.linearGradient(listOf(Color(0xFFADD100), Color(0xFF7B920A)))),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                Modifier
                    .width(300.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .selectable(
                        selected = toggled,
                        onClick = { toggled = !toggled },
                        indication = LocalIndication.current,
                        interactionSource = null,
                        role = Role.Switch
                    ).padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Airplane Mode", fontSize = 18.sp)
                val animatedColor by animateColorAsState(
                    if (toggled) Color(0xFF4A7023) else Color(0xFFE0E0E0)
                )
                ToggleSwitch(
                    toggled = toggled,
                    shape = RoundedCornerShape(100),
                    backgroundColor = animatedColor,
                    modifier = Modifier.width(58.dp),
                    contentPadding = PaddingValues(4.dp),
                ) {
                    Thumb(
                        shape = CircleShape,
                        color = Color.White,
                        modifier = Modifier.shadow(elevation = 4.dp, CircleShape),
                    )
                }
            }
        }
    }
}
