package com.android.project.domain.entity.history

data class RocketHistoryEntity(
    val heightEntity: HeightEntity? = null,
    val diameterEntity: DiameterEntity? = null,
    val mass: MassEntity? = null,
    val name: String? = null,
    val type: String? = null,
    val active: Boolean? = true,
    val country: String? = null,
    val company: String? = null,
    val description: String? = null,
    val id: String? = null,
    val legacy_id: String? = null,
    val first_flight: String? = null
)

data class HeightEntity(
    val meters: Float? = null,
    val feet: Float? = null
)

data class DiameterEntity(
    val meters: Float? = null,
    val feet: Float? = null
)

data class MassEntity(
    val kg: Int? = null,
    val lb: Int? = null
)