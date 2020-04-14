package com.pos.pucpr.webservicehomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pos.pucpr.webservicehomework.databinding.FragmentJsonListBinding

class JsonListFragment : Fragment() {

    private lateinit var binding: FragmentJsonListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJsonListBinding.inflate(inflater, container, false)
        return binding.root
    }

}
