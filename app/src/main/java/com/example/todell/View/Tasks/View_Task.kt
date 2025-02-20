package com.example.todell.View.Tasks

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todell.Database.Models.TodellModel
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.R
import com.example.todell.View.ListViewModel

class View_Task : Fragment() {
    private val listViewModel : ListViewModel by activityViewModels()
    private lateinit var selectedItem : TodellModelTask
    private lateinit var dueDatePickerDialog: DatePickerDialog
//==================================================================================================
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view__task, container, false)
    }
//==================================================================================================
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainId : Int = listViewModel.selectedItem

        val cancelEditTaskButton : ImageButton = view.findViewById(R.id.cancelEditTaskButton)
        val editTaskNameEditText : EditText = view.findViewById(R.id.editTaskNameEditText)
        val editNoteEditText : EditText = view.findViewById(R.id.editNoteEditText)
        val deleteEditTaskButton : ImageButton = view.findViewById(R.id.deleteEditTaskButton)
        val checkEditTaskButton : ImageButton = view.findViewById(R.id.checkEditTaskButton)

        listViewModel.selectedSubTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                selectedItem = it
            }
        })
        cancelEditTaskButton.setOnClickListener {
            findNavController().popBackStack()
        }
        deleteEditTaskButton.setOnClickListener {
            listViewModel.deleteTask(selectedItem)
            findNavController().popBackStack()
        }
        checkEditTaskButton.setOnClickListener {
            val taskName = editTaskNameEditText.text.toString()
            val noteEdit = editNoteEditText.text.toString()
            val date = "${dueDatePickerDialog.datePicker.year}/${dueDatePickerDialog.datePicker.month+1}/${dueDatePickerDialog.datePicker.dayOfMonth}"
            listViewModel.updateTask(TodellModelTask(taskName,noteEdit,date,mainId))
            findNavController().popBackStack()
        }
    }

}