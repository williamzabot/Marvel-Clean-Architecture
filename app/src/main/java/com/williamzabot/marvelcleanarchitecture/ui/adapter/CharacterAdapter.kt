package com.williamzabot.marvelcleanarchitecture.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.williamzabot.domain.models.Character
import com.williamzabot.marvelcleanarchitecture.databinding.ItemCharacterBinding

class CharacterAdapter :
    PagedListAdapter<Character, CharacterAdapter.CharacterViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        getItem(position).let { holder.bind(it!!) }

    inner class CharacterViewHolder(private val viewDataBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(character: Character) {
            viewDataBinding.character = character
            viewDataBinding.listener = View.OnClickListener {
                Toast.makeText(viewDataBinding.root.context, character.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.url == newItem.url
        }
    }
}
