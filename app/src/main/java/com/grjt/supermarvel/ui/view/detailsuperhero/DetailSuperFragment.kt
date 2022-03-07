package com.grjt.supermarvel.ui.view.detailsuperhero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.grjt.supermarvel.R
import com.grjt.supermarvel.core.Resource
import com.grjt.supermarvel.databinding.FragmentDetailSuperBinding
import com.grjt.supermarvel.ui.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailSuperFragment : Fragment(R.layout.fragment_detail_super) {

    private lateinit var binding: FragmentDetailSuperBinding
    private val args by navArgs<DetailSuperFragmentArgs>()

    private val viewModel: SuperheroViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailSuperBinding.bind(view)

        viewModel.fetchItemSuperhero(args.idSuperhero).observe(viewLifecycleOwner, Observer { result ->
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
                    result.data[0].let { item ->
                        binding.txtName.text = item.name
                        val path = item.thumbnail.path
                        val extension = item.thumbnail.extension
                        val url = "$path.$extension"
                        activity?.let { val into =
                            Glide.with(it.applicationContext).load(url.replace("http", "https"))
                                .centerCrop().into(binding.imgBackground)
                            Glide.with(it.applicationContext).load(url.replace("http", "https"))
                                .centerCrop().into(binding.imgSuper)
                        }
                        viewModel.fetchComicSuperhero(item.id).observe(viewLifecycleOwner, Observer { result ->
                            when(result) {
                                is Resource.Failure -> binding.progressBar.visibility = View.GONE
                                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                                is Resource.Success -> {
                                    binding.progressBar.visibility = View.GONE
                                    result.data[0].let { item ->
                                        binding.txtDescriptionComic.text = item.description
                                    }
                                }
                            }
                        })

                        viewModel.fetchEventSuperhero(item.id).observe(viewLifecycleOwner, Observer { result ->
                            when(result) {
                                is Resource.Failure -> binding.progressBar.visibility = View.GONE
                                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                                is Resource.Success -> {
                                    binding.progressBar.visibility = View.GONE
                                    result.data[0].let { item ->
                                        binding.txtDescriptionEvent.text = item.description
                                    }
                                }
                            }
                        })

                        viewModel.fetchSeriesSuperhero(item.id).observe(viewLifecycleOwner, Observer { result ->
                            when(result) {
                                is Resource.Failure -> binding.progressBar.visibility = View.GONE
                                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                                is Resource.Success -> {
                                    binding.progressBar.visibility = View.GONE
                                    result.data[0].let { item ->
                                        binding.txtDescriptionSeries.text = item.description
                                    }
                                }
                            }
                        })

                        viewModel.fetchStoriesSuperhero(item.id).observe(viewLifecycleOwner, Observer { result ->
                            when(result) {
                                is Resource.Failure -> binding.progressBar.visibility = View.GONE
                                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                                is Resource.Success -> {
                                    binding.progressBar.visibility = View.GONE
                                    result.data[0].let { item ->
                                        binding.txtDescriptionStories.text = item.description
                                    }
                                }
                            }
                        })
                    }
                }
            }
        })
    }

}