package com.example.crypto_app.ViewModel

import androidx.lifecycle.ViewModel
import com.example.crypto_app.Repository.MainRepository

class MainViewModel
    (val repository: MainRepository):ViewModel(){
        constructor():this(MainRepository())

    fun loadData()=repository.items
}