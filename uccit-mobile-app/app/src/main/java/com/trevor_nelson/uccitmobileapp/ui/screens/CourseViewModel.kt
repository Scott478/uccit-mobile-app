package com.trevor_nelson.uccitmobileapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevor_nelson.uccitmobileapp.data.Course
import com.trevor_nelson.uccitmobileapp.data.CourseDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoursesViewModel : ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses

    fun loadCourses(courseDao: CourseDao) {
        viewModelScope.launch {
            courseDao.getAllCourses().collect { courseList ->
                _courses.value = courseList
            }
        }
    }

    fun insertSampleCourses(courseDao: CourseDao) {
        viewModelScope.launch {
            courseDao.deleteAllCourses() // Clear existing data
            val sampleCourses = listOf(
                Course(
                    code = "IT101",
                    title = "Introduction to Programming",
                    credits = 3,
                    prerequisites = "None",
                    description = "Learn the basics of coding with Python."
                ),
                Course(
                    code = "IT102",
                    title = "Database Systems",
                    credits = 4,
                    prerequisites = "IT101",
                    description = "Understand relational databases and SQL."
                ),
                Course(
                    code = "IT103",
                    title = "Web Development",
                    credits = 3,
                    prerequisites = "IT101",
                    description = "Build modern web applications using HTML, CSS, and JavaScript."
                ),
                Course(
                    code = "IT201",
                    title = "Data Structures",
                    credits = 4,
                    prerequisites = "IT101",
                    description = "Study fundamental data structures like arrays, lists, and trees."
                ),
                Course(
                    code = "IT202",
                    title = "Operating Systems",
                    credits = 3,
                    prerequisites = "IT101",
                    description = "Explore the concepts of operating systems and their functions."
                ),
                Course(
                    code = "IT203",
                    title = "Networking Fundamentals",
                    credits = 3,
                    prerequisites = "None",
                    description = "Learn the basics of computer networking and protocols."
                ),
                Course(
                    code = "IT301",
                    title = "Software Engineering",
                    credits = 4,
                    prerequisites = "IT201",
                    description = "Understand software development methodologies and practices."
                ),
                Course(
                    code = "IT302",
                    title = "Cybersecurity Basics",
                    credits = 3,
                    prerequisites = "IT203",
                    description = "Introduction to cybersecurity principles and practices."
                ),
                Course(
                    code = "IT303",
                    title = "Mobile App Development",
                    credits = 4,
                    prerequisites = "IT201",
                    description = "Learn to build mobile apps using Android and Kotlin."
                ),
                Course(
                    code = "IT401",
                    title = "Capstone Project",
                    credits = 6,
                    prerequisites = "IT301, IT303",
                    description = "Work on a comprehensive IT project integrating all skills."
                )
            )
            sampleCourses.forEach { course ->
                courseDao.insertCourse(course)
            }
        }
    }
}