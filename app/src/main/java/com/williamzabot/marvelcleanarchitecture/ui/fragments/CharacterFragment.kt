package com.williamzabot.marvelcleanarchitecture.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.williamzabot.marvelcleanarchitecture.R
import com.williamzabot.marvelcleanarchitecture.extensions.observe
import com.williamzabot.marvelcleanarchitecture.ui.adapter.CharacterAdapter
import com.williamzabot.marvelcleanarchitecture.viewModels.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment(R.layout.fragment_characters) {

    private val viewModel by viewModel<CharacterViewModel>()
    private val adapter by lazy { CharacterAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inscribeObservers()
        recycler_view_characters.adapter = adapter
    }

    private fun inscribeObservers() {
        observe(viewModel.pagedListCharacter) {
            adapter.submitList(it)
        }
    }
}
