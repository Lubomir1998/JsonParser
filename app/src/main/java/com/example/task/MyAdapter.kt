package com.example.task

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.task.data.Experience
import com.squareup.picasso.Picasso
import org.joda.time.DateTime
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class MyAdapter(private val context: Context, private var list: List<Experience>, var listener: OnItemClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return MyViewHolder(view)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor", "SimpleDateFormat")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]

        holder.titleTextView.text = current.title
        Picasso.with(context).load(current.imgUrl.original).into(holder.image)

        current.date.first().let {
//            val year = it.substring(0, 4)
//            val month = it.substring(5, 7)
//            val day = it.substring(8, 10)
//            val hour = it.substring(11, 13)
//            val minute = it.substring(14, 16)

//            holder.date.text = "$hour:$minute, $day.$month.$year"


            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            parser.setTimeZone(TimeZone.getTimeZone("UTC"))
            val date = parser.parse(it)

            val formatter = SimpleDateFormat("HH:mm, dd.MM.yyyy", Locale.getDefault())
//            formatter.timeZone = TimeZone.getDefault()
            val newDate = formatter.format(date)

            holder.date.text = newDate

            }




        if(current.type.equals("culture")){
          //  holder.circle.setColorFilter(R.color.green)
            holder.circle.setImageResource(R.drawable.green_circle)

        }
        else{
//            holder.circle.setBackgroundColor(Color.parseColor("#1A7DD6"))

            holder.circle.setImageResource(R.drawable.blue_circle)
        }

        holder.bind(current, listener)
    }

    override fun getItemCount(): Int = list.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val titleTextView = itemView.findViewById<TextView>(R.id.titleview)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val date = itemView.findViewById<TextView>(R.id.dateTextView)
        val circle = itemView.findViewById<ImageView>(R.id.circleType)

        fun bind(ex:Experience, listener: OnItemClickListener){
            itemView.setOnClickListener {
                listener.onItemClicked(ex)
            }
        }

    }


    interface OnItemClickListener{
        fun onItemClicked(exp: Experience)
    }

}