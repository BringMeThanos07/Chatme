package com.example.reclycerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_fruit.view.*

class FruitAdapter(val fruits:ArrayList<Fruit>) :RecyclerView.Adapter<FruitAdapter.fruitViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): fruitViewHolder {
       val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_fruit,parent,false
        )
        return fruitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: fruitViewHolder, position: Int) {
        holder.itemView.tvFruitName.text=fruits[position].name
        holder.itemView.tvOrigin.text=fruits[position].origin
        holder.itemView.tvQuantity.text=fruits[position].quantity.toString()
    }

    override fun getItemCount(): Int =fruits.size

    class fruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}