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
import com.pos.pucpr.webservicehomework.databinding.FragmentXmlListBinding
import com.pos.pucpr.webservicehomework.presentation.XmlFormViewModel
import com.redmadrobot.inputmask.MaskedTextChangedListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class XmlFormFragment : Fragment() {

    private val viewModel: XmlFormViewModel by viewModel()
    private lateinit var binding: FragmentXmlListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentXmlListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()

        binding.editCep.let {
            val listener = MaskedTextChangedListener(
                CEP_MASK, it,
                valueListener = object : MaskedTextChangedListener.ValueListener {
                    override fun onTextChanged(
                        maskFilled: Boolean,
                        extractedValue: String,
                        formattedValue: String
                    ) {
                        if (maskFilled) {
                            viewModel.fetchAddressByCep(extractedValue)
                        }
                    }
                })
            it.addTextChangedListener(listener)
        }
    }

    private fun subscribeObservers() {
        viewModel.fetchAddressState.run {
            removeObservers(viewLifecycleOwner)
            observe(viewLifecycleOwner, Observer {
                when (it) {
                    Resource.Loading -> showMainProgressBar()
                    Resource.Error -> hideMainProgressBar()
                    is Resource.Success -> {
                        hideMainProgressBar()
                        updateUi()
                    }
                }.exhaustive
            })
        }
    }

    private fun updateUi() {
        binding.editStreet.setText(viewModel.address.street)
        binding.editDistrict.setText(viewModel.address.district)
        binding.editCity.setText(viewModel.address.locale)
        binding.editUf.setText(viewModel.address.uf)
    }

    companion object {
        const val CEP_MASK = "[00000]-[000]"
    }

}
