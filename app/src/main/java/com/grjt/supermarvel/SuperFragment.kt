package com.grjt.supermarvel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grjt.supermarvel.databinding.FragmentSuperBinding

class SuperFragment : Fragment(R.layout.fragment_super) {

    private lateinit var binding: FragmentSuperBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuperBinding.bind(view)
    }

}