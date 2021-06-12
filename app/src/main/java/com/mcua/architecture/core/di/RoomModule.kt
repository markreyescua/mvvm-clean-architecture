package com.mcua.architecture.core.di

import android.app.Application
import androidx.room.Room
import com.mcua.architecture.core.data.db.DatabaseService
import com.mcua.architecture.core.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    companion object {
        private const val DATABASE_NAME = "app-database.db"
    }

    @Provides
    @Singleton
    fun providesDatabaseService(app: Application): DatabaseService {
        return Room.databaseBuilder(app, DatabaseService::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUserDao(databaseService: DatabaseService): UserDao {
        return databaseService.userDao()
    }

}