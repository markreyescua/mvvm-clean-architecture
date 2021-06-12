package com.mcua.architecture.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mcua.architecture.core.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseService : RoomDatabase() {

    abstract fun userDao(): UserDao

}