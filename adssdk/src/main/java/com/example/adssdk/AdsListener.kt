package com.example.adssdk

interface AdsListener {
    fun success(str : String)
    fun error(err:String)
    fun bannerError(err:String)
    fun interstitialError(err:String)
    fun bannerClick ()
    fun interstitialClick()
}