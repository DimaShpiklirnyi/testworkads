package com.example.adssdk.Platform

interface Platform {
    val name: String
    fun start()
    fun loadInterstitial()
    fun loadRewarded()
    fun loadBanner()
    fun showInterstitial()
    fun showRewarded()
    fun showBanner()
}