package org.d3if0113.jurnal09.detailwithgambar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0113.jurnal09.network.WordList

class DetailWithGambarViewModel : ViewModel() {
    private val _wordList = MutableLiveData<List<WordList>>()
    val wordList: LiveData<List<WordList>>
        get() = _wordList

    fun setMiwokData(wordList: List<WordList>) {
        _wordList.value = wordList
    }
}