package com.android.project.welsenandroidproject_kotlin.ui.rocket_history

import android.os.Parcelable
import com.android.project.domain.entity.history.DiameterEntity
import com.android.project.domain.entity.history.HeightEntity
import com.android.project.domain.entity.history.MassEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketHistoryVo(
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
    val first_flight: String? = null,
    val flickr_images: List<String>? = null
): Parcelable {

    @Parcelize
    data class HeightEntity(
        val meters: Float? = null,
        val feet: Float? = null
    ): Parcelable

    @Parcelize
    data class DiameterEntity(
        val meters: Float? = null,
        val feet: Float? = null
    ): Parcelable

    @Parcelize
    data class MassEntity(
        val kg: Int? = null,
        val lb: Int? = null
    ): Parcelable
}