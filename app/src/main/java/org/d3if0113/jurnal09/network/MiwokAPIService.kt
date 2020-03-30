package org.d3if0113.jurnal09.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://dif.indraazimi.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MiwokAPIService {
    @GET("miwok.json")
    fun getProperties():
            Call<String>
}

object MiwokAPI {
    val retrofitService: MiwokAPIService by lazy {
        retrofit.create(MiwokAPIService::class.java)
    }
}