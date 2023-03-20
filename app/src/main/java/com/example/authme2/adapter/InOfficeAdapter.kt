package com.example.authme2.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.authme2.R
import com.example.authme2.model.User


class InOfficeAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<InOfficeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.in_office_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name

        val fnm = user.pictureName //  this is image file name


//    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgId);
//    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgId);
        fnm?.let { holder.imageView1.setImageResource(it) }


    }

    override fun getItemCount() = userList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.user_name)
        val imageView1: ImageView = itemView.findViewById(R.id.imageView1)
    }
}