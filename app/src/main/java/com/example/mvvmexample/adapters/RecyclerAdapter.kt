package com.example.mvvmexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmexample.R
import com.example.mvvmexample.models.NicePlace

class RecyclerAdapter(context: Context, nicePlaces: ArrayList<NicePlace>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val rContext = context
    private val data = nicePlaces
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position].title
        val defaultOptions = RequestOptions().error(R.drawable.ic_launcher_foreground)
        Glide.with(rContext).setDefaultRequestOptions(defaultOptions)
            .load(data[position].imageURL).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recycler_image)
        val textView: TextView = itemView.findViewById(R.id.recycler_tv)
    }
}