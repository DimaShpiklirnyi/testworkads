package com.example.adssdk.Adapter

import com.example.adssdk.Adapters.BIDFullscreenAdapterProtocol

class FullscreenAdEvents(val formatName: String) : BIDFullscreenAdapterProtocol {
    override fun onAdFailedToLoadWithError(error: String) {
        println("kotlin_ios| $formatName: onAdFailedToLoadWithError: $error")
    }

    override fun onAdLoaded() {
        println("kotlin| $formatName: onAdLoaded")
    }

    override fun onClick() {
        println("kotlin| $formatName: onClick")
    }

    override fun onDisplay() {
        println("kotlin $formatName: onDisplay")
    }

    override fun onFailedToDisplay(error: String) {
        println("kotlin $formatName: onFailedToDisplay: $error")
    }

    override fun onFailedToDisplay(error: String, andToClose: Boolean) {
        println("kotlin $formatName: onFailedToDisplay: $error $andToClose")
    }

    override fun onHide() {
        println("kotlin $formatName: onHide")
    }

    override fun onReward() {
        println("kotlin $formatName: onReward")
    }
}