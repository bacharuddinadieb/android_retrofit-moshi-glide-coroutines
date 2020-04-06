package org.d3if0113.jurnal09.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MiwokDao {
    @Query("select * from databasemiwok")
    fun getMiwok(): LiveData<List<DatabaseMiwok>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(miwok: List<DatabaseMiwok>)
}

@Database(entities = [DatabaseMiwok::class], version = 1)
abstract class MiwokDatabase : RoomDatabase() {
    abstract val miwokDao: MiwokDao
}

private lateinit var INSTANCE: MiwokDatabase

fun getDatabase(context: Context): MiwokDatabase {
    synchronized(MiwokDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MiwokDatabase::class.java,
                "miwok"
            ).build()
        }
    }
    return INSTANCE
}