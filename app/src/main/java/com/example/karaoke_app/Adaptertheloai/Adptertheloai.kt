package com.example.karaoke_app.Adaptertheloai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karaoke_app.Interface.OnCategoryClickListner
import com.example.karaoke_app.R
import kotlinx.android.synthetic.main.item_theloai.view.*


class Adptertheloai(private val list: List<theloai>, var clicklistner: OnCategoryClickListner
                    ) :
                    RecyclerView.Adapter<Adptertheloai.ViewHolder>() {

    inner class  ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val imageview : ImageView = itemview.image_view
        val textview : TextView = itemview.text_view

        fun initialize(item: theloai,action: OnCategoryClickListner){
            imageview.setImageResource(item.image)
            textview.text =item.text

            itemView.setOnClickListener{
                action.OnCategoryClick(item,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_theloai,parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currenItem = list[position]
//        holder.imageview.setImageResource(currenItem.image)
//        holder.textview.text = currenItem.text
            holder.initialize(list.get(position),clicklistner)
    }


    override fun getItemCount() = list.size
}