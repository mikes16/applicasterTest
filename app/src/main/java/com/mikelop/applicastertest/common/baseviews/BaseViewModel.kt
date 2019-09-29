package com.mikelop.applicastertest.common.baseviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikelop.applicastertest.common.Failure

open class BaseViewModel: ViewModel(){

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    protected fun handleFailure(failure: Failure) {
        this._failure.postValue(failure)
    }

}