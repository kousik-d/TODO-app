package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val todolist : MutableList<tododata> = mutableListOf()
    private val adapter = todoadapter(todolist)
    private var itemclicked = adapter.clicked
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerv :RecyclerView = findViewById(R.id.recyclerCompo)
        recyclerv.adapter = adapter
        recyclerv.layoutManager = LinearLayoutManager(this)
         recyclerv.setHasFixedSize(true)
    }
    fun insertItem(view :View){
        CreateDialog()
        adapter.notifyDataSetChanged()
    }
    fun itemDelete(view :View){
        for(i in itemclicked) {
            todolist.removeAt(i)
        }
        adapter.notifyDataSetChanged()
        /*
        if(todolist.size == 0){
            Toast.makeText(this,"Enter the data",Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this,"Removes first TODO",Toast.LENGTH_SHORT).show()
            todolist.removeAt(0)
            adapter.notifyDataSetChanged()
        }

         */
    }
    fun CreateDialog(){
            //Dialog Inflate

            val dialogview = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setView(dialogview)
                setTitle("TODO")
            }
            val alertdialog = builder.show()
            val ed1: EditText = dialogview.findViewById(R.id.editText_heading)
            val ed2:EditText = dialogview.findViewById(R.id.editText_text)
            val addbutton1: Button = dialogview.findViewById(R.id.addbutton)
            addbutton1.setOnClickListener {
                alertdialog.dismiss()
                val heading = ed1.text.toString()
                val activity = ed2.text.toString()
                if(ed1.text.isEmpty() or ed2.text.isEmpty()){
                    Toast.makeText(this,"Fill all the Data",Toast.LENGTH_SHORT).show()
                }else {
                    todolist.add(tododata(heading, activity))
                }
            }
    }


}