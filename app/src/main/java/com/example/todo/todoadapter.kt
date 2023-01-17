package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class todoadapter(val todolist :MutableList<tododata>):RecyclerView.Adapter<todoadapter.todoviewHolder>() {

    inner class todoviewHolder(itemview: View ): RecyclerView.ViewHolder(itemview){
        val txt1:TextView = itemview.findViewById(R.id.heading_text)
        val txt2:TextView = itemview.findViewById(R.id.Activity_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoviewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.totitem_layout,parent,false)
        return todoviewHolder(item)
    }

    override fun getItemCount() = todolist.size

    override fun onBindViewHolder(holder: todoviewHolder, position: Int) {
        val curr = todolist[position]
        holder.txt1.text = curr.todoHead.toString()
        holder.txt2.text = curr.todoActivity.toString()
    }
}