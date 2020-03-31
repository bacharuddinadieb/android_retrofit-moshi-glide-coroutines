package org.d3if0113.jurnal09.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://dif.indraazimi.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MiwokAPIService {
    @GET("miwok.json")
    fun getProperties():
            Call<List<MiwokProperty>>
}

object MiwokAPI {
    val retrofitService: MiwokAPIService by lazy {
        retrofit.create(MiwokAPIService::class.java)
    }
}