package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = MyListAdapter(ArrayList())
        val rv: RecyclerView = findViewById(R.id.rv)

        rv.adapter = todoAdapter
        rv.layoutManager = LinearLayoutManager(this)

        val add: Button = findViewById(R.id.add)
        val del: Button = findViewById(R.id.del)
        val text: EditText = findViewById(R.id.textAdd)

        add.setOnClickListener {
            val taskTitle = text.text.toString()
            if(taskTitle.isNotEmpty()) {
                val todo = Task(taskTitle)
                todoAdapter.addTodo(todo)
                text.text.clear()
            }
        }

        del.setOnClickListener { todoAdapter.delTodo() }
    }
}