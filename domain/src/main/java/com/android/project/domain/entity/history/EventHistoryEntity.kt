package com.android.project.domain.entity.history

data class EventHistoryEntity(
    val title: String? = null,
    val event_date_utc: String? = null,
    val event_date_unix: Long? = null,
    val details: String? = null,
    val links: Links? = null
)

data class Links(
    val article: String? = null
)