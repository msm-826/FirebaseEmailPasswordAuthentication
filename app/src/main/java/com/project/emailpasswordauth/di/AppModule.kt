package com.project.emailpasswordauth.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.project.emailpasswordauth.data.repository.AuthRepositoryImpl
import com.project.emailpasswordauth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )
}