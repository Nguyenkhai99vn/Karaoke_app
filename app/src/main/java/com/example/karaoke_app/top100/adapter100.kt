package com.example.karaoke_app.top100


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karaoke_app.Adaptertheloai.theloai
import com.example.karaoke_app.Interface.OncTopClickListner
import com.example.karaoke_app.R
import kotlinx.android.synthetic.main.item_fg_list.view.*


class adapter100(private val list100 : List<top100>, var clicklistner: OncTopClickListner) : RecyclerView.Adapter<adapter100.ViewHolder>() {

    class  ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val imageview : ImageView = itemview.imageView100
        val text100 : TextView = itemview.TextView100

        fun initialize(item: top100,action: OncTopClickListner){
            imageview.setImageResource(item.image)
            text100.text =item.text

            itemView.setOnClickListener{
                action.OnTopClick(item,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_fg_list,parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currenItem = list100[position]
//        holder.imageview.setImageResource(currenItem.image)
        holder.initialize(list100.get(position),clicklistner)
    }

    override fun getItemCount() = list100.size
}