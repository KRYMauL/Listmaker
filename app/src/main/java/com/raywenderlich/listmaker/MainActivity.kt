package com.raywenderlich.listmaker

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.raywenderlich.listmaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoListRecylerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        todoListRecylerView = findViewById(R.id.lists_reclyclerview)
        todoListRecylerView.layoutManager = LinearLayoutManager(this)
        todoListRecylerView.adapter = TodoListAdapter()

        binding.fab.setOnClickListener { _ ->
            showCreateTodoListDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateTodoListDialog(): String{
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create)
        val myDialog = AlertDialog.Builder(this)
        val todoTitleEditText = EditText(this)
        todoTitleEditText.inputType = InputType.TYPE_CLASS_TEXT or
                InputType.TYPE_TEXT_FLAG_CAP_WORDS
        myDialog.setTitle(dialogTitle)
        myDialog.setView(todoTitleEditText)

        myDialog.setPositiveButton(positiveButtonTitle) {
                dialog, _ ->
                val adapter = todoListRecylerView.adapter as TodoListAdapter
                    adapter.addNewItem(todoTitleEditText.text.toString())
                    dialog.dismiss()
        }
        myDialog.create().show()

        return todoTitleEditText.toString()
    }
}