package com.android.project.data.data_source.history

import com.android.project.data.dto.history.RocketHistoryResp
import io.reactivex.rxjava3.core.Single

interface HistoryDataSource {
    fun getRocketHistory(): Single<List<RocketHistoryResp>>
}