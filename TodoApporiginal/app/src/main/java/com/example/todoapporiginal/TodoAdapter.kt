package com.example.todoapporiginal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemtodo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter (val list: List<TodoModel>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    class TodoViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(todoModel: TodoModel) {
            with(itemView){
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                viewColorTag.setBackgroundColor(randomColor)
                txtShowTitle.text = todoModel.title
                txtShowTask.text = todoModel.description
                txtShowCategory.text = todoModel.category
                updateTime(todoModel.time)
                updateDate(todoModel.date)
            }
        }

        private fun updateDate(date: Long) {
            //Mon, 5 Jan 2020
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowTime.text = sdf.format(Date(date))
        }

        private fun updateTime(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowDate.text = sdf.format(Date(time))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {      //implement the member by command+n
        return TodoViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.itemtodo,parent,false))

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
    override fun getItemId(position: Int): Long {
        return list[position].id
    }
}