package com.pos.pucpr.webservicehomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pos.pucpr.webservicehomework.databinding.FragmentXmlListBinding

class XmlListFragment : Fragment() {

    private lateinit var binding: FragmentXmlListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentXmlListBinding.inflate(inflater, container, false)
        return binding.root
    }

}
