package com.composeunstyled.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.composables.core.BottomSheet
import com.composables.core.DragIndication
import com.composables.core.SheetDetent
import com.composables.core.SheetDetent.Companion.FullyExpanded
import com.composables.core.SheetDetent.Companion.Hidden
import com.composables.core.rememberBottomSheetState
import com.composeunstyled.Button
import com.composeunstyled.Text
import com.composeunstyled.focusRing

private val Peek = SheetDetent("peek") { containerHeight, sheetHeight ->
    containerHeight * 0.6f
}

@Composable
fun BottomSheetDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Color(0xFF800080), Color(0xFFDA70D6))))
            .padding(top = 12.dp)
            .statusBarsPadding()
            .padding(WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal).asPaddingValues()),
    ) {
        val sheetState = rememberBottomSheetState(
            initialDetent = Peek,
            detents = listOf(Hidden, Peek, FullyExpanded),
        )

        Button(
            onClick = { sheetState.targetDetent = Peek },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal).asPaddingValues()),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 10.dp),
            backgroundColor = Color.White
        ) {
            Text("Show Sheet", fontWeight = FontWeight(500))
        }

        BottomSheet(
            state = sheetState,
            backgroundColor = Color.White,
            contentColor = Color.Black,
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .widthIn(max = 640.dp)
                .fillMaxWidth(),
        ) {
            Box(Modifier.fillMaxWidth().height(600.dp), contentAlignment = Alignment.TopCenter) {
                val interactionSource = remember { MutableInteractionSource() }

                DragIndication(
                    interactionSource = interactionSource,
                    modifier = Modifier
                        .padding(top = 22.dp)
                        .focusRing(
                            interactionSource,
                            width = 2.dp,
                            Color(0XFF2563EB),
                            RoundedCornerShape(100),
                            offset = 4.dp
                        )
                        .background(Color.Black.copy(0.4f), RoundedCornerShape(100))
                        .size(32.dp, 4.dp)
                )
            }
        }
    }
}
