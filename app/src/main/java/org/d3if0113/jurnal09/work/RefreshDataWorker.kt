package org.d3if0113.jurnal09.work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.d3if0113.jurnal09.database.getDatabase
import org.d3if0113.jurnal09.repository.MiwokRepository
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val repository = MiwokRepository(database)

        try {
            repository.refreshMiwok()
            Log.i("Refresh MIWOK", "MIWOK di refresh!")
        } catch (e: HttpException) {
            return Result.retry()
        }
        return Result.success()
    }

}