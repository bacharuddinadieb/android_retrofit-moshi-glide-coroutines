package org.d3if0113.jurnal09.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.d3if0113.jurnal09.network.MiwokAPI
import org.d3if0113.jurnal09.network.MiwokProperty
import org.d3if0113.jurnal09.network.MiwokV2
import java.util.concurrent.TimeUnit

class HomeViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    private val _propertyMiwokList = MutableLiveData<List<MiwokProperty>>()
    private val _navigateToDetail = MutableLiveData<MiwokProperty>()
    private val _miwokV2List = MutableLiveData<List<MiwokV2>>()
    val response: LiveData<String>
        get() = _response
    val propertyMiwok: LiveData<List<MiwokProperty>>
        get() = _propertyMiwokList
    val navigateToDetail: LiveData<MiwokProperty> get() = _navigateToDetail
    val miwokV2: LiveData<List<MiwokV2>>
        get() = _miwokV2List

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
            var getPropertiesDeferredV2 = MiwokAPI.retrofitService.getPropertiesV2()
            try {
                var listResult = getPropertiesDeferred.await()
                var listResultV2 = getPropertiesDeferredV2.await()
                if (listResult.size > 0) {
                    _propertyMiwokList.value = listResult
                }
                if (listResultV2.isNotEmpty()) {
                    _miwokV2List.value = listResultV2
                }
                delay(TimeUnit.SECONDS.toMillis(2))
                _response.value = "loaded"
            } catch (e: Exception) {
                _response.value = "Gagal: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onItemHomeDitekan(miwokProperty: MiwokProperty) {
        _navigateToDetail.value = miwokProperty
    }

    fun onItemHomeSudahDitekan() {
        _navigateToDetail.value = null
    }
}