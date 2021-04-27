package com.android.project.data.mapper

interface Mapper<E, D> {
    fun toDto(entity: E?): D
    fun toEntity(dto: D?): E
}