package com.grjt.supermarvel.ui.detailsuperhero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.grjt.supermarvel.R
import com.grjt.supermarvel.databinding.FragmentDetailSuperBinding

class DetailSuperFragment : Fragment(R.layout.fragment_detail_super) {

    private lateinit var binding: FragmentDetailSuperBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailSuperBinding.bind(view)
    }

}