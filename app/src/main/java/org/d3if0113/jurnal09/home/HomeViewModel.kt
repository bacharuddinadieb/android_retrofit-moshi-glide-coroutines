package org.d3if0113.jurnal09.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if0113.jurnal09.network.MiwokAPI
import org.d3if0113.jurnal09.network.MiwokProperty

class HomeViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    private val _propertyMiwokList = MutableLiveData<List<MiwokProperty>>()
    val response: LiveData<String>
        get() = _response
    val propertyMiwok: LiveData<List<MiwokProperty>>
        get() = _propertyMiwokList

    //coroutine
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getMiwokData()
    }

    private fun getMiwokData() {
        _response.value = "Response API Uy!"
        coroutineScope.launch {
            var getPropertiesDeferred = MiwokAPI.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                _response.value = "${listResult.size} data"
                if (listResult.size > 0) {
                    _propertyMiwokList.value = listResult
                }
            } catch (e: Exception) {
                _response.value = "Gagal: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}