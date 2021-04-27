package com.android.project.data.data_source.history

import retrofit2.http.GET

interface HistoryApi {

    @GET
    fun fetchEventHistory()
}