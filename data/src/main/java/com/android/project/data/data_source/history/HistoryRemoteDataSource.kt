package com.android.project.data.data_source.history

import com.android.project.data.dto.history.EventHistoryResp
import com.android.project.data.dto.history.RocketHistoryResp
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HistoryRemoteDataSource @Inject constructor(
    private val historyApi: HistoryApi
) : HistoryDataSource {
    override fun getRocketHistory(): Single<List<RocketHistoryResp>> {
        return historyApi.fetchRocketHistory().subscribeOn(Schedulers.io())
    }

    override fun getEventHistory(): Single<List<EventHistoryResp>> {
        return historyApi.fetchEventHistory().subscribeOn(Schedulers.io())
    }

}