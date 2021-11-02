package com.example.todell.Repositories

import android.content.Context
import androidx.room.Room
import com.example.todell.Database.Models.TodellModel
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.Database.databases.ListDatabase
import java.lang.Exception
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * A Repository is a class that abstracts access to multiple data sources (Room db, Network).
 * It is a suggested best practice for code separation and architecture. A Repository class handles data operations
 * */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private const val DATABASE_NAME = "list's titles list database"
class ListsRepositories(context: Context) {

    /**
     * After you have defined the data entity,
     * the DAO, and the database object,
     * you can use the following code to create an instance of the database:
     * */
    private val database : ListDatabase =
        Room.databaseBuilder(
            context,
            ListDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    /**
     * You can then use the abstract methods from the ListDatabase to get an instance of the DAO.
     VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV* */
    private val listDao = database.listDao()
    // In turn, you can use the methods from the DAO instance to interact with the database:
    fun getList() = listDao.getList()
    fun getTask(taskID :Int) = listDao.getTask(taskID)
////////////////////////////////////////List////////////////////////////////////////////////////////
    suspend fun addList(todellModel: TodellModel) = listDao.addList(todellModel)
    suspend fun updateList(todellModel: TodellModel) = listDao.updateList(todellModel)
    suspend fun deleteList(todellModel: TodellModel) = listDao.deleteList(todellModel)
///////////////////////////////////////Task/////////////////////////////////////////////////////////
    suspend fun addTask(todellModelTask: TodellModelTask) = listDao.addTask(todellModelTask)
    suspend fun updateTask(todellModelTask: TodellModelTask) = listDao.updateTask(todellModelTask)
    suspend fun deleteTask(todellModelTask: TodellModelTask) = listDao.deleteTask(todellModelTask)
////////////////////////////////////////////////////////////////////////////////////////////////////
    /***
     * this companion object for restricts the instantiation of a class to one "single" instance.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     * */
    companion object{
        private var instance : ListsRepositories? = null

        fun init(context: Context){
            if(instance == null)
                instance = ListsRepositories(context)
        }
        fun get(): ListsRepositories{
            return instance ?: throw Exception("List Repository must be initialized")
        }
    }
}