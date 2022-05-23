package com.epicdevler.hirariaz.utils

sealed class InputFieldType {
    object Text : InputFieldType()
    object Email : InputFieldType()
    object Password : InputFieldType()
}