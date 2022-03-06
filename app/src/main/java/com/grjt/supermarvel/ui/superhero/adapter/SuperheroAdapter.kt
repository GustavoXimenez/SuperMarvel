package com.grjt.supermarvel.ui.superhero.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.databinding.SuperheroItemBinding

class SuperheroAdapter(
    private val superheroList: List<Superhero>,
    private val itemClickListener: OnSuperheroClickListener
): Adapter<SuperheroAdapter.SuperViewHolder>() {

    interface OnSuperheroClickListener {
        fun onSuperheroClick(superHero: Superhero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperViewHolder {
        val itemBinding = SuperheroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = SuperViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition
            itemClickListener.onSuperheroClick(superheroList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: SuperViewHolder, position: Int) {
        when(holder) {
           is SuperViewHolder -> holder.bind(superheroList[position])
        }
    }

    override fun getItemCount(): Int = superheroList.size

    inner class SuperViewHolder(
        val binding: SuperheroItemBinding,
        val context: Context
    ): ViewHolder(binding.root) {
        fun bind(item: Superhero) {
            val path = item.thumbnail.path
            val extension = item.thumbnail.extension
            val url = "$path.$extension"
            Glide.with(context).load(url.replace("http", "https")).centerCrop().into(binding.imgSuperhero)
            binding.txtSuperhero.text = item.name
        }
    }

}
