package com.example.todell.View.Tasks

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModelTask
import com.example.todell.R
import com.example.todell.View.ListViewModel


class New_Task : Fragment() {

    private val taskViewModel: ListViewModel by activityViewModels()
    //private val taskList = mutableListOf<MainTaskWithSubTask>()
    private lateinit var dueDatePickerDialog: DatePickerDialog

//==================================================================================================
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new__task, container, false)
    }
//==================================================================================================
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarButton: ImageButton = view.findViewById(R.id.newCalendarButton)
        val calnderinstance = Calendar.getInstance()
        val creationDate = Calendar.getInstance().timeInMillis
        val mainId : Int = taskViewModel.selectedItem

        val checkNewTaskButton: ImageButton = view.findViewById(R.id.checkNewTaskButton)
        val cancelCreatNewTaskButton: ImageButton = view.findViewById(R.id.cancelCreatNewTaskButton)
        val newTaskNameEditText: EditText = view.findViewById(R.id.newTaskNameEditText)
        val newTaskNoteEditText: EditText = view.findViewById(R.id.newTaskNoteEditText)
        var due: Long? = null
//===================================================================================================
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, _, _, _ ->
                calnderinstance.set(Calendar.YEAR, 0)
                calnderinstance.set(Calendar.MONTH, 0)
                calnderinstance.set(Calendar.DAY_OF_MONTH, 0)
                due = calnderinstance.timeInMillis
            }

    dueDatePickerDialog =  DatePickerDialog(
        requireActivity(),
        dateSetListener,
        calnderinstance.get(Calendar.YEAR),
        calnderinstance.get(Calendar.MONTH),
        calnderinstance.get(Calendar.DAY_OF_MONTH)
    )
        calendarButton.setOnClickListener {
           dueDatePickerDialog.show()
        }
//--------------------------------------------------------------------------------------------------
        cancelCreatNewTaskButton.setOnClickListener {
            findNavController().popBackStack()
        }
//--------------------------------------------------------------------------------------------------
        checkNewTaskButton.setOnClickListener {
            val title = newTaskNameEditText.text.toString()
            val note = newTaskNoteEditText.text.toString()
            val date = "${dueDatePickerDialog.datePicker.year}/${dueDatePickerDialog.datePicker.month+1}/${dueDatePickerDialog.datePicker.dayOfMonth}"
            if (title.isNotEmpty()) {
                taskViewModel.addTask(TodellModelTask(title,note,date,mainId))
                findNavController().popBackStack()
            }
        }
//--------------------------------------------------------------------------------------------------
    }
}