package com.android.project.data.data_source.history

import com.android.project.data.dto.history.EventHistoryResp
import com.android.project.data.dto.history.RocketHistoryResp
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface HistoryApi {

    @GET(ROCKET_END_POINT)
    fun fetchEventHistory(): Single<List<RocketHistoryResp>>

    companion object{
        private const val ROCKET_END_POINT = "v4/rockets"
    }
}