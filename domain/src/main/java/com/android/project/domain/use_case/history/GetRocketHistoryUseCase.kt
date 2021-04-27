package com.android.project.domain.use_case.history

import com.android.project.domain.entity.history.RocketHistoryEntity
import com.android.project.domain.repository.history.IHistoryRepository
import com.android.project.domain.use_case.BaseUseCase
import io.reactivex.rxjava3.core.Single

class GetRocketHistoryUseCase(
    private val historyRepository: IHistoryRepository
) : BaseUseCase<List<RocketHistoryEntity>>() {

    override fun buildUseCase(): Single<List<RocketHistoryEntity>> {
        return historyRepository.getRocketHistory()
    }
}