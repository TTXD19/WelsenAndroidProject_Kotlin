package com.android.project.data.data_source.history

import com.android.project.data.dto.history.EventHistoryResp
import com.android.project.data.dto.history.RocketHistoryResp
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface HistoryApi {

    @GET(ROCKET_END_POINT)
    fun fetchRocketHistory(): Single<List<RocketHistoryResp>>

    @GET(EVENT_END_POINT)
    fun fetchEventHistory(): Single<List<EventHistoryResp>>


    companion object{
        private const val ROCKET_END_POINT = "v4/rockets"
        private const val EVENT_END_POINT = "v4/history"
    }
}