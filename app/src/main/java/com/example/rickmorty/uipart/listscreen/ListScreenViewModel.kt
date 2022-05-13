package com.example.rickmorty.uipart.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.RickMortyModels.json.Result
import com.example.rickmorty.helpers.RetrofitHelper
import com.example.rickmorty.uipart.listscreen.reos.RickRepo
import kotlinx.coroutines.launch

class ListScreenViewModel:ViewModel() {
    private val charsLiveData = MutableLiveData<List<Result>>()
    private val rickRepo = RickRepo.getInstance()
    init {
        viewModelScope.launch { // ეს viewModelScope არის ავტომატურად ბექგგრაუნდ სრედი //query  პარამეტრი არააა საჭირო
            charsLiveData.postValue(rickRepo.getChars("843c612d1207fdec63f0e6a5fd426d68").results)
        }
    }

    fun getCharsLiveData():LiveData<List<Result>>{
        return charsLiveData
    }


}