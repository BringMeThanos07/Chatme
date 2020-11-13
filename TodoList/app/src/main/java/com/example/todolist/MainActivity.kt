package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.todolist.db.MyDbHelper
import com.example.todolist.db.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos=ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter= ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        val db= MyDbHelper(this).writableDatabase

        fun refreshTodolist(){
            val todolist = TodoTable.getAllTodos(db)
            //Log.d("TODOS",todolist.toString())
            todos.clear()
            todos.addAll(todolist)

            todoAdapter.notifyDataSetChanged()
        }

        lvTodo.adapter=todoAdapter

        btnTodo.setOnClickListener {
            //val newTodo= etNewTodo.text.toString()

            val newTodo=Todo(
                etNewTodo.text.toString(),
                false
            )

            TodoTable.insertTodo(db,newTodo)
            refreshTodolist()


           // todos.add(newTodo)
            // todoAdapter.notifyDataSetChanged()
        }
    }

}