package com.example.tesla.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tesla.data.local.dao.EmployeeDao
import com.example.tesla.data.models.Employees

@Database(
    entities = [Employees::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            // Double-checked locking to prevent multiple instances
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "app_database"
            )
                // Clears and rebuilds the database on version mismatch.
                // In production, consider using proper migration strategies.
                .fallbackToDestructiveMigration().build()
        }
    }
}