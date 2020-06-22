package com.example.userinfo.di

import android.app.Application
import androidx.room.Room
import com.example.userinfo.room.UserDataBase
import com.example.userinfo.room.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideUserDatabase(application: Application): UserDataBase {
        return Room
            .databaseBuilder(application, UserDataBase::class.java, "user.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: UserDataBase): UserDao {
        return appDatabase.userDao
    }

}
