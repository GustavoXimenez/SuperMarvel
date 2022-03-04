package com.grjt.supermarvel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grjt.supermarvel.databinding.FragmentDetailSuperBinding
import com.grjt.supermarvel.databinding.FragmentSuperBinding

class DetailSuperFragment : Fragment(R.layout.fragment_detail_super) {

    private lateinit var binding: FragmentDetailSuperBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailSuperBinding.bind(view)
    }

}