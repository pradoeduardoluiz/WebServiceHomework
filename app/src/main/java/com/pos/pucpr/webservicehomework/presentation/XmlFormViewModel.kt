package com.pos.pucpr.webservicehomework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.domain.GetAddress
import com.pos.pucpr.webservicehomework.models.xml.CepResponse
import kotlinx.coroutines.launch

class XmlFormViewModel(private val getAddress: GetAddress) : ViewModel() {

    private var _address: CepResponse = CepResponse()
    val address: CepResponse get() = _address

    private val _fetchAddressState: MutableLiveData<Resource<Unit>> by lazy {
        MutableLiveData<Resource<Unit>>()
    }
    val fetchAddressState: LiveData<Resource<Unit>> get() = _fetchAddressState

    fun fetchAddressByCep(cep: String) {
        viewModelScope.launch {
            _fetchAddressState.value = Resource.Loading
            getAddress.invoke(cep).fold(
                failed = {
                    _fetchAddressState.value = Resource.Error
                },
                succeeded = { response ->
                    _address = response.copy()
                    _fetchAddressState.value = Resource.Success(Unit)
                }
            )

        }
    }

}