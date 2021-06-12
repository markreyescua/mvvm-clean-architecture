package com.mcua.architecture.core.di.module

import android.app.Application
import androidx.room.Room
import com.mcua.architecture.core.data.db.DatabaseService
import com.mcua.architecture.core.data.db.UserDao
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    companion object {
        private const val DATABASE_NAME = "app-database.db"
    }

    @Provides
    fun providesDatabaseService(app: Application): DatabaseService {
        return return Room.databaseBuilder(app, DatabaseService::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesUserDao(databaseService: DatabaseService): UserDao {
        return databaseService.userDao()
    }

}