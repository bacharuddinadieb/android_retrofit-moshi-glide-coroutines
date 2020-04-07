package org.d3if0113.jurnal09.repository

//import org.d3if0113.jurnal09.network.MiwokAPIV2
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.d3if0113.jurnal09.database.MiwokDatabase
import org.d3if0113.jurnal09.database.asDatabaseModel
import org.d3if0113.jurnal09.database.asDomainModel
import org.d3if0113.jurnal09.network.MiwokAPI
import org.d3if0113.jurnal09.network.MiwokV2

class MiwokRepository(private val database: MiwokDatabase) {

    val miwok: LiveData<List<MiwokV2>> = Transformations.map(database.miwokDao.getMiwok()) {
        it.asDomainModel()
    }

    suspend fun refreshMiwok() {
        withContext(Dispatchers.IO) {
            val dataMiwok = MiwokAPI.retrofitService.getPropertiesV2Network().await()
            try {
                database.miwokDao.insertAll(dataMiwok.asDatabaseModel())
            } catch (e: Exception) {
                Log.i("Error Insert", e.message)
            }
        }
    }
}