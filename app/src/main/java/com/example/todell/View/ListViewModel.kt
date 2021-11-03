package com.example.todell.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModel
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.Repositories.ListsRepositories
import kotlinx.coroutines.launch
import java.util.*

class ListViewModel : ViewModel() {

   private val listsRepository = ListsRepositories.get()
    var ListsTitleList = listsRepository.getList()

    fun todellTask (taskId:Int) = listsRepository.getTask(taskId)
    var selectedItem = 0

    var selectedListMutableLiveData = MutableLiveData<MainTaskWithSubTask>()
    var selectedSubTaskMutableLiveData = MutableLiveData<TodellModelTask>()

    var selectedTaskMutableLiveData = MutableLiveData<List<TodellModelTask>>()


///////////////////////////////////////////List/////////////////////////////////////////////////////
    fun addList(todellModel: TodellModel){
        viewModelScope.launch {
            listsRepository.addList(todellModel)
        }
    }
    fun updateList(todellModel: TodellModel) {
        viewModelScope.launch {
            listsRepository.updateList(todellModel)
        }
    }
    fun deleteList(todellModel: TodellModel){
        viewModelScope.launch {
            listsRepository.deleteList(todellModel)
        }
    }
///////////////////////////////////////////Task/////////////////////////////////////////////////////
    fun addTask(todellModelTask:TodellModelTask){

        viewModelScope.launch {
            listsRepository.addTask(todellModelTask)
        }
    }
    fun updateTask(todellModelTask: TodellModelTask) {
        viewModelScope.launch {
            listsRepository.updateTask(todellModelTask)
        }
    }
    fun deleteTask(todellModelTask: TodellModelTask){
        viewModelScope.launch {
            listsRepository.deleteTask(todellModelTask)
        }
    }

}
