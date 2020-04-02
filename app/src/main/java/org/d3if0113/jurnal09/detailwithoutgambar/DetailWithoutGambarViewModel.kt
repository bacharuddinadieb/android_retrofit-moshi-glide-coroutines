package org.d3if0113.jurnal09.detailwithoutgambar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0113.jurnal09.network.WordList

class DetailWithoutGambarViewModel : ViewModel() {
    private val _wordList = MutableLiveData<List<WordList>>()
    val wordList: LiveData<List<WordList>>
        get() = _wordList

//    init {
//        asd()
//    }
//
//    private fun asd(){
//        var aha = mutableListOf<WordList>()
//        aha.add(WordList("kosong", "kosong", "kosong"))
//        _wordList.value = aha
//    }

    fun setMiwokData(wordList: List<WordList>) {
        _wordList.value = wordList
        Log.i("model", "${wordList.get(0).defaultWord}")
    }
}