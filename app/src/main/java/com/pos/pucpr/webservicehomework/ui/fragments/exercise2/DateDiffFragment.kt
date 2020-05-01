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
import com.pos.pucpr.webservicehomework.databinding.FragmentDateDiffBinding
import com.pos.pucpr.webservicehomework.presentation.DateDiffViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DateDiffFragment : Fragment() {

    private lateinit var binding: FragmentDateDiffBinding

    private val viewModel: DateDiffViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDateDiffBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()

        binding.buttonCalcDiff.setOnClickListener {
            viewModel.submitDateDiff(
                dateStart = binding.textInitialDate.text.toString(),
                dateFinish = binding.textFinishDate.text.toString()
            )
        }
    }

    private fun subscribeObservers() {
        viewModel.submitDateDiffState.run {
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
        viewModel.dateDiffResponse.let {
            binding.textDifferenceInDays.text =
                getString(R.string.label_difference_in_days, it.differenceInDays.toString())

            binding.textDifferenceInWeeks.text =
                getString(R.string.label_difference_in_weeks, it.differenceInWeeks.toString())

            binding.textDifferenceInMonths.text =
                getString(R.string.label_difference_in_months, it.differenceInMonths.toString())
        }
    }
}
