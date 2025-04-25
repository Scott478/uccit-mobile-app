package com.trevor_nelson.uccitmobileapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): Flow<List<Course>>

    @Insert
    suspend fun insertCourse(course: Course)

    @Query("DELETE FROM courses")
    suspend fun deleteAllCourses()
}