package com.android.project.domain.entity.history

data class RocketHistoryEntity(
    val height: Height? = null,
    val diameter: Diameter? = null,
    val mass: mass? = null,
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

data class Height(
    val meters: Float? = null,
    val feet: Float? = null
)

data class Diameter(
    val meters: Float? = null,
    val feet: Float? = null
)

data class mass(
    val kg: Int? = null,
    val lb: Int? = null
)