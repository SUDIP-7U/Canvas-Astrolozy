package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}


@Composable
fun BirthChartOverlay() {
    Box(
        modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF3E0)),
        contentAlignment = Alignment.Center
    ) {
        // Background chart
        Canvas(modifier = Modifier.fillMaxSize()) {
            val radius = size.minDimension / 2
            val center = Offset(size.width / 2, size.height / 2)

            // Divide into 12 houses
            for (i in 0 until 12) {
                val angle = (Math.PI * 2 / 12) * i
                val endX = center.x + radius * cos(angle).toFloat()
                val endY = center.y + radius * sin(angle).toFloat()
                drawLine(
                    color = Color.Gray,
                    start = center,
                    end = Offset(endX, endY),
                    strokeWidth = 2f
                )
            }
        }

        // Overlay planets by house
        Text("♀ Venus", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = -80.dp, y = (-160).dp))

        Text("♃ Jupiter", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (-120).dp, y = (-80).dp)) // 2nd house

        Text("♄ Saturn", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (-140).dp, y = (-40).dp))


        Text("☉ Sun", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (-80).dp, y = (-50).dp))

        Text("☿ Mercury", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (-60).dp, y = (-30).dp))


        Text("☿ RAHU", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (-60).dp, y = (0).dp))

        Text("☿ Moon  Ketu ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = (80).dp, y = (-20).dp))

    }
}


@Preview(showBackground = true)
@Composable
fun BirthChartPreview() {
    BirthChartOverlay()
}
