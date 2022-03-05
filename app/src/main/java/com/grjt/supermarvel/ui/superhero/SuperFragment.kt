package com.grjt.supermarvel.ui.superhero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.grjt.supermarvel.R
import com.grjt.supermarvel.databinding.FragmentSuperBinding

class SuperFragment : Fragment(R.layout.fragment_super) {

    private lateinit var binding: FragmentSuperBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuperBinding.bind(view)
    }

}