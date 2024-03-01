package com.example.cinemax


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemax_play.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class TopRatedMovieAdapter(val context: Activity, var movieArrayList: List<Result>) :
    RecyclerView.Adapter<TopRatedMovieAdapter.MyViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val title: TextView
        var image: ShapeableImageView
        val releaseDate: TextView
        val langauge: TextView


        init {
            title = itemView.findViewById(R.id.tvTittle)
            image = itemView.findViewById(R.id.popularMovieImage)
            releaseDate = itemView.findViewById(R.id.tvReleaseDate)
            langauge = itemView.findViewById(R.id.tvLanguage)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_container, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun getItemCount(): Int {
        return movieArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = movieArrayList[position]
        holder.title.text = currentItem.title
        holder.releaseDate.text = currentItem.release_date
        holder.langauge.text = currentItem.original_language
        //image view
        Picasso.get().load(currentItem.poster_path).into(holder.image)
    }
}