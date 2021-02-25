package com.example.mvvmbasic.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbasic.R
import com.example.mvvmbasic.data.models.Users
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(val data : List<Users>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class UserViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
       fun bind(item :Users) = with(itemView){
           usernameTv.text = item.login
           Picasso.get().load(item .avatarUrl).into(userImgView)
       }
}
