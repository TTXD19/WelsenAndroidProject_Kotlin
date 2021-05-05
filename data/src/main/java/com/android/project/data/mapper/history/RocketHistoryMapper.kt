package com.android.project.data.mapper.history

import com.android.project.data.dto.history.Diameter
import com.android.project.data.dto.history.Height
import com.android.project.data.dto.history.RocketHistoryResp
import com.android.project.data.dto.history.mass
import com.android.project.data.mapper.Mapper
import com.android.project.domain.entity.history.DiameterEntity
import com.android.project.domain.entity.history.HeightEntity
import com.android.project.domain.entity.history.MassEntity
import com.android.project.domain.entity.history.RocketHistoryEntity
import javax.inject.Inject

class RocketHistoryMapper @Inject constructor() : Mapper<RocketHistoryEntity, RocketHistoryResp> {
    override fun toDto(entity: RocketHistoryEntity?): RocketHistoryResp {
        if (entity == null) {
            return RocketHistoryResp()
        }
        return RocketHistoryResp(
            height = Height(
                meters = entity.heightEntity?.meters,
                feet = entity.heightEntity?.feet
            ),
            diameter = Diameter(
                meters = entity.diameterEntity?.meters,
                feet = entity.diameterEntity?.feet
            ),
            mass = mass(
                kg = entity.mass?.kg,
                lb = entity.mass?.lb
            ),
            name = entity.name,
            type = entity.type,
            active = entity.active,
            country = entity.country,
            company = entity.company,
            description = entity.description,
            id = entity.id,
            legacy_id = entity.legacy_id,
            first_flight = entity.first_flight,
        )
    }

    override fun toEntity(dto: RocketHistoryResp?): RocketHistoryEntity {
        if (dto == null) {
            return RocketHistoryEntity()
        }
        return RocketHistoryEntity(
            heightEntity = HeightEntity(
                meters = dto.height?.meters,
                feet = dto.height?.feet
            ),
            diameterEntity = DiameterEntity(
                meters = dto.diameter?.meters,
                feet = dto.diameter?.feet
            ),
            mass = MassEntity(
                kg = dto.mass?.kg,
                lb = dto.mass?.lb
            ),
            name = dto.name,
            type = dto.type,
            active = dto.active,
            country = dto.country,
            company = dto.company,
            description = dto.description,
            id = dto.id,
            legacy_id = dto.legacy_id,
            first_flight = dto.first_flight,
        )
    }
}