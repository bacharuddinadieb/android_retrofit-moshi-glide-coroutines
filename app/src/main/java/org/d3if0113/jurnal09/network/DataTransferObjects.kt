package org.d3if0113.jurnal09.network

import com.squareup.moshi.JsonClass
import org.d3if0113.jurnal09.database.DatabaseMiwok

@JsonClass(generateAdapter = true)
data class NetworkMiwokContainer(val miwok: List<NetworkMiwok>)

@JsonClass(generateAdapter = true)
data class NetworkMiwok(
    val defaultWord: String,
    val category: String,
    val background: String,
    val miwokWord: String,
    val image: String = "kosong",
    val imageURL: String = "http://dif.indraazimi.com/miwok/${image}"
)

fun NetworkMiwokContainer.asDomainModel(): List<MiwokV2> {
    return miwok.map {
        MiwokV2(
            category = it.category,
            background = it.background,
            miwokWord = it.miwokWord,
            defaultWord = it.defaultWord,
            image = it.image,
            imageURL = it.imageURL
        )
    }
}

fun NetworkMiwokContainer.asDatabaseModel(): List<DatabaseMiwok> {
    return miwok.map {
        DatabaseMiwok(
            category = it.category,
            background = it.background,
            miwokWord = it.miwokWord,
            defaultWord = it.defaultWord,
            image = it.image,
            imageURL = it.imageURL
        )
    }
}