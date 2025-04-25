package com.trevor_nelson.uccitmobileapp.ui.theme

import androidx.compose.ui.graphics.Color

val UccRed = Color(0xFFB71C1C)
val UccBlue = Color(0xFF003366)
val UccGold = Color(0xFFFFD700)
val DarkBackground = Color(0xFF121212)
val LightBackground = Color(0xFFFFFFFF)

Button(
onClick = onNavigateToFaculty,
modifier = Modifier
.fillMaxWidth()
.padding(vertical = 8.dp),
colors = ButtonDefaults.buttonColors(
containerColor = MaterialTheme.colorScheme.primary // UccRed
)
) {
    Text("Explore Faculty")
}