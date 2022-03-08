package com.grjt.supermarvel.domain.model

import com.grjt.supermarvel.data.database.entities.SuperheroEntity
import com.grjt.supermarvel.data.model.SuperheroModel

data class Superhero(
    val id: Int = -1,
    val name: String = "",
    val path: String = "",
    val extension: String = ""
)

fun SuperheroModel.toDomain() = Superhero(id, name, thumbnail.path, thumbnail.extension)

fun SuperheroEntity.toDomain() = Superhero(id, name, path, extension)
