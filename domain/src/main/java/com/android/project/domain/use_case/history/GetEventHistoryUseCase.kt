package com.android.project.domain.use_case.history

import com.android.project.domain.entity.history.EventHistoryEntity
import com.android.project.domain.repository.history.IHistoryRepository
import com.android.project.domain.use_case.BaseUseCase
import io.reactivex.rxjava3.core.Single

class GetEventHistoryUseCase(
    private val hisRepository: IHistoryRepository
) : BaseUseCase<List<EventHistoryEntity>>() {
    override fun buildUseCase(): Single<List<EventHistoryEntity>> {
        return hisRepository.getEventHistory()
    }
}