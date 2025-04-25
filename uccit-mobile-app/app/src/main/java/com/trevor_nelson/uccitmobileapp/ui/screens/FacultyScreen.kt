package com.trevor_nelson.uccitmobileapp.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.trevor_nelson.uccitmobileapp.R

data class FacultyMember(
    val name: String,
    val position: String,
    val imageResId: Int,
    val phone: String,
    val email: String
)

val mockFaculty = listOf(
    FacultyMember(
        name = "Dr. Yvette D. Clarke",
        position = "Professor of Computer Science",
        imageResId = R.drawable.yvette_d_clarke,
        phone = "876-555-0101",
        email = "yvette.clarke@ucc.edu"
    ),
    FacultyMember(
        name = "Prof. Gary Hendrickson",
        position = "Associate Professor of IT",
        imageResId = R.drawable.gary_hendrickson,
        phone = "876-555-0102",
        email = "gary.hendrickson@ucc.edu"
    ),
    FacultyMember(
        name = "Dr. Richard Byles",
        position = "Lecturer in Data Science",
        imageResId = R.drawable.richard_byles,
        phone = "876-555-0103",
        email = "richard.byles@ucc.edu"
    )
)

@Composable
fun FacultyScreen() {
    val context = LocalContext.current

    // Function to dial a phone number
    fun dialPhone(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        context.startActivity(intent)
    }

    // Function to send an email
    fun sendEmail(email: String) {
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
            text = "Faculty Directory",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary, // UccRed
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(mockFaculty) { faculty ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = faculty.imageResId),
                            contentDescription = faculty.name,
                            modifier = Modifier
                                .size(64.dp)
                                .padding(end = 16.dp)
                        )
                        Column {
                            Text(
                                text = faculty.name,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary // UccRed
                            )
                            Text(
                                text = faculty.position,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                                    .clickable { dialPhone(faculty.phone) }
                            ) {
                                Text(
                                    text = "Phone: ${faculty.phone}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary, // UccBlue
                                    textDecoration = TextDecoration.Underline
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                                    .clickable { sendEmail(faculty.email) }
                            ) {
                                Text(
                                    text = "Email: ${faculty.email}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary, // UccBlue
                                    textDecoration = TextDecoration.Underline
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}