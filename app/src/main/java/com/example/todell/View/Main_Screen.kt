package com.example.todell.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModel
import com.example.todell.R
import com.example.todell.View.Lists.ListsAdapter

/***
 * A Fragment represents a reusable portion of your app's UI.
 * A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.
 * Fragments cannot live on their own--they must be hosted by an activity or another fragment.
 * The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
 * */
class Main_Screen : Fragment() {

    private val listsTitleList = mutableListOf<MainTaskWithSubTask>()
    // To get instance from view model you need to use bu activityViewModels to provide you with the object from the InventoryViewModel
    private val listViewModel : ListViewModel by activityViewModels()

//=====================================================================================================================================
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main__screen, container, false)
    }
//=====================================================================================================================================
    //* This event is triggered soon after onCreateView().
    //** Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    //** Setup any handles to view objects here
        val listRecyclerView : RecyclerView = view.findViewById(R.id.listRecyclerView)
        val addNewListButton : ImageButton = view.findViewById(R.id.mainScreenAddListButton)
      //val SideMenuButton : Button = view.findViewById(R.id.mainScreenSideMenuButton)

        val listAdapter = ListsAdapter(listsTitleList,listViewModel)
        listRecyclerView.adapter = listAdapter
//=====================================================================================================================================
    /***
     * When your app displays data or uses data in other ways,
     * you usually want to take action when the data changes.
     * This means you have to observe the data so that when it changes,
     * you can react. Depending on how the data is stored,
     * And now you can use LiveData for do that
     * */

    /*** Benefits of using LiveData
     * Ensures that your UI matches your data state
     * No memory leaks
     * No crashes due to stopped activities
     * Data is always up to date
     * Configuration changes handled properly
     * Resources can be shared
     * */
        listViewModel.ListsTitleList.observe(viewLifecycleOwner, Observer {
            it?.let { list ->
               listsTitleList.clear()
               listsTitleList.addAll(list)
                listAdapter.notifyDataSetChanged()
            } })
//=====================================================================================================================================
        addNewListButton.setOnClickListener {
            // Use the navigate method of NavController class with a destination id given in the navigation graph.
            view.findNavController().navigate(R.id.action_main_Screen_to_new_List)
        }
    }
}