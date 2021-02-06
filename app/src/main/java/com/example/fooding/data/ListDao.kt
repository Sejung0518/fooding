package com.example.fooding.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface ListDao {
    @Query("SELECT * FROM DataTable")
    fun getAll(): List<ListData>

    /* import android.arch.persistence.room.OnConflictStrategy.REPLACE */
    @Insert(onConflict = REPLACE)
    fun insert(listdata: ListData)

    @Query("DELETE from DataTable")
    fun deleteAll()
}