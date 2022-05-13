package com.example.rickmorty.uipart.listscreen

import android.R.attr.fadeDuration
import android.R.attr.scaleType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.RickMortyModels.json.Result
import com.example.rickmorty.databinding.RickMortyItemLayoutBinding
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder


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
        holder.binding.avatar.setImageURI("https://rickandmortyapi.com/api/character/avatar/${item.id}.jpeg") //პირდაპირ მოყვება imaage პარამეტრი
        holder.binding.characterName.text = item.name
        holder.binding.GenderAndRace.text = "${item.status} - ${item.species}"
        holder.binding.lastKnownLocation.text = "${item.location.name}"

        if (item.gender == "Male"){
            holder.binding.genderSing.setImageURI("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRASGnAmFZp3Ls9bK4kYmICpNd0b9OnJTrzIg&usqp=CAU")
        }else if (item.gender == "Female"){
            holder.binding.genderSing.setImageURI("https://cdn1.iconfinder.com/data/icons/medicine-pt-6/100/087_-_woman_gender_sex_female_gender_symbol-512.png")
        }

        if (item.status == "Alive"){
            holder.binding.circle.setImageResource(R.drawable.circle_alive)
        }else if (item.status == "Dead"){
            holder.binding.circle.setImageResource(R.drawable.circle_dead)
        }else{
            holder.binding.circle.setImageResource(R.drawable.circle_unknown)
        }


    }

    override fun getItemCount(): Int {
        return rickMortyList.size
    }
}



class RickMortyViewHolder(val binding: RickMortyItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

}