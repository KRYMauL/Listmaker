package com.raywenderlich.listmaker
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class TodoListAdapter() : RecyclerView.Adapter<TodoListViewHolder>() {

    private var todoLists = mutableListOf<String>("Android Development", "House Work",
        "Errands", "Shopping")

    fun addNewItem(listName: String = "") {
        if (listName.isEmpty()) {
            todoLists.add("todo list " + (todoLists.size + 1))
    } else todoLists.add(listName)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)

        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {

        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = todoLists[position]
    }

    override fun getItemCount(): Int {
        return todoLists.size
    }

}