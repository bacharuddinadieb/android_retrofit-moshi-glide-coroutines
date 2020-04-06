package org.d3if0113.jurnal09.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MiwokV2(
    val category: String,
    val background: String,
    val defaultWord: String,
    val miwokWord: String,
    val image: String = "kosong",
    val imageURL: String = "http://dif.indraazimi.com/miwok/${image}"
) : Parcelable