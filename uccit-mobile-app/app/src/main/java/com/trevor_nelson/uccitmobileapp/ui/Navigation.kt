package com.trevor_nelson.uccitmobileapp.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.trevor_nelson.uccitmobileapp.R
import com.trevor_nelson.uccitmobileapp.ui.screens.AdmissionsScreen
import com.trevor_nelson.uccitmobileapp.ui.screens.CoursesScreen
import com.trevor_nelson.uccitmobileapp.ui.screens.FacultyScreen
import com.trevor_nelson.uccitmobileapp.ui.screens.MainScreen
import com.trevor_nelson.uccitmobileapp.ui.screens.SocialScreen

object Destinations {
    const val MAIN = "main"
    const val FACULTY = "faculty"
    const val COURSES = "courses"
    const val ADMISSIONS = "admissions"
    const val SOCIAL = "social"
}

data class BottomNavItem(val route: String, val label: String, val iconResId: Int)

val bottomNavItems = listOf(
    BottomNavItem(Destinations.MAIN, "Home", R.drawable.ic_launcher_foreground), // Placeholder, replace with ic_home.png if added
    BottomNavItem(Destinations.FACULTY, "Faculty", R.drawable.ic_faculty),
    BottomNavItem(Destinations.COURSES, "Courses", R.drawable.ic_courses),
    BottomNavItem(Destinations.ADMISSIONS, "Admissions", R.drawable.ic_admissions),
    BottomNavItem(Destinations.SOCIAL, "Social", R.drawable.ic_social)
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // Function to send an email to the HOD
    fun sendEmailToHOD() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:ithod@ucc.edu.jm")
            putExtra(Intent.EXTRA_SUBJECT, "Inquiry for Otis Osbourne from UCC IT Mobile App")
        }
        context.startActivity(intent)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(item.label) },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = item.label
                            )
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { sendEmailToHOD() },
                containerColor = MaterialTheme.colorScheme.primary // UccRed
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email HOD"
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.MAIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destinations.MAIN) {
                MainScreen(
                    onNavigateToFaculty = { navController.navigate(Destinations.FACULTY) },
                    onNavigateToCourses = { navController.navigate(Destinations.COURSES) },
                    onNavigateToAdmissions = { navController.navigate(Destinations.ADMISSIONS) },
                    onNavigateToSocial = { navController.navigate(Destinations.SOCIAL) }
                )
            }
            composable(Destinations.FACULTY) { FacultyScreen() }
            composable(Destinations.COURSES) { CoursesScreen() }
            composable(Destinations.ADMISSIONS) { AdmissionsScreen() }
            composable(Destinations.SOCIAL) { SocialScreen() }
        }
    }
}