package com.android.project.welsenandroidproject_kotlin.di

import com.android.project.domain.repository.history.IHistoryRepository
import com.android.project.domain.use_case.history.GetEventHistoryUseCase
import com.android.project.domain.use_case.history.GetRocketHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRocketHistoryUseCase(
        historyRepository: IHistoryRepository
    ): GetRocketHistoryUseCase {
        return GetRocketHistoryUseCase(historyRepository)
    }

    @Provides
    fun provideEventHistoryUseCase(
        historyRepository: IHistoryRepository
    ): GetEventHistoryUseCase {
        return GetEventHistoryUseCase(historyRepository)
    }
}