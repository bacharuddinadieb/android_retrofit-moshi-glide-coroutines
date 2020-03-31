package org.d3if0113.jurnal09.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WordList(
    val defaultWord: String,
    val miwokWord: String,
    val image: String = "kosong"
) : Parcelable