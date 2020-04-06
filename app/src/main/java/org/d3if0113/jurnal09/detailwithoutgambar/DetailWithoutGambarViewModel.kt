package org.d3if0113.jurnal09.detailwithoutgambar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0113.jurnal09.network.MiwokV2

class DetailWithoutGambarViewModel : ViewModel() {
    private val _miwokV2 = MutableLiveData<List<MiwokV2>>()
    val miwokV2: LiveData<List<MiwokV2>>
        get() = _miwokV2

    fun setMiwokData(miwokV2: List<MiwokV2>) {
        _miwokV2.value = miwokV2
        Log.i("model", "${miwokV2.get(0).defaultWord}")
    }
}