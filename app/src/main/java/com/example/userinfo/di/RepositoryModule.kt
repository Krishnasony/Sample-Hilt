package com.example.userinfo.di

import com.example.userinfo.repo.UserRepository
import com.example.userinfo.room.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

  @Provides
  @ActivityRetainedScoped
  fun provideUserRepository(
    userDao: UserDao
  ): UserRepository {
    return UserRepository(userDao)
  }

}
