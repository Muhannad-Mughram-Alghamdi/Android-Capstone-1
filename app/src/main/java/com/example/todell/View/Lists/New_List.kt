package com.example.todell.View.Lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.todell.Database.Models.TodellModel
import com.example.todell.R
import com.example.todell.View.ListViewModel
import android.graphics.Color
import android.widget.RelativeLayout

class New_List : Fragment() {

    private val listViewModel: ListViewModel by activityViewModels()
    internal lateinit var layout: RelativeLayout
//==================================================================================================
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new__list, container, false)
    }
//==================================================================================================
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTitel : EditText = view.findViewById(R.id.addNewListNameEditText)
        val confirmButton : ImageButton = view.findViewById(R.id.checkNewListButton)
        val cancelButton : ImageButton = view.findViewById(R.id.cancelCreatingNewListButton)
//==================================================================================================
        confirmButton.setOnClickListener {
            val title = listTitel.text.toString()
            if (title.isNotEmpty()){
                listViewModel.addList(TodellModel(title))
                findNavController().popBackStack()
            }
        }
//--------------------------------------------------------------------------------------------------
        cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }
//==================================================================================================
    }
}