package com.android.project.domain.repository.history

import com.android.project.domain.entity.history.RocketHistoryEntity
import io.reactivex.rxjava3.core.Single

interface IHistoryRepository {
    fun getRocketHistory(): Single<List<RocketHistoryEntity>>
}