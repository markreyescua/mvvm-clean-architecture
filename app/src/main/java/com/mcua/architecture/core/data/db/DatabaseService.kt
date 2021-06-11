package com.mcua.architecture.core.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mcua.architecture.core.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseService : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "app-database.db"

        @Volatile
        private var INSTANCE: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): DatabaseService {
            synchronized(this) {
                var instance: DatabaseService? = INSTANCE
                if (instance == null) {
                    instance = create(context)
                }
                return instance
            }
        }
    }

}