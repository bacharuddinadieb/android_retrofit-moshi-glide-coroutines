package org.d3if0113.jurnal09.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0113.jurnal09.network.MiwokAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getMiwokData()
    }

    private fun getMiwokData() {
        _response.value = "Set the API Response here!"
        MiwokAPI.retrofitService.getProperties().enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    _response.value = "Gagal: ${t?.message}"
                }

                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    _response.value = response?.body()
                }

            })
    }
}