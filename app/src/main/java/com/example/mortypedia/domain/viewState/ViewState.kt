package com.example.mortypedia.domain.viewState

sealed class ViewState<out T> {

    object Loading: ViewState<Nothing>()
    class Success<out T>(val data: T): ViewState<T>()
    class Error<out T>(val message: String): ViewState<T>()
}
