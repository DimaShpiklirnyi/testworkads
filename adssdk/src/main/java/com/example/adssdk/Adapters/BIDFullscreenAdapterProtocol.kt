package com.example.adssdk.Adapters

interface BIDFullscreenAdapterProtocol {
    fun onAdFailedToLoadWithError(error: String)
    fun onAdLoaded()
    fun onClick()
    fun onDisplay()
    fun onFailedToDisplay(error: String)
    fun onFailedToDisplay(error: String, andToClose:Boolean)
    fun onHide()
    fun onReward()
}