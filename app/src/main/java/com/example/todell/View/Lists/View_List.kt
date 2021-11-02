package com.example.todell.View.Lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModel
import com.example.todell.R
import com.example.todell.View.ListViewModel

class View_List : Fragment() {

    private val listViewModel : ListViewModel by activityViewModels()
    private lateinit var selectedItem : TodellModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view__list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView: EditText = view.findViewById(R.id.editListNameEditText)
        val checkEditListButton : ImageButton = view.findViewById(R.id.checkEditListButton)
        val deleteListEditListButton : ImageButton = view.findViewById(R.id.deleteListEditListButton)
        val cancelViewingNewListButton : ImageButton = view.findViewById(R.id.cancelViewingNewListButton)


        listViewModel.selectedListMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {

            }
        })
        checkEditListButton.setOnClickListener {
            val title = nameTextView.text.toString()
            if (title.isNotEmpty()){
                listViewModel.updateList(TodellModel(title))
                findNavController().popBackStack()
            }
        }
        deleteListEditListButton.setOnClickListener {
            listViewModel.deleteList(selectedItem)
        }
        cancelViewingNewListButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}