package com.mcua.architecture.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mcua.architecture.framework.model.User
import com.mcua.architecture.framework.api.JavaConverter

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(JavaConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "app-database.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        private fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = create(context)
                }
                return instance
            }
        }
    }

}