package com.williamzabot.marvelcleanarchitecture.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.williamzabot.domain.models.Character
import com.williamzabot.marvelcleanarchitecture.R
import com.williamzabot.marvelcleanarchitecture.extensions.urlImage
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter :
    PagedListAdapter<Character, CharacterAdapter.CharacterViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
    )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        getItem(position).let { holder.bind(it!!) }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            itemView.name_item_character.text = character.name
            itemView.img_item_character.urlImage(character.url)
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.url == newItem.url

        }
    }
}
