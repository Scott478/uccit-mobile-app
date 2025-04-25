package com.trevor_nelson.uccitmobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.trevor_nelson.uccitmobileapp.R

@Composable
fun MainScreen(
    onNavigateToFaculty: () -> Unit,
    onNavigateToCourses: () -> Unit,
    onNavigateToAdmissions: () -> Unit,
    onNavigateToSocial: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Using ucc_logo.png as the logo
        Image(
            painter = painterResource(id = R.drawable.ucc_logo),
            contentDescription = "UCC Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Welcome to UCC IT Mobile App",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
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
        Button(
            onClick = onNavigateToCourses,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary // UccRed
            )
        ) {
            Text("View Courses")
        }
        Button(
            onClick = onNavigateToAdmissions,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary // UccRed
            )
        ) {
            Text("Admissions Info")
        }
        Button(
            onClick = onNavigateToSocial,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary // UccRed
            )
        ) {
            Text("Social Hub")
        }
    }
}