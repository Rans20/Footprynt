package com.example.footprynt.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footprynt.R

@Composable
fun FootpryntLogo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LogoIcon(modifier = Modifier.size(200.dp))
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFF0B1222)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.track),
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF64748B)
            )
            Dot()
            Text(
                text = stringResource(id = R.string.reduce),
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF64748B)
            )
            Dot()
            Text(
                text = stringResource(id = R.string.impact),
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF64748B)
            )
        }
    }
}

@Composable
private fun Dot(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(4.dp)) {
        drawCircle(color = Color(0xFF22C55E))
    }
}

private data class ToeData(val offset: Offset, val radius: Dp, val color: Color)

@Composable
private fun LogoIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        
        // Colors
        val teal = Color(0xFF2DD4BF)
        val green = Color(0xFF4ADE80)
        val leafGreen = Color(0xFF22C55E)
        val darkGreen = Color(0xFF15803D)
        val blue = Color(0xFF0EA5E9)

        // Toes
        val toes = listOf(
            ToeData(Offset(w * 0.22f, h * 0.32f), 6.dp, green),
            ToeData(Offset(w * 0.32f, h * 0.22f), 8.dp, green),
            ToeData(Offset(w * 0.45f, h * 0.18f), 10.dp, teal),
            ToeData(Offset(w * 0.58f, h * 0.20f), 12.dp, teal),
            ToeData(Offset(w * 0.72f, h * 0.28f), 15.dp, blue)
        )

        toes.forEach { toe ->
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(toe.color, toe.color.copy(alpha = 0.8f)),
                    center = toe.offset,
                    radius = toe.radius.toPx()
                ),
                center = toe.offset,
                radius = toe.radius.toPx()
            )
        }

        // Footprint Body (Fingerprint lines)
        for (i in 0 until 8) {
            val inset = i * 6.dp.toPx()
            val path = Path().apply {
                addOval(
                    Rect(
                        left = w * 0.25f + inset * 0.5f,
                        top = h * 0.35f + inset,
                        right = w * 0.65f - inset * 0.2f,
                        bottom = h * 0.85f - inset * 0.2f
                    )
                )
            }
            drawPath(
                path = path,
                brush = Brush.verticalGradient(
                    colors = listOf(green, teal),
                    startY = h * 0.35f,
                    endY = h * 0.85f
                ),
                style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round),
                alpha = (1f - i * 0.1f).coerceAtLeast(0.2f)
            )
        }

        // Leaf
        val leafPath = Path().apply {
            moveTo(w * 0.50f, h * 0.90f)
            cubicTo(w * 0.90f, h * 0.85f, w * 0.95f, h * 0.45f, w * 0.65f, h * 0.35f)
            cubicTo(w * 0.35f, h * 0.45f, w * 0.40f, h * 0.85f, w * 0.50f, h * 0.90f)
        }

        drawPath(
            path = leafPath,
            brush = Brush.linearGradient(
                colors = listOf(leafGreen, darkGreen),
                start = Offset(w * 0.5f, h * 0.9f),
                end = Offset(w * 0.7f, h * 0.4f)
            )
        )

        // Leaf Veins
        val veinPath = Path().apply {
            moveTo(w * 0.50f, h * 0.90f)
            lineTo(w * 0.65f, h * 0.35f)
            
            // Side veins
            moveTo(w * 0.55f, h * 0.75f)
            lineTo(w * 0.78f, h * 0.72f)
            
            moveTo(w * 0.58f, h * 0.65f)
            lineTo(w * 0.82f, h * 0.60f)
            
            moveTo(w * 0.61f, h * 0.55f)
            lineTo(w * 0.80f, h * 0.50f)
        }

        drawPath(
            path = veinPath,
            color = Color.White.copy(alpha = 0.5f),
            style = Stroke(width = 1.5.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FootpryntLogoPreview() {
    FootpryntTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            FootpryntLogo()
        }
    }
}
