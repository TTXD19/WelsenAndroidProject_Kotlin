package com.android.project.welsenandroidproject_kotlin.di

import com.android.project.data.repository.history.HistoryRepository
import com.android.project.domain.repository.history.IHistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindHistoryRepository(historyRepository: HistoryRepository): IHistoryRepository
}