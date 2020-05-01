package com.pos.pucpr.webservicehomework.presentation.exercise2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.domain.NumberSequenceUseCase
import com.pos.pucpr.webservicehomework.models.json.NumberSequenceResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NumberSequenceViewModel(
    private val numberSequenceUseCase: NumberSequenceUseCase
) : ViewModel() {

    private var _numberSequenceResponse: NumberSequenceResponse =
        NumberSequenceResponse(
            ascendingOrder = "",
            descendingOrder = "",
            pairNumbers = ""
        )

    val numberSequenceResponse: NumberSequenceResponse get() = _numberSequenceResponse

    private val _submitNumberSequence: MutableLiveData<Resource<Unit>> by lazy {
        MutableLiveData<Resource<Unit>>()
    }
    val submitNumberSequenceState: LiveData<Resource<Unit>> get() = _submitNumberSequence

    fun submitNumberSequence(sequence: String) {
        viewModelScope.launch {
            delay(1000)
            _submitNumberSequence.value = Resource.Loading
            numberSequenceUseCase.invoke(
                sequence
            ).fold(
                failed = {
                    _submitNumberSequence.value = Resource.Error
                },
                succeeded = { response ->
                    _numberSequenceResponse = response.copy()
                    _submitNumberSequence.value = Resource.Success(Unit)
                }
            )

        }
    }

}