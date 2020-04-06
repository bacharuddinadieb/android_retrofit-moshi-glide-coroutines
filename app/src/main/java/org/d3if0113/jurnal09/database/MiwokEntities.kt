package org.d3if0113.jurnal09.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.d3if0113.jurnal09.network.MiwokV2

@Entity
data class DatabaseMiwok constructor(
    @PrimaryKey
    val defaultWord: String,
    val category: String,
    val background: String,
    val miwokWord: String,
    val image: String = "kosong",
    val imageURL: String = "http://dif.indraazimi.com/miwok/${image}"
)

fun List<DatabaseMiwok>.asDomainModel(): List<MiwokV2> {
    return map {
        MiwokV2(
            defaultWord = it.defaultWord,
            category = it.category,
            background = it.background,
            miwokWord = it.miwokWord,
            image = it.image,
            imageURL = it.imageURL
        )
    }
}