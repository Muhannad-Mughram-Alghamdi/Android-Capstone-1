package com.example.todell.View.Lists

import android.content.res.ColorStateList
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
import android.widget.TextView

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

        val color : TextView = view.findViewById(R.id.pickColorTextViewNew)

        val cp01 : ImageButton = view.findViewById(R.id.light_Blue)
        val cp02 : ImageButton = view.findViewById(R.id.orange)
        val cp03 : ImageButton = view.findViewById(R.id.pinky)
        val cp04 : ImageButton = view.findViewById(R.id.purple)
        val cp05 : ImageButton = view.findViewById(R.id.light_brown)
        val cp06 : ImageButton = view.findViewById(R.id.light_pink)
        val cp07 : ImageButton = view.findViewById(R.id.porple_blue)
        val cp08 : ImageButton = view.findViewById(R.id.ocean_blue)
        val cp09 : ImageButton = view.findViewById(R.id.light_ocean_blue)
        val cp10 : ImageButton = view.findViewById(R.id.My_fav)
        val cp11 : ImageButton = view.findViewById(R.id.light_light_blue)
        val cp12 : ImageButton = view.findViewById(R.id.cloudy_color)
        val cp13 : ImageButton = view.findViewById(R.id.cloudy_dark)
        val cp14 : ImageButton = view.findViewById(R.id.green_fav)
        val cp15 : ImageButton = view.findViewById(R.id.google_green)
        val cp16 : ImageButton = view.findViewById(R.id.olive_green)
        val cp17 : ImageButton = view.findViewById(R.id.gray)
        val cp18 : ImageButton = view.findViewById(R.id.fav_dark_blue)
        val cp19 : ImageButton = view.findViewById(R.id.almost_dark)
        val cp20 : ImageButton = view.findViewById(R.id.gray_brown)
        val cp21 : ImageButton = view.findViewById(R.id.sand)
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
//--------------------------------------------------------------------------------------------------
        cp01.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.light_Blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp02.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.orange)));
        }
//--------------------------------------------------------------------------------------------------
        cp03.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.pinky)));
        }
//--------------------------------------------------------------------------------------------------
        cp04.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.purple)));
        }
//--------------------------------------------------------------------------------------------------
        cp05.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.light_brown)));
        }
//--------------------------------------------------------------------------------------------------
        cp06.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.light_pink)));
        }
//--------------------------------------------------------------------------------------------------
        cp07.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.porple_blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp08.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.ocean_blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp09.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.light_ocean_blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp10.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.My_fav)));
        }
//--------------------------------------------------------------------------------------------------
        cp11.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.light_light_blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp12.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.cloudy_color)));
        }
//--------------------------------------------------------------------------------------------------
        cp13.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.cloudy_dark)));
        }
//--------------------------------------------------------------------------------------------------
        cp14.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.green_fav)));
        }
//--------------------------------------------------------------------------------------------------
        cp15.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.google_green)));
        }
//--------------------------------------------------------------------------------------------------
        cp16.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.olive_green)));
        }
//--------------------------------------------------------------------------------------------------
        cp17.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.gray)));
        }
//--------------------------------------------------------------------------------------------------
        cp18.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.fav_dark_blue)));
        }
//--------------------------------------------------------------------------------------------------
        cp19.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.almost_dark)));
        }
//--------------------------------------------------------------------------------------------------
        cp20.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.gray_brown)));
        }
//--------------------------------------------------------------------------------------------------
        cp21.setOnClickListener {
            color.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.sand)));
        }
//==================================================================================================
    }
}