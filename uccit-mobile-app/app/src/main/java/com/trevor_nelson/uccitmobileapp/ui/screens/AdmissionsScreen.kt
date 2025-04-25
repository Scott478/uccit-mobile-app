package com.trevor_nelson.uccitmobileapp.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.trevor_nelson.uccitmobileapp.R

@Composable
fun AdmissionsScreen() {
    val context = LocalContext.current

    // Function to open a URL
    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    // Function to open an email client
    fun openEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Admissions Information",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary, // UccRed
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Requirements for IT Department Admission:",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary, // UccRed
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "- 5 CSEC/O-Level passes (Grades 1-3), including English and Mathematics\n" +
                    "- Minimum age of 17 at the time of admission\n" +
                    "- Applicants with 3-4 passes may complete a preliminary programme\n" +
                    "- Attend an interview with the IT Department\n" +
                    "- Submit application form, transcripts, and supporting documents",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                    openUrl("https://ucc.edu.jm/documents-forms#application")
                }
        ) {
            Text(
                text = "Apply online at ucc.edu.jm/documents-forms",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary, // UccBlue
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                    openEmail("admissions@ucc.edu")
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "Email Icon",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Contact: admissions@ucc.edu",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary, // UccBlue
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center
            )
        }
    }
}