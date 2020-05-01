package com.pos.pucpr.webservicehomework.presentation.exercise2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.domain.DateDiffUseCase
import com.pos.pucpr.webservicehomework.models.json.DateDiffResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DateDiffViewModel(
    private val diffUseCase: DateDiffUseCase
) : ViewModel() {

    private var _dateDiffResponse: DateDiffResponse =
        DateDiffResponse(
            differenceInDays = 0,
            differenceInMonths = 0,
            differenceInWeeks = 0
        )

    val dateDiffResponse: DateDiffResponse get() = _dateDiffResponse

    private val _submitDateDiffState: MutableLiveData<Resource<Unit>> by lazy {
        MutableLiveData<Resource<Unit>>()
    }
    val submitDateDiffState: LiveData<Resource<Unit>> get() = _submitDateDiffState

    fun submitDateDiff(dateStart: String, dateFinish: String) {
        viewModelScope.launch {
            delay(1000)
            _submitDateDiffState.value = Resource.Loading
            diffUseCase.invoke(
                dateStart = dateStart,
                dateFinish = dateFinish
            ).fold(
                failed = {
                    _submitDateDiffState.value = Resource.Error
                },
                succeeded = { response ->
                    _dateDiffResponse = response.copy()
                    _submitDateDiffState.value = Resource.Success(Unit)
                }
            )

        }
    }

}