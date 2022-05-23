package com.epicdevler.hirariaz.utils

typealias OperationResponse = Response<Unit, Unit>

sealed class Response<S, E>(data: S? = null, errorMsg: E? = null) {
    class Success<S, E>(data: S?) : Response<S, E>(data = data)
    class Error<S, E>(msg: E?) : Response<S, E>(errorMsg = msg)
    class Loading<S, E> : Response<S, E>()
}