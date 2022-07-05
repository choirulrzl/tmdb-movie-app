package com.fahlepyrizal01.core.data.source.local.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fahlepyrizal01.core.data.source.local.entity.DataSampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {

    //region GET
    @Query("SELECT * FROM sample")
    fun getAllData(): Flow<List<DataSampleEntity>>

    @Query("SELECT * FROM sample where id = :id")
    fun getOneData(id: String): Flow<DataSampleEntity>
    //endregion

    //region INSERT
    @Insert(onConflict = REPLACE)
    suspend fun insertAllData(data: List<DataSampleEntity>): Boolean

    @Insert(onConflict = REPLACE)
    suspend fun insertOneData(data: DataSampleEntity): Boolean
    //endregion

    //region UPDATE
    @Update
    fun updateData(data: DataSampleEntity): Boolean
    //endregion

    //region DELETE
    @Delete
    fun deleteData(id: String): Boolean
    //endregion

}