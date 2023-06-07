package com.example.adssdk.Adapter

import com.example.adssdk.Adapters.BIDBannerAdapterProtocol

class BannerAdEvents(val formatName: String) : BIDBannerAdapterProtocol {
    override fun onClick() {
        println("kotlin $formatName: onClick")
    }

    override fun onDisplay() {
        println("kotlin $formatName: onDisplay")
    }

    override fun onFailedToDisplay(error: String) {
        println("kotlin $formatName: onFailedToDisplay: $error")
    }

    override fun onFailedToLoad(error: String) {
        println("kotlin $formatName: onFailedToLoad: $error" )
    }

    override fun onLoad() {
        println("kotlin $formatName: onLoad")
    }

}