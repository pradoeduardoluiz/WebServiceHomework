package com.pos.pucpr.webservicehomework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pos.pucpr.webservicehomework.common.Resource
import com.pos.pucpr.webservicehomework.domain.GetCharacters
import com.pos.pucpr.webservicehomework.models.Character
import kotlinx.coroutines.launch

class JsonListViewModel(private val getCharacters: GetCharacters) : ViewModel() {

    private val _characters: MutableList<Character> = mutableListOf()
    val characters: List<Character> get() = _characters

    private val _fetchCharactersState: MutableLiveData<Resource<Unit>> by lazy {
        MutableLiveData<Resource<Unit>>()
    }
    val fetchCharactersState: LiveData<Resource<Unit>> get() = _fetchCharactersState

    fun fetchCharacters() {
        viewModelScope.launch {
            _fetchCharactersState.value = Resource.Loading
            getCharacters.invoke(page = 1).fold(
                failed = {
                    _fetchCharactersState.value = Resource.Error
                },
                succeeded = { response ->
                    _characters.run {
                        clear()
                        addAll(response.characters)
                    }
                    _fetchCharactersState.value = Resource.Success(Unit)
                }
            )

        }
    }

}