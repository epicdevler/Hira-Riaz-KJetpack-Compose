package com.epicdevler.hirariaz.utils

data class TransactionModel(
    val type: TransactionType,
    val info: String,
    val cost: String,
    val currencySign: String,
)

enum class TransactionType {
    Sent, Received, Loan, Payment
}