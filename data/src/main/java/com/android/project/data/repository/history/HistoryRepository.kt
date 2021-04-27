package com.android.project.data.repository.history

import com.android.project.data.data_source.history.HistoryRemoteDataSource
import com.android.project.data.mapper.history.HistoryMapper
import com.android.project.domain.entity.history.RocketHistoryEntity
import com.android.project.domain.repository.history.IHistoryRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val historyMapper: HistoryMapper,
    private val historyRemoteDataSource: HistoryRemoteDataSource
) : IHistoryRepository {
    override fun getRocketHistory(): Single<List<RocketHistoryEntity>> {
        return historyRemoteDataSource.getRocketHistory().map {
            it.map { data ->
                historyMapper.toEntity(data)
            }
        }
    }
}