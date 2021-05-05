package com.android.project.data.mapper.history

import com.android.project.data.dto.history.EventHistoryResp
import com.android.project.data.mapper.Mapper
import com.android.project.domain.entity.history.EventHistoryEntity
import com.android.project.data.dto.history.Links
import javax.inject.Inject

class EventHistoryMapper @Inject constructor() : Mapper<EventHistoryEntity, EventHistoryResp> {
    override fun toDto(entity: EventHistoryEntity?): EventHistoryResp {
        if (entity == null) {
            return EventHistoryResp()
        }
        return EventHistoryResp(
            title = entity.title,
            event_date_utc = entity.event_date_utc,
            event_date_unix = entity.event_date_unix,
            details = entity.details,
            links = Links(
                entity.links?.article
            )
        )
    }

    override fun toEntity(dto: EventHistoryResp?): EventHistoryEntity {
        if (dto == null) {
            return EventHistoryEntity()
        }
        return EventHistoryEntity(
            title = dto.title,
            event_date_utc = dto.event_date_utc,
            event_date_unix = dto.event_date_unix,
            details = dto.details,
            links = com.android.project.domain.entity.history.Links(
                dto.links?.article
            )
        )
    }
}