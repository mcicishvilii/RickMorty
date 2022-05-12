package com.example.rickmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.RickMortyModels.json.Result
import com.example.rickmorty.databinding.RickMortyItemLayoutBinding


class RickMortyAdapter(val rickMortyList: MutableList<Result>):RecyclerView.Adapter<RickMortyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val binding =
            RickMortyItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickMortyViewHolder(binding)
    }

    fun updateList(items:List<Result>){
        rickMortyList.clear()
        rickMortyList.addAll(items)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {

        val item = rickMortyList[position]
        holder.binding.listLayout.text = item.name
        holder.binding.meore.text = item.gender
    }

    override fun getItemCount(): Int {
        return rickMortyList.size
    }

}

class RickMortyViewHolder(val binding: RickMortyItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

}