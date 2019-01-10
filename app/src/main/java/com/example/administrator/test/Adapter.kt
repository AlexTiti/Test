package com.example.administrator.test

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * @author  : Alex
 * @date    : 2018/11/07
 * @version : V 2.0.2
 */
class Adapter(val list: List<String>,val context: Context) : RecyclerView.Adapter<Adapter.ViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        return ViewHodler(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    lateinit var view : View


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        holder.textView.text = list[position]
        holder.textView.setOnClickListener {
            Toast.makeText(context,list[position],Toast.LENGTH_SHORT).show()
        }
    }

 public class ViewHodler(view: View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.tvList)
    }

}