package com.grjt.supermarvel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grjt.supermarvel.domain.model.Superhero

@Entity(tableName = "superhero_table")
data class SuperheroEntity(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "path")
    val path: String = "",
    @ColumnInfo(name = "extension")
    val extension: String = ""
)

fun Superhero.toDomain() = SuperheroEntity(name = name, path = path, extension = extension)
