package com.example.kotlinpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpractice.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var dataList: List<DataModel>? = null

    fun setDataList(dataList: List<DataModel>?) {
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        holder.bind(dataList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (dataList == null) 0
        else dataList?.size!!
    }

    inner class MyViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: DataModel) {
            binding.tvId.text = model.id.toString()
            binding.tvTitle.text = model.title
            binding.tvBody.text = model.body
        }
    }
}