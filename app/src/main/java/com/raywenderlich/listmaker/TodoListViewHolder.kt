package com.raywenderlich.listmaker

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class TodoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var listPositionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var listTitleTextView = itemView.findViewById<TextView>(R.id.itemString)

}