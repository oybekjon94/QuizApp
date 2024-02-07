package com.oybekdev.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oybekdev.quizapp.databinding.ViewholderLeadersBinding
import com.oybekdev.quizapp.domain.UserModel

class LeaderAdapter:RecyclerView.Adapter<LeaderAdapter.ViewHolder>() {


    private lateinit var binding: ViewholderLeadersBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderLeadersBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun getItemCount()= differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ViewholderLeadersBinding.bind(holder.itemView)
        binding.titleTxt.text = differ.currentList[position].name

        val drawableResourceId:Int = binding.root.resources.getIdentifier(
            differ.currentList[position].pic,
            "drawable",binding.root.context.packageName
        )
    }

    inner class ViewHolder:RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object :DiffUtil.ItemCallback<UserModel>(){
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallBack)
}