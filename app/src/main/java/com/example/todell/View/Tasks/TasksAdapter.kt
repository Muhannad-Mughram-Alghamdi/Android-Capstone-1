package com.example.todell.View.Tasks

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.R
import com.example.todell.View.ListViewModel


class TasksAdapter
    (val Tasks: List<TodellModelTask>, val taskModel: ListViewModel):
    RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_task,
                parent,
                false
            )
        )
    }
//==================================================================================================
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
    val task = Tasks[position]
    holder.taskTextView.text = task.taskTitle
    holder.itemView.setOnClickListener { view ->
        taskModel.selectedSubTaskMutableLiveData.postValue(task)
        view.findNavController().navigate(R.id.action_task_List_to_view_Task)
    }
    holder.done.setOnClickListener { }
            if (holder.done.isChecked) {
                holder.taskTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
            } else {
                holder.taskTextView.setPaintFlags(0)
        }
    }

//==================================================================================================
    override fun getItemCount(): Int {
        return Tasks.size
    }
//==================================================================================================
    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val taskTextView: TextView = view.findViewById(R.id.BubbleTaskTitleTextView1)
        val done : CheckBox = view.findViewById(R.id.doneCheckBox)
    }
}