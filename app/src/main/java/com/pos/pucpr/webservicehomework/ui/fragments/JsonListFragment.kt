package com.pos.pucpr.webservicehomework.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.common.exhaustive
import com.pos.pucpr.webservicehomework.common.ext.hideMainProgressBar
import com.pos.pucpr.webservicehomework.common.ext.showMainProgressBar
import com.pos.pucpr.webservicehomework.databinding.FragmentJsonListBinding
import com.pos.pucpr.webservicehomework.presentation.JsonListViewModel
import com.pos.pucpr.webservicehomework.ui.controller.CharacterListController
import org.koin.androidx.viewmodel.ext.android.viewModel

class JsonListFragment : Fragment() {

    private val viewModel: JsonListViewModel by viewModel()
    private lateinit var binding: FragmentJsonListBinding

    private val controller: CharacterListController by lazy {
        CharacterListController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJsonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchCharacters()

        initRecyclerView()

        subscriberObservers()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = controller.adapter
    }

    private fun subscriberObservers() {
        viewModel.fetchCharactersState.run {
            removeObservers(viewLifecycleOwner)
            observe(viewLifecycleOwner, Observer {
                when (it) {
                    Resource.Loading -> showMainProgressBar()
                    Resource.Error -> hideMainProgressBar()
                    is Resource.Success -> {
                        hideMainProgressBar()
                        controller.setData(viewModel.characters)
                    }
                }.exhaustive
            })
        }
    }

}
