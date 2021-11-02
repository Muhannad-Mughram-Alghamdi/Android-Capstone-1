package com.example.todell.View.Lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todell.Database.Models.TodellModel
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.R
import com.example.todell.View.ListViewModel
import com.example.todell.View.Tasks.TasksAdapter

/***
 * A Fragment represents a reusable portion of your app's UI.
 * A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.
 * Fragments cannot live on their own--they must be hosted by an activity or another fragment.
 * The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
 * */
class Task_List : Fragment() {
    private val tasksTitleList = mutableListOf<TodellModelTask>()
    // To get instance from view model you need to use bu activityViewModels to provide you with the object from the InventoryViewModel
    private val taskViewModel : ListViewModel by activityViewModels() //??????????????????
//=====================================================================================================================================
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task__list, container, false)
    }
//=====================================================================================================================================
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskRecyclerView : RecyclerView = view.findViewById(R.id.taskRecyclerView)
        val addNewTaskButton : ImageButton = view.findViewById(R.id.AddNewTaskButton)
        val listNameTextView : TextView = view.findViewById(R.id.ListNameTextView)
        val listPageEditButton : ImageButton = view.findViewById(R.id.ListPageEditButton)


    val taskAdapter = TasksAdapter(tasksTitleList,taskViewModel)
    taskRecyclerView.adapter = taskAdapter
//=====================================================================================================================================
    taskViewModel.todellTask(taskViewModel.selectedItem).observe(viewLifecycleOwner , Observer{
        it?.let {
            tasksTitleList.clear()
            tasksTitleList.addAll(it)
            taskAdapter.notifyDataSetChanged()
            //listNameTextView.text = TodellModel
        }
    })

    addNewTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_task_List_to_new_Task)
        }
//--------------------------------------------------------------------------------------------------

    listPageEditButton.setOnClickListener {
            findNavController().navigate(R.id.action_task_List_to_view_List)
        }
//--------------------------------------------------------------------------------------------------
    listNameTextView.setText("To Do List")
    }
}