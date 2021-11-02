package com.example.todell.View.Lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todell.Database.Models.MainTaskWithSubTask
import com.example.todell.Database.Models.TodellModel
import com.example.todell.R
import com.example.todell.Repositories.ListsRepositories
import com.example.todell.View.ListViewModel

/***
Once you've determined your layout, you need to implement your Adapter and ViewHolder.
These two classes work together to define how your data is displayed.
The ViewHolder is a wrapper around a View that contains the layout for an individual item in the list.
The Adapter creates ViewHolder objects as needed, and also sets the data for those views.
The process of associating views to their data is called binding.
When you define your adapter, you need to override three key methods:
onCreateViewHolder()
onBindViewHolder()
getItemCount()
 **/

class ListsAdapter
    (val Lists: List<MainTaskWithSubTask>, val listModel: ListViewModel):
    RecyclerView.Adapter<ListsAdapter.ListViewHolder>(){
//================================================================================================================
    /**
     * onCreateViewHolder(): RecyclerView calls this method whenever it needs to create a new ViewHolder.
    The method creates and initializes the ViewHolder and its associated View,
    but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_list,
                parent,
                false
            )
        )
    }
//================================================================================================================
    /**
     * onBindViewHolder(): RecyclerView calls this method to associate a ViewHolder with data.
    The method fetches the appropriate data and uses the data to fill in the view holder's layout.
    For example, if the RecyclerView displays a list of names,
    the method might find the appropriate name in the list and fill in the view holder's TextView widget.
     */
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val list = Lists[position].task
        holder.listTextView.text = list.listTitle
        holder.itemView.setOnClickListener { view ->
            listModel.selectedItem = list.listId
            // post value to liveData to send data from the Main_Screen fragment to Task_List fragment
            //listModel.selectedListMutableLiveData.postValue(Lists[position])
            view.findNavController().navigate(R.id.action_main_Screen_to_task_List)
        }
    }
//================================================================================================================
    /**
     * getItemCount(): RecyclerView calls this method to get the size of the data set.
    For example, in an address book app, this might be the total number of addresses.
    RecyclerView uses this to determine when there are no more items that can be displayed.
     */
    override fun getItemCount(): Int {
        return Lists.size
    }
    class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listTextView: TextView = view.findViewById(R.id.BubbleTaskTitleTextView)
    }
}