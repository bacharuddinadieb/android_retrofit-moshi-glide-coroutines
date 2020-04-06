package org.d3if0113.jurnal09.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://dif.indraazimi.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MiwokAPIService {
    @GET("miwok.json")
    fun getProperties():
            Deferred<List<MiwokProperty>>

    @GET("miwok-v2.php")
    fun getPropertiesV2():
            Deferred<List<MiwokV2>>

    @GET("miwok-v2.php")
    fun getPropertiesV2Network():
            Deferred<NetworkMiwokContainer>
}

object MiwokAPI {
    val retrofitService: MiwokAPIService by lazy {
        retrofit.create(MiwokAPIService::class.java)
    }
}