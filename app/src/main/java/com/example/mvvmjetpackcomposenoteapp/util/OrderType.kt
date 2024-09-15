package com.example.mvvmjetpackcomposenoteapp.util

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
