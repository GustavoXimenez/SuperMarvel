package com.grjt.supermarvel.ui.superhero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.grjt.supermarvel.R
import com.grjt.supermarvel.core.Resource
import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.remote.SuperDataSource
import com.grjt.supermarvel.databinding.FragmentSuperBinding
import com.grjt.supermarvel.presentation.SuperViewModelFactory
import com.grjt.supermarvel.presentation.SuperheroViewModel
import com.grjt.supermarvel.repository.RetrofitClient
import com.grjt.supermarvel.repository.SuperRepositoryImpl
import com.grjt.supermarvel.repository.WebService
import com.grjt.supermarvel.ui.superhero.adapter.SuperheroAdapter

class SuperFragment : Fragment(R.layout.fragment_super), SuperheroAdapter.OnSuperheroClickListener {

    private lateinit var binding: FragmentSuperBinding
    private val viewModel by viewModels<SuperheroViewModel> {
        SuperViewModelFactory(SuperRepositoryImpl(SuperDataSource(RetrofitClient.webservice)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuperBinding.bind(view)

        viewModel.fetchSuperhero().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.constraintLayout, "${result.exception.message}", Snackbar.LENGTH_LONG).show()
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val adapter = SuperheroAdapter(result.data.data.results, this@SuperFragment)
                    binding.rvSuper.adapter = adapter
                }
            }
        })
    }

    override fun onSuperheroClick(superHero: Superhero) {
        val action = SuperFragmentDirections.actionSuperFragmentToDetailSuperFragment(superHero.id)
        findNavController().navigate(action)
    }

}