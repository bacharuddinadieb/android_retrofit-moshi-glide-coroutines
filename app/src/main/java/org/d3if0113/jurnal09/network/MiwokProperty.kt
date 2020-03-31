package org.d3if0113.jurnal09.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MiwokProperty(
    val category: String,
    val background: String,
    val wordList: List<WordList>
) : Parcelable