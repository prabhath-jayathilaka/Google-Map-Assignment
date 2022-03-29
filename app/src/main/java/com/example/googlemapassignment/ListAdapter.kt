package com.example.googlemapassignment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private var items: List<Location>, private val communicator: View) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val itemTitle: TextView = itemView.findViewById(R.id.tv_name)


        init {


            itemView.setOnClickListener(this)
        }
//        init {
//            itemView.setOnClickListener { view: View ->
//                val activity = view.context as AppCompatActivity
//                activity.supportFragmentManager.beginTransaction().apply {
//                    replace(R.id.flFragment, MapsFragment())
//                    addToBackStack(null)
//                    commit()
//
//                }
//
//            }
//        }

        override fun onClick(p0: View?) {
            val currentItem = items[adapterPosition]
            val bundle = bundleOf("location" to currentItem)
            communicator.findNavController().navigate(R.id.mapsFragment, bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
           val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemTitle.text = items[position].name
//        Log.i("frg","posts")
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
