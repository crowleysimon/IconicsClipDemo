package com.simonc.iconicsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.compose.IconicsConfig
import com.mikepenz.iconics.compose.Image
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.view.IconicsImageView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(8.dp),
                ) {
                    BasicText("Compose")
                    Image(asset = FontAwesome.Icon.faw_crown)
                    BasicText(text = "View")
                    AndroidView(
                        modifier = Modifier.size(24.dp),
                        factory = { context ->
                            IconicsImageView(context).apply {
                                icon = IconicsDrawable(context, FontAwesome.Icon.faw_crown)
                            }
                        }
                    )
                    BasicText("Compose without respectFontBounds")
                    Image(
                        asset = FontAwesome.Icon.faw_crown,
                        iconicsConfig = IconicsConfig(
                            respectFontBounds = false,
                            paddingDp = 0
                        )
                    )
                }
            }
        }
    }
}