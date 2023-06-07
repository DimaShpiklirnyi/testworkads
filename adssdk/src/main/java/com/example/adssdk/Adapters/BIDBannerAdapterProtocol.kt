package com.example.adssdk.Adapters

interface BIDBannerAdapterProtocol {
    fun onClick()
    fun onDisplay()
    fun onFailedToDisplay(error: String)
    fun onFailedToLoad(error: String)
    fun onLoad()
}