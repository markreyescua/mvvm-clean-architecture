package com.mcua.architecture.framework.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mcua.architecture.framework.model.user.UserEntity
import com.mcua.architecture.util.JavaConverter

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(JavaConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "app-database.db"

        private var instance: AppDatabase? = null

        private fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): AppDatabase =
            (instance ?: create(context)).also { instance = it }

    }

}