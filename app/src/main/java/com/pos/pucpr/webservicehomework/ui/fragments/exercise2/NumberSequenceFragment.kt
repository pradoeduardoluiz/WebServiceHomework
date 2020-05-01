package com.pos.pucpr.webservicehomework.ui.fragments.exercise2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pos.pucpr.webservicehomework.R
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.common.exhaustive
import com.pos.pucpr.webservicehomework.common.ext.hideMainProgressBar
import com.pos.pucpr.webservicehomework.common.ext.showMainProgressBar
import com.pos.pucpr.webservicehomework.databinding.FragmentNumberSequenceBinding
import com.pos.pucpr.webservicehomework.presentation.exercise2.NumberSequenceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NumberSequenceFragment : Fragment() {

    private lateinit var binding: FragmentNumberSequenceBinding

    private val viewModel: NumberSequenceViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberSequenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()

        binding.buttonOrderingSequence.setOnClickListener {
            viewModel.submitNumberSequence(
                sequence = binding.textNumberSequence.text.toString()
            )
        }
    }

    private fun subscribeObservers() {
        viewModel.submitNumberSequenceState.run {
            removeObservers(viewLifecycleOwner)
            observe(viewLifecycleOwner, Observer {
                when (it) {
                    Resource.Loading -> showMainProgressBar()
                    Resource.Error -> hideMainProgressBar()
                    is Resource.Success -> {
                        hideMainProgressBar()
                        updateView()
                    }
                }.exhaustive
            })
        }
    }

    private fun updateView() {
        viewModel.numberSequenceResponse.let {
            binding.textAscendingOrder.text =
                getString(R.string.label_ascending_order, it.ascendingOrder.toString())

            binding.textDescendingOrder.text =
                getString(R.string.label_descending_order, it.descendingOrder.toString())

            binding.textPairNumber.text =
                getString(R.string.label_pair_numbers, it.pairNumbers.toString())
        }
    }
}
