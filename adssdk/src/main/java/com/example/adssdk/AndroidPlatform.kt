package com.example.adssdk

import android.content.Context
import android.os.Build
import com.example.adssdk.Adapter.BIDApplovinAdapter
import com.example.adssdk.Adapter.BannerAdEvents
import com.example.adssdk.Adapter.FullscreenAdEvents
import com.example.adssdk.Adapter.SDKEvents
import com.example.adssdk.Adapters.BIDBannerAdapterProtocol
import com.example.adssdk.Adapters.BIDFullscreenAdapterProtocol
import com.example.adssdk.Adapters.BIDNetworkAdapterDelegateProtocol
import com.example.adssdk.Adapters.BIDNetworkAdapterProtocol
import com.example.adssdk.Platform.Platform

class AndroidPlatform(val context: Context) : Platform {
    override val name: String
        get() = Build.MODEL+" "+Build.VERSION.RELEASE

    var networkSDKWrapperEvents: BIDNetworkAdapterProtocol = SDKEvents()
    var networkSDKWrapper: BIDNetworkAdapterDelegateProtocol? = null


    var interstitialAdWrapperEvents: BIDFullscreenAdapterProtocol = FullscreenAdEvents("interstitial")


    var bannerAdWrapperEvents: BIDBannerAdapterProtocol = BannerAdEvents("320x50")


    override fun start() {
        println("kotlin start")
        val applovinSDKWrapper = BIDApplovinAdapter(context ,networkSDKWrapperEvents, "UZ_qawd8zMTMchEft4waXI78B-JwSi3NAvu-PxDN62pWwiVI2fS4AWXUOrvv3nx5prC1KJJekHiduA0Ab4By2v")

    }

    override fun loadInterstitial() {

    }

    override fun loadRewarded() {

    }

    override fun loadBanner() {

    }

    override fun showInterstitial() {

    }

    override fun showRewarded() {

    }

    override fun showBanner() {

    }
}