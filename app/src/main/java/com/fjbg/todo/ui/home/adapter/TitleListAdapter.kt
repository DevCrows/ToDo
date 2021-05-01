package com.fjbg.todo.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.databinding.ItemTitleBinding

class TitleListAdapter(
    private val title: String,
    private val isHome: Boolean,
) : RecyclerView.Adapter<TitleListAdapter.TitleListViewHolder>() {

    lateinit var binder: ItemTitleBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleListViewHolder {
        binder = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleListViewHolder()
    }

    override fun onBindViewHolder(holder: TitleListViewHolder, position: Int) =
        holder.initData(title, isHome)

    override fun getItemCount(): Int = 1

    inner class TitleListViewHolder : RecyclerView.ViewHolder(binder.root) {
        fun initData(title: String, isHome: Boolean) {

            if (isHome) {
                binder.tvHome.text = title
                binder.tvHome.visibility = View.VISIBLE
                binder.tvListTitle.visibility = View.GONE
            } else {
                binder.tvListTitle.text = title
                binder.tvListTitle.visibility = View.VISIBLE
                binder.tvHome.visibility = View.GONE
            }
        }
    }
}