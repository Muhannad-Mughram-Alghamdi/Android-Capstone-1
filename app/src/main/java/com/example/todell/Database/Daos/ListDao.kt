package com.example.todell.Database.Daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModel
import com.example.todell.Database.Models.TodellModelTask
//==============================================================================================================
/**
 * The following code defines a DAO called InventoryDao.
 * InventoryDao provides the methods that the rest of the app uses to interact with data in the ItemModel table.
 * */
@Dao
interface ListDao {
    // The @Insert annotation allows you to define methods that insert their parameters into the appropriate table in the database
    @Insert
    suspend fun addList(todellModel: TodellModel)
    @Insert
    suspend fun addTask(todellModelTask: TodellModelTask)
//=============================================================================================================
    @Transaction //??
//=============================================================================================================
    /***
     * The @Query annotation allows you to write SQL statements and expose them as DAO methods.
     * Use these query methods to query data from your app's database,
     * or when you need to perform more complex inserts, updates, and deletes.
     *
     * Room validates SQL queries at compile time. This means that if there's a problem with your query,
     * a compilation error occurs instead of a runtime failure.
     * */
    @Query("SELECT * FROM todellmodel")
    fun getList() : LiveData<List<MainTaskWithSubTask>>

    @Query("SELECT * FROM todellmodeltask WHERE mainTaskId = :taskId")
    fun getTask(taskId:Int):LiveData<List<TodellModelTask>>
//=============================================================================================================
    // The @Update annotation allows you to define methods that update specific rows in a database table.
    // Similarly to @Insert methods, @Update methods accept data entity instances as parameters.
    @Update
    suspend fun updateList(todellModel: TodellModel)
    @Update
    suspend fun updateTask(todellModeTask: TodellModelTask)

//=============================================================================================================
    // The @Delete annotation allows you to define methods that delete specific rows from a database table.
    // Similarly to @Insert methods, @Delete methods accept data entity instances as parameters.
    @Delete
    suspend fun deleteList(todellModel: TodellModel)
    @Delete
    suspend fun deleteTask(todellModelTask: TodellModelTask)
//=============================================================================================================
}