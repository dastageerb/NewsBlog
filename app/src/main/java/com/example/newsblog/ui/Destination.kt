package com.example.newsblog.ui

sealed  class Destination(val route:String) {
    object HomeScreen: Destination("home")
    object  DetailScreen: Destination("details")
}