package com.grjt.supermarvel.data.model

import com.google.gson.annotations.SerializedName

data class Superhero(
    val id: Int = -1,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("resourceURI")
    val resourceURI: String = "",
    @SerializedName("comics")
    val comics: Type,
    @SerializedName("series")
    val series: Type,
    @SerializedName("stories")
    val stories: Type,
    @SerializedName("events")
    val events: Type,
    @SerializedName("urls")
    val urls: List<URL> = listOf()
)

data class Thumbnail(
    val path: String = "",
    val extension: String = "",
)

data class Type(
    val available: Int = -1,
    val collectionURI: String = "",
    val items: List<Item> = listOf(),
    val returned: Int = -1
)

data class Item(
    val resourceURI: String = "",
    val name: String = ""
)

data class URL(
    val type: String = "",
    val url: String = ""
)

data class DataSuperhero(
    val code: String,
    val data: DataResult
)

data class DataResult(
    val results: List<Superhero> = listOf()
)