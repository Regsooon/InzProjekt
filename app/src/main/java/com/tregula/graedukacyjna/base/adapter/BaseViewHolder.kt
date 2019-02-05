package com.tregula.graedukacyjna.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<ViewModel>(parent: ViewGroup, @LayoutRes layoutInt: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        layoutInt,
        parent,
        false)) {

    protected val context: Context
        get() = itemView.context

    abstract fun bind(item: ViewModel)
}